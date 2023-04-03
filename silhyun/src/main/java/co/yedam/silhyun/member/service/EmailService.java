package co.yedam.silhyun.member.service;


import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class EmailService{
	private final JavaMailSender emailsender;
	
	private String ePw; //인증번호
	
	//메일 내용 
	@Async
	public MimeMessage createMessage(String to, String n) throws MessagingException, UnsupportedEncodingException {
		System.out.println("보내는 대상" + to);
		System.out.println("인증번호"+ ePw);
		
		MimeMessage message = emailsender.createMimeMessage();
		
		message.addRecipients(RecipientType.TO, to); //보내는 대상
		String msgg = "";
		
		if(n.equals("join")) {
			message.setSubject("실현하다 회원가입 이메일 인증"); //제목
			
			msgg += " <div"; 																																																	 
			msgg += "	style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; text-align: center; width: 800px; height: 600px; border-top: 4px solid #02b875; margin: 100px auto; padding: 30px 0; box-sizing: border-box;\">";		
			msgg += "	<h1 style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">";																															
			msgg += "		<span style=\"font-size: 15px; margin: 0 0 10px 3px;\">silhyun Hada</span><br />";																													
			msgg += "		<span style=\"color: #02b875\">메일인증</span> 안내입니다.</h1>\n";																																				
			msgg += "	</h1>\n";																																																		
			msgg += "	<p style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">";																																																																								 
			msgg += "		실현하다에 가입해 주셔서 진심으로 감사드립니다.<br />";																																						
			msgg += "		아래 <b style=\"color: #02b875\">'인증코드'</b> 를 회원가입 창으로 돌아가 입력해 주세요.<br />";																																																																												
			msgg += "	</p>";																																																	
			msgg += "   <h3 style='color:#02b875;'>회원가입 인증 코드입니다.</h3>";
			msgg += "   <div style='font-size:130%'>";
			msgg += "    CODE : <strong>";
			msgg += ePw + "</strong><div><br/> ";																																										
			msgg += "	<div style=\"border-top: 1px solid #DDD; padding: 5px;\"></div>";																															
			msgg += " </div>";
			
		}else if(n.equals("pwdCk")) {
			message.setSubject("실현하다 임시 비밀번호"); //제목
			
			msgg += " <div"; 																																																	 
			msgg += "	style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; text-align: center; width: 800px; height: 600px; border-top: 4px solid #02b875; margin: 100px auto; padding: 30px 0; box-sizing: border-box;\">";		
			msgg += "	<h1 style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">";																															
			msgg += "		<span style=\"font-size: 15px; margin: 0 0 10px 3px;\">silhyun Hada</span><br />";																													
			msgg += "		<span style=\"color: #02b875\">임시비밀번호</span> 입니다.</h1>\n";																																				
			msgg += "	</h1>\n";																																																		
			msgg += "	<p style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">";																																																																								 
			msgg += "		임시 비밀번호로 로그인 후 반드시 비밀번호를 수정해 주세요<br />";																																																																																																																	
			msgg += "	</p>";																																																	
			msgg += "   <h3 style='color:#02b875;'>임시 비밀번호 입니다.</h3>";
			msgg += "   <div style='font-size:130%'>";
			msgg += "    CODE : <strong>";
			msgg += ePw + "</strong><div><br/> ";																																										
			msgg += "	<div style=\"border-top: 1px solid #DDD; padding: 5px;\"></div>";																															
			msgg += " </div>";
		}
		message.setText(msgg, "utf-8", "html");		
		//보내는 사람 이메일주소, 보내는 사람 이름
		message.setFrom(new InternetAddress("silhyunhada@gmail.com", "실현하다"));
		
		return message;
	}
	
	//랜덤숫자 생성
	@Async
	public String createKey() {
		StringBuffer key = new StringBuffer();
		Random rnd = new Random();
		
		for(int i = 0; i < 10; i++) {
			int index = rnd.nextInt(4); //0~3
			
			switch (index) {
			case 0:
				key.append((char) ((int) (rnd.nextInt(26)) + 97));
				// a~z (ex. 1+97=98 => (char)98 = 'b')
				break;
			case 1:
				key.append((char) ((int) (rnd.nextInt(26)) + 65));
				// A~Z
				break;
			case 2:
				key.append((rnd.nextInt(10)));
				// 0~9
				break;
			case 3:
				key.append((char) ((int) (rnd.nextInt(6)) + 33));
				// 0~9
				break;
			}
		}
		
		return key.toString();
	}
	
	//메일발송
	@Async
	public String sendSimpleMessage(String to, String n) {
		
		ePw = createKey();
		
		try {
			MimeMessage message = createMessage(to, n);
			emailsender.send(message);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			ePw = "err";
		} catch (MessagingException e) {
			e.printStackTrace();
			ePw = "err";
		}
		
		
		return ePw;
	}
}

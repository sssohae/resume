package co.yedam.silhyun;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import co.yedam.silhyun.member.service.OAuthUserService;
import lombok.RequiredArgsConstructor;



@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig{
	
	private final OAuthUserService userService;  //로그인 api디비 연결
	private final AuthenticationFailureHandler failureHandler;
	


	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};
    
	//rememberMe
	private final DataSource dataSource;
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource); //내꺼랑 연결
		return repo;
	}
	
	
	//페이지 권한 설정
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable() 
			.authorizeHttpRequests()
				.antMatchers("/", "/home", "/silhyun/**", "/img/**","/css/**", "/fonts/**"
						, "/js/**", "/saveImg/**", "/vendor/**", "/scss/**", "/manage/**").permitAll() //모든권한
				.antMatchers("/pay/**", "/shin/**", "/zzim/**").authenticated() //로그인 필요 페이지
			.and()
			.rememberMe() //자동로그인
				.tokenValiditySeconds(86400 + 43200) //토큰 유효시간 36시간
				.rememberMeParameter("remember-me")
				.tokenRepository(persistentTokenRepository())
			.and()
			.logout()
				.logoutSuccessUrl("/")
				.deleteCookies("JSESSIONID", "remember-me") //로그아웃시 자동로그인 삭제
			.and()
			.formLogin()
				.loginPage("/login")
				.successHandler(new CustomLoginSuccessHandler())
				.failureHandler(failureHandler)
				.permitAll()
			.and()
			.oauth2Login() //소셜로그인
			     .loginPage("/login/oauth")
				.permitAll()
				.userInfoEndpoint()
				.userService(userService);
			


		return http.build();
	}

	

}
package co.yedam.silhyun.member.vo;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserVO implements UserDetails {
	
	private String id;
	private String pwd;
	private String memCd;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singletonList(new SimpleGrantedAuthority(this.memCd));
	}

	@Override
	public String getPassword() {
		
		return this.pwd;
	}

	@Override
	public String getUsername() {
		
		return this.id;
	}

	@Override
	public boolean isAccountNonExpired() { //계정 만료
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {  //로그인막기
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		
		return this.memCd.equals("M4") ? false : true;
	}

}

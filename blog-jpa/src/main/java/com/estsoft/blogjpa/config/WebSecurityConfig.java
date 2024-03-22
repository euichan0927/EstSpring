package com.estsoft.blogjpa.config;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.*;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.estsoft.blogjpa.service.UserDetailService;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

	// @Bean
	// public WebSecurityCustomizer configure() {      // 스프링 시큐리티 기능 비활성화
	// 	return web -> web.ignoring().requestMatchers(toH2Console())
	// 		.requestMatchers("/static/**");
	// }

	// 특정 HTTP 요청에 대한 웹 기반 보안 구성
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(auth ->              // 인증, 인가 설정
				auth.requestMatchers("/login", "/signup", "/user").permitAll()
					.anyRequest().authenticated())
			.formLogin(auth -> auth.loginPage("/login")     // 폼 기반 로그인 설정
				.defaultSuccessUrl("/thymeleaf/articles"))
			.logout(auth -> auth.logoutSuccessUrl("/login") // 로그아웃 설정
				.invalidateHttpSession(true))
			.csrf(auth -> auth.disable());                  // csrf 비활성화
		return httpSecurity.build();
	}

	// 패스워드 인코더로 사용할 빈 등록
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public WebSecurityCustomizer configure() {      // 스프링 시큐리티 기능 비활성화
		return web -> web.ignoring().requestMatchers("/static/**", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html");
	}

}

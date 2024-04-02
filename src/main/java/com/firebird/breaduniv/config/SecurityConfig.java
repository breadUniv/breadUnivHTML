package com.firebird.breaduniv.config;

import com.firebird.breaduniv.config.handler.AuthFailHandler;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 사용자가 인증 실패시 처리해야 할 동작을 정의한 클래스
    private final AuthFailHandler authFailHandler;

    // 사용자가 인증에 실패했을 때 어떤 동작을 실행할지 (SecurityConfig에서 AuthFailHandler 객체 사용)
    public SecurityConfig(AuthFailHandler authFailHandler) {
        this.authFailHandler = authFailHandler;
    }

    // 비밀번호를 저장, 인증하는데 사용하는 PasswordEncoder를 빈으로 등록
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 정적 리소스 설정 제외 처리
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http// 페이지 권한 설정
                .authorizeHttpRequests(auth ->{
//                    auth.requestMatchers("/notice/*", "/board/*", "/thumbnail/**").hasAnyAuthority("ROLE_STUDENT", "ROLE_PROFESSOR", "ROLE_ADMIN");
//                    auth.requestMatchers("/notice/regist").hasAnyAuthority("ROLE_ADMIN");
                    auth.requestMatchers("/*", "/member/*", "Notice/*").permitAll();// 모든 리소스를 권한 없이 사용가능
                    auth.anyRequest().authenticated();
                })

                // 로그인 설정
                .formLogin(login -> {
                    login.loginPage("/login");   //커스텀 로그인 페이지 사용
                    login.usernameParameter("memberId"); // 사용자 id 입력 필드 (input의 name과 일치)
                    login.passwordParameter("memberPwd"); // 사용자 pass 입력 필드 (input의 name과 일치)
                    login.defaultSuccessUrl("/");  //로그인 성공시 이동 페이지
                    login.failureHandler(authFailHandler); // auth
                })

                // 로그아웃 설정
                .logout(logout ->{
                    logout.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout")); // 로그아웃 요청 url
                    logout.deleteCookies("JSESSIONID"); // 로그아웃 시 사용자의 JSESSIONID 삭제
                    logout.invalidateHttpSession(true); // 서버 세션 소멸처리
                    logout.logoutSuccessUrl("/"); // 로그아웃 성공시 이동할 페이지
                })
                // 세션설정
                .sessionManagement(session ->{
                    session.maximumSessions(1); // 세션 개수 제한
                    session.invalidSessionUrl("/"); // 세션 만료시 이동할 url
                })
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}

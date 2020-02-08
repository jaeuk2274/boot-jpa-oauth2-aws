package bootJpaAws.config.auth;

import bootJpaAws.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // 스프링 시큐리티 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("configure");
        http
                .csrf().disable() // h2-console 화면 사용을 위해 해당 옵션 disable
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests() // url별 권한 관리를 설정하는 옵션의 시작점
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll() // 전체 열람 권한
                //.antMatchers("/api/v1/**").hasRole(Role.USER.name()) // user 권한
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // user 권한
                .anyRequest().authenticated() // 나머지 url은 인증된 사용자들만 허용
                .and()
                .logout()
                .logoutSuccessUrl("/") // 로그아웃 기능에 대한 설정 진입점, 로그아웃 성공시 / 주소로 이동
                .and()
                .oauth2Login() // OAuth2 로그인 기능에 대한 여러 설정의 진입점.
                .userInfoEndpoint() // 로그인 성공 이후 사용자 정보를 가져올 때의 설정 담당.
                .userService(customOAuth2UserService); // 소셜 로그인 성공 이후 후속 조치를 진행할 UserSerivce 인터페이스의 구현체를 등록한다.
                // 리소스 서버(소셜 서비스 등) 에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능들을 명시 가능
    }
}


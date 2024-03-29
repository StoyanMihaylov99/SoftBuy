package com.example.softwareecommers.security;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;


    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.
                // define which requests are allowed and which not
                        authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    // everyone can download static resources (css, js, images)
                    authorizationManagerRequestMatcherRegistry.requestMatchers(String.valueOf(PathRequest.toStaticResources().atCommonLocations())).permitAll()
                            // everyone can log in and register
                            .requestMatchers("/", "/user/login", "/user/register").permitAll()
                            // pages available only for moderators
                            .requestMatchers("/pages/moderators").hasRole("ADMIN")
                            // all other pages are available for logged-in users
                            .anyRequest()
                            .authenticated();
                })
                // the custom login form
                .formLogin(httpSecurityFormLoginConfigurer -> {
            httpSecurityFormLoginConfigurer
                    // configuration of form login
                    .loginPage("/user/login")
                    // the name of the username form field
                    .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                    // the name of the password form field
                    .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                    // where to go in case that the login is successful
                    .defaultSuccessUrl("/", true)
                    // where to go in case that the login failed
                    .failureForwardUrl("/users/login");
        })
                // configure logout
                .logout(httpSecurityLogoutConfigurer -> {
                    // which is the logout url
                    httpSecurityLogoutConfigurer.logoutUrl("/users/logout")
                            // invalidate the session and delete the cookies
                            .invalidateHttpSession(true)
                            .deleteCookies("JSESSIONID");
                });

        return http.build();
    }




    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/resources/**", "/static/**", "/images/**", "/productImages/**", "/css/**", "/js/**");
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}

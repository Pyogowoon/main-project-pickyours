package com.pyo.yourspick.config;


import com.pyo.yourspick.config.oauth.Oauth2DetailsService;
import com.pyo.yourspick.handler.ex.CustomValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final Oauth2DetailsService oauth2DetailsService;

    private final AuthenticationFailureHandler customLoginValidationException;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/board", "/auth/**", "/images/**", "/js/**", "/webjars/**", "/css/**", "/vendor/**"
                        , "/fonts/**", "/plugins/**", "/scss/**", "/post","/post/search/**", "/upload/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/auth/signin")
                .loginProcessingUrl("/auth/signin")
                .failureHandler(customLoginValidationException)
                .defaultSuccessUrl("/")
                .and()
                .logout()
                .logoutSuccessUrl("/")


                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(oauth2DetailsService);

        return http.build();
    }


    @Bean
    public BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder();


    }
}



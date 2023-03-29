package com.pyo.yourspick.config;

/*
 *  JWT 사용시 Security Config 입니다.
 *
 */

/*
@Configuration
@EnableWebSecurity
public class JwtSecurityConfig {
 // 시큐리티 활성화 -> 기본 스프링 필터체인에 등록


        @Autowired
        private UserRepository userRepository;

        @Autowired
        private CorsConfig corsConfig;

        @Bean
        SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            return http
                    .csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .formLogin().disable()
                    .httpBasic().disable()
                    .apply(new MyCustomDsl()) // 커스텀 필터 등록
                    .and()
                    .authorizeRequests(authroize -> authroize.antMatchers("/api/v1/user/**")
                            .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                            .antMatchers("/api/v1/manager/**")
                            .access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                            .antMatchers("/api/v1/admin/**")
                            .access("hasRole('ROLE_ADMIN')")
                            .anyRequest().permitAll())
                    .build();
        }

        public class MyCustomDsl extends AbstractHttpConfigurer<MyCustomDsl, HttpSecurity> {
            @Override
            public void configure(HttpSecurity http) throws Exception {
                AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
                http
                        .addFilter(corsConfig.corsFilter())
                        .addFilter(new JwtAuthenticationFilter(authenticationManager))
                        .addFilter(new JwtAuthorizationFilter(authenticationManager,userRepository));
            }
        }

    }
}

 */
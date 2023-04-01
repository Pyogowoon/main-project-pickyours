package com.pyo.yourspick.config;

/* 일시적으로 중지
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 내 서버가 응답할때 Json 을 자바스크립트에서 처리할 수 있게 할지를 설정
        //설정 해야 Ajax에 요청 가능
        config.addAllowedOrigin("*"); // 모든 ip에 응답을 허용
        config.addAllowedHeader("*"); // 모든 header에 응답을 허용
        config.addAllowedMethod("*"); // 모든 Post, Get, Put, Delete, Patch 요청을 허용하겠다
        source.registerCorsConfiguration("/api/**", config);
        return new CorsFilter(source);

    }
}
*/

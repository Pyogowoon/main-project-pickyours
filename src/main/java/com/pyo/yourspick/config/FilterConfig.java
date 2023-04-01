package com.pyo.yourspick.config;



/*
@Configuration
public class FilterConfig {



        //security config 에도 필터를 거는 방식이 있지만 굳이 그럴필요는 없다
        @Bean
        public FilterRegistrationBean<MyFilter1> filter1(){
            FilterRegistrationBean<MyFilter1> bean = new FilterRegistrationBean<>(new MyFilter1());

            bean.addUrlPatterns("/*");
            bean.setOrder(1); // 번호가 낮을수록 먼저 실행됨.
            return bean;

        }

        @Bean
        public FilterRegistrationBean<MyFilter2> filter2(){
            FilterRegistrationBean<MyFilter2> bean = new FilterRegistrationBean<>(new MyFilter2());

            bean.addUrlPatterns("/*");
            bean.setOrder(0); // 번호가 낮을수록 먼저 실행됨.
            return bean;

        }

    }

}
*/
//package com.plateer.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfiguration implements WebMvcConfigurer {
//
//    private static final String[] EXCLUDE_PATHS = {
//  //          "/api/user/**"
//            "/api/user/login"
//    };
//
//    private JwtInterceptor jwtInterceptor;
//
//    public WebConfiguration(JwtInterceptor jwtInterceptor) {
//        this.jwtInterceptor = jwtInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jwtInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns(EXCLUDE_PATHS);
//    }
//}

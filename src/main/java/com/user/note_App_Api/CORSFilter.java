package com.user.note_App_Api;

	import java.io.IOException;

import javax.servlet.FilterChain;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.reactive.config.CorsRegistry;

	    @Configuration
	    public class CORSFilter extends CorsFilter {

	        public CORSFilter(CorsConfigurationSource source) {
	            super((CorsConfigurationSource) source);
	        }

	        @Override
	        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	                throws ServletException, IOException {

	            response.addHeader("Access-Control-Allow-Headers",
	                    "Access-Control-Allow-Origin, Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
	            if (response.getHeader("Access-Control-Allow-Origin") == null)
	                response.addHeader("Access-Control-Allow-Origin", "*");
	            response.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
	            filterChain.doFilter(request, response);
	        }
	        @Bean
	        public CorsFilter corsFilter() {
	            final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	            final CorsConfiguration config = new CorsConfiguration();
	            config.setAllowCredentials(true);
	            config.addAllowedOrigin("*");
	            config.addAllowedHeader("*");
	            config.addAllowedMethod("OPTIONS");
	            config.addAllowedMethod("HEAD");
	            config.addAllowedMethod("GET");
	            config.addAllowedMethod("PUT");
	            config.addAllowedMethod("POST");
	            config.addAllowedMethod("DELETE");
	            config.addAllowedMethod("PATCH");
	            source.registerCorsConfiguration("/**", config);
	            return new CorsFilter(source);
	        }
	        
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	            .allowedOrigins("*")
	            .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
	        }
	    };
	        
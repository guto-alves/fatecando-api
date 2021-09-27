package com.gutotech.fatecandoapi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class OAuth2ServerConfiguration {
	
    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
        @Override
        public void configure(HttpSecurity http) throws Exception {
        	http
            .authorizeRequests()
	            .antMatchers(HttpMethod.GET, "/api/subjects")
	            	.permitAll()
            	.antMatchers(HttpMethod.POST, "/api/users", "/api/users/login")
            		.permitAll()
            	.anyRequest()
 	            	.authenticated()
 	            	.and()
                .logout()
	                .invalidateHttpSession(true)
	                .clearAuthentication(true)
	                .deleteCookies("JSESSIONID")
	                .permitAll()
	                .and()
                .csrf()
                    .disable()
                .cors()
                	.disable()
                .headers()
                	.frameOptions()
                		.disable();
        }
    }
}

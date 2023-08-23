
package com.nnk.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    //@Autowired
    private AccessDeniedHandler accessDeniedHandler;


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest()
                //.authenticated()
                .permitAll()
                .and()
                .formLogin()
                .permitAll()
                .defaultSuccessUrl("/bidList/list")
                //.failureUrl("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutUrl("/app/login")
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }


}

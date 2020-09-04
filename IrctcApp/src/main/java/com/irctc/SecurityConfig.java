package com.irctc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
        authentication.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("user"))
                .authorities("ROLE_USER")
                .and().withUser("admin").password(passwordEncoder().encode("admin"))
                .authorities("ROLE_USER", "ROLE_ADMIN")
       
        ;
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic().and().authorizeRequests().antMatchers("/irctc/welcome").permitAll()
                .antMatchers(HttpMethod.POST, "/irctc/*").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/irctc/*").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/irctc/routes/trains").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/irctc/*").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/irctc/*").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/routes/*/trains").hasAnyRole("USER", "ADMIN")
                .antMatchers("/swagger-ui.html", "/swagger-resources/**").permitAll().anyRequest().authenticated().and()
                .csrf().disable().formLogin().disable();
    }
}
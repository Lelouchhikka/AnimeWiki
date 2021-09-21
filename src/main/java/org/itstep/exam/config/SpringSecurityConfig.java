package org.itstep.exam.config;

import org.itstep.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,proxyTargetClass = true,securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserService service;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/css/**","/js/**").permitAll().antMatchers("/")
                .permitAll();
        http.formLogin().loginProcessingUrl("/auth").permitAll().loginPage("/").permitAll()
                .usernameParameter("username").passwordParameter("password").failureUrl("/login-error").defaultSuccessUrl("/").permitAll();
        http.logout().permitAll().logoutUrl("/auth/logout").logoutSuccessUrl("/login").permitAll();
    }


    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    // создаем пользоватлелей, admin и user
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user@m.ru").password("{noop}password").roles("USER");
    }
}

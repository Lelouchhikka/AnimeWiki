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
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,proxyTargetClass = true,securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService service;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/css/**","/js/**").permitAll().antMatchers("/")
                .permitAll();
        http.formLogin().loginProcessingUrl("/auth").permitAll().loginPage("/").permitAll()
                .usernameParameter("email").passwordParameter("password").failureUrl("/login").defaultSuccessUrl("/").permitAll();
        http.logout().permitAll().logoutUrl("/auth/logout").logoutSuccessUrl("/login").permitAll().and()
                 .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(service);}
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(service);

    }



    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }
    // создаем пользоватлелей, admin и user

}

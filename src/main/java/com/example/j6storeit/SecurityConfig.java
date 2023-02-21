package com.example.j6storeit;

import com.example.j6storeit.entity.Account;

import com.example.j6storeit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AccountService accountService;
    @Autowired
    BCryptPasswordEncoder pe;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            try {
                Account user = accountService.findById(username);
                String password = pe.encode(user.getPassword());
                String[] roles = user.getAuthorities().stream()
                        .map(er ->er.getRole().getId())
                        .collect(Collectors.toList()).toArray(new String[0]);

                return User.withUsername(username).password(password).roles(roles).build();
            }catch (NoSuchElementException e){

                throw new UsernameNotFoundException(username+ "not found!");

            }
        });
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/order/**").authenticated()
                .antMatchers("/assets/admin/**").authenticated()
                .antMatchers("/admin/**").hasAnyRole("STAF","DIRE")
                .antMatchers("/rest/authorities").hasRole("DIRE")
                .anyRequest().permitAll();
        http.formLogin()
                .loginPage("/security/login/form")
                .loginProcessingUrl("/security/login")
                .defaultSuccessUrl("/security/login/success",false)
                .failureUrl("/security/login/error");
        http.rememberMe()
                .tokenValiditySeconds(86400);
        http.exceptionHandling()
                .accessDeniedPage("/security/unauthoried");
        http.logout()
                .logoutUrl("/security/logoff")
                .logoutSuccessUrl("/security/logoff/success");

    }

    //Mã hóa mật khẩu
    @Bean
    public BCryptPasswordEncoder getPassword() {
        return new BCryptPasswordEncoder();
    }
    //Cho phép truy xuất REST API từ bên ngoài(domain khác)
    @Override
    public void configure( WebSecurity web) throws Exception {
        System.out.println("Chạy tới confi 2");
        web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
    }


}

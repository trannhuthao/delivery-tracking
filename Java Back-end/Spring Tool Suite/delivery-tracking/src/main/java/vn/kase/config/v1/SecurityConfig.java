package vn.kase.config.v1;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("abcexpress").password("abcexpress").roles("PROGRAMMER")
                .and()
                .withUser("hieu").password("hieu").roles("PROGRAMMER")
                .and()
                .withUser("hao").password("hao").roles("PROGRAMMER")
                .and()
                .withUser("cuong").password("cuong").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/", "/about", "/contact", "/resources/**").permitAll()
                .antMatchers("/shipping-packages", "/shipping-packages/add", "/shipping-packages/detail").hasAnyRole("PROGRAMMER", "USER")
                .antMatchers("/**").hasRole("PROGRAMMER")
                .and().formLogin()
                .and().exceptionHandling().accessDeniedPage("/403");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

//    @Bean
//    public StandardPasswordEncoder getStandardPasswordEncoder() {
//        return new StandardPasswordEncoder();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public Pbkdf2PasswordEncoder getPbkdf2PasswordEncoder() {
//        return new Pbkdf2PasswordEncoder();
//    }
//
//    @Bean
//    public SCryptPasswordEncoder getSCryptPasswordEncoder() {
//        return new SCryptPasswordEncoder();
//    }
}
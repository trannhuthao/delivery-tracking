package vn.kase.config.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

//    @Bean
//    public StandardPasswordEncoder getStandardPasswordEncoder() {
//        return new StandardPasswordEncoder();
//    }

//    @Bean
//    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    public Pbkdf2PasswordEncoder getPbkdf2PasswordEncoder() {
//        return new Pbkdf2PasswordEncoder();
//    }

//    @Bean
//    public SCryptPasswordEncoder getSCryptPasswordEncoder() {
//        return new SCryptPasswordEncoder();
//    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsServiceImpl();
//    }

//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
//        daoAuthenticationProvider.setPasswordEncoder(getBCryptPasswordEncoder());
//
//        return daoAuthenticationProvider;
//    }

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

//        authenticationManagerBuilder.authenticationProvider(this.daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/", "/about", "/contact", "/resources/**").permitAll()
                .antMatchers("/shipping-packages", "/shipping-packages/add", "/shipping-packages/detail").hasAnyRole("PROGRAMMER", "USER")
                .antMatchers("/**").hasRole("PROGRAMMER")
                .anyRequest().authenticated()
                .and().formLogin().defaultSuccessUrl("/").permitAll()
                .and().logout().permitAll()
                .and().exceptionHandling().accessDeniedPage("/403");
    }
}
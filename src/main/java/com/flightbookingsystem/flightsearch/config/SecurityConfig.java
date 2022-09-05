package com.flightbookingsystem.flightsearch.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.flightbookingsystem.flightsearch.filters.JwtFilter;
import com.flightbookingsystem.flightsearch.services.MyUserDetailsService;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
   private JwtFilter jwtFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/info").permitAll()
                .antMatchers(HttpMethod.GET,"/search").permitAll()
                .antMatchers(HttpMethod.POST,"/search").permitAll()
                .antMatchers(HttpMethod.GET,"/api/search/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api/delete/{id}").permitAll()
                .antMatchers(HttpMethod.PUT,"/api/update/{id}").permitAll()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/token").permitAll()
                .anyRequest().permitAll()
                .and()
                .httpBasic();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
      
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

   /* @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.GET,"/info")
                .antMatchers(HttpMethod.POST, "/authenticate");
    }*/

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager getAuthenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }
}

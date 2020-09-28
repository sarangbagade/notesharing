package com.scaleup.notesharing.config;

import com.scaleup.notesharing.auth.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService customeUserDetailsService;

    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable();
//        http
//                .authorizeRequests()
//                .antMatchers("/dev_test/*").permitAll()
//                .antMatchers("/api_check/*").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin().permitAll()
//                .and().logout().permitAll();
        http.csrf().disable()
		// dont authenticate this particular request
		.authorizeRequests().antMatchers("/gui/v1/**",
				"/",
				"/login",
				"/authenticate",
				"/register",
				"/home",
				"/resources/**",
				"/favicon.ico").
		permitAll().
		antMatchers(HttpMethod.OPTIONS, "/**")
		.permitAll().
	
		// all other requests need to be authenticated
		anyRequest().authenticated().and().
		  logout().logoutUrl("/logout").logoutSuccessUrl("/login").deleteCookies("auth_code", "JSESSIONID").invalidateHttpSession(true)
//		  .and().
		// make sure we use stateless session; session won't be used to
		// store user's state.
		//exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
//		 .sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(5);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(customeUserDetailsService).passwordEncoder(passwordEncoder());
    }
}

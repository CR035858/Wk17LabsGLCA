package com.gl.tdms.labwk17d02dem1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.gl.tdms.labwk17d02dem1.service.UserDetailsServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	 	@Bean
	    public UserDetailsService userDetailsService() {
	        return new UserDetailsServiceImpl();
	    }
	     
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	     
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	        return authProvider;
	    }
	 
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	    }
	
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	  http.authorizeRequests()
	            .antMatchers("/","/teachers/save","/teachers/showFormForAdd","/teachers/403").hasAnyAuthority("USER","ADMIN")
	            .antMatchers("/teachers/showFormForUpdate","/teachers/delete").hasAuthority("ADMIN")
	            .anyRequest().authenticated()
	            .and()
	            .formLogin().loginProcessingUrl("/login").successForwardUrl("/teachers/allTeacherDetails").permitAll()
	            .and()
	            .logout().logoutSuccessUrl("/login").permitAll()	            
	            .and()
	            .exceptionHandling().accessDeniedPage("/teachers/403")
	            .and()
	            .cors().and().csrf().disable();
	    }

}

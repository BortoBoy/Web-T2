package br.ufscar.dc.dsw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.ufscar.dc.dsw.security.UserDetailsServiceImpl;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthenticationSuccessHandler successHandler;
	
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
    	http.csrf().disable().authorizeRequests()
	    	.antMatchers(HttpMethod.GET, "/medicos/**", "/pacientes/**").permitAll()
	    	.antMatchers(HttpMethod.POST, "/medicos/**", "/pacientes/**").permitAll()
	    	.antMatchers(HttpMethod.PUT, "/medicos/**", "/pacientes/**").permitAll()
	    	.antMatchers(HttpMethod.DELETE, "/medicos/**", "/pacientes/**").permitAll()
	    	.antMatchers("/admin/**").hasRole("ADMIN")
	   		.antMatchers("/", "/login/**", "/login/**", "/js/**", "/css/**").permitAll()
          	.antMatchers("/image/**", "/webjars/**").permitAll()
	   		.anyRequest().authenticated()
	   	.and()
	   		.formLogin()
	   		.loginPage("/login")
	   		.successHandler(successHandler)
	   		.permitAll()
	   	.and()
		   	.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		   	.logoutSuccessUrl("/").deleteCookies("JSESSIONID")
		   	.invalidateHttpSession(true);
    }
}
package com.emigate.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Bean
	UtilisateurDetailService uDs(){
		return new UtilisateurDetailService();
	}
	

	@Autowired
	private UtilisateurDetailService uDs;
	
	@Autowired
    DataSource dataSource;

	
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.jdbcAuthentication().dataSource(dataSource)
         .usersByUsernameQuery("select email,motdepasse,id from utilisateur where email=?")
         .authoritiesByUsernameQuery("select username, role from users_role where username=?");
	}
	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/inscription")
        .permitAll()
                            .anyRequest()
                            .authenticated()
                        .and()
                            .formLogin()
                                .loginPage("/login")
                                .permitAll()
                        .and()
                            .rememberMe()
                                .rememberMeCookieName("remember-me")
                                .tokenValiditySeconds(24 * 60 * 60)
                        .and()
                            .logout()
                            .permitAll();
        
        http.csrf().disable();
    }
 

}

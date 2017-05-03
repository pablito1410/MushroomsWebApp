package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pl.polsl.mushrooms.infrastructure.authentication.JwtAuthenticationFilter;
import pl.polsl.mushrooms.infrastructure.authentication.JwtLoginFilter;

/**
 * Created by pawel_zaqkxkn on 30.03.2017.
 */
@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers( "/#").permitAll()
            .antMatchers(HttpMethod.POST, "/api/users").permitAll()
            .antMatchers(  "/app/*.{js}", "/*.{js}", "/assets/**").permitAll()
            .anyRequest().fullyAuthenticated()
            .and()
            .formLogin()
            .loginProcessingUrl("/login")
            .failureUrl("/login?error")
            .usernameParameter("email")
            .permitAll()
            .and()
            .logout()
            .logoutUrl("/logout")
            .deleteCookies("remember-me")
            .logoutSuccessUrl("/")
            .permitAll()
            .and()
            .rememberMe()
            .and()
            // We filter the api/login requests
            .addFilterBefore(new JwtLoginFilter("/login", authenticationManager()),
                    UsernamePasswordAuthenticationFilter.class)
            // And filter other requests to check the presence of JWT in header
            .addFilterBefore(new JwtAuthenticationFilter(),
                    UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.inMemoryAuthentication()
            .withUser("admin")
            .password("password")
            .roles("ADMIN");
    }
}

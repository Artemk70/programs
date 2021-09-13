package main.config;

import main.model.Role;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configurable
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.GET, "/todolist/").hasRole(Role.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/todolist/").hasRole(Role.ADMIN.name())
                .antMatchers(HttpMethod.PUT, "/todolist/").hasRole(Role.ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/todolist/").hasRole(Role.ADMIN.name())
                .antMatchers(HttpMethod.PUT, "/todolist/**").hasRole(Role.ADMIN.name())
                .antMatchers(HttpMethod.GET, "/todolist/**").hasRole(Role.ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/todolist/**").hasRole(Role.ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("administrator---"))
                        .roles(Role.ADMIN.name())
                        .build()
        );
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}

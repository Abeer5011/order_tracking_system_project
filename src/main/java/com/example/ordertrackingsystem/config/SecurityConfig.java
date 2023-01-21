package com.example.ordertrackingsystem.config;
import com.example.ordertrackingsystem.services.MyUserDetail;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetail myUserDetail;

    public SecurityConfig(MyUserDetail myUserDetail) {
        this.myUserDetail = myUserDetail;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetail).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.cors().and().csrf().disable().authorizeRequests()
               .antMatchers(new String[] {"/api/v1/auth/admin_register",
                       "/api/v1/auth/register",
                       "/api/v1/orders/addOrder/**",
                       "/api/v1/products" }).permitAll()
               .antMatchers(HttpMethod.POST,"/api/v1/add_product").hasAuthority("ADMIN")
               .antMatchers(new String[]{"/api/v1/auth/admin_login",
                       "/api/v1/auth/customers" }).hasAuthority("ADMIN")
               .and()
               .logout().logoutRequestMatcher(new AntPathRequestMatcher("/api/v1/auth/logout"))
               .clearAuthentication(true).invalidateHttpSession(true).deleteCookies("JSESSIONID")
               .and().httpBasic();

    }
}

package pl.javawwa.odersapp.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.javawwa.odersapp.providers.CustomerDatabaseAutenticationProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomerDatabaseAutenticationProvider customerDatabaseAutenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/customers/register", "/customers/activate").permitAll()
                .antMatchers("/cutomers/loggedIn").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/customers/login")
                .usernameParameter("customerLogin")
                .passwordParameter("customerPassword")
                .loginProcessingUrl("/customers/login")
                .defaultSuccessUrl("/customers/logedIn")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(customerDatabaseAutenticationProvider);
    }
}
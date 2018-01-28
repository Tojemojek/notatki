package pl.javawwa.odersapp.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import pl.javawwa.odersapp.services.CustomerService;

import java.util.ArrayList;

@Component
public class CustomerDatabaseAutenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomerService customerService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String login = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (customerService.authenticate(login, password)) {
            return new UsernamePasswordAuthenticationToken(login, password, new ArrayList<>());
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

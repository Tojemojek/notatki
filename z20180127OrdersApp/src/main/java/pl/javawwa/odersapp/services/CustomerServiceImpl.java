package pl.javawwa.odersapp.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.javawwa.odersapp.converters.CustomerConverter;
import pl.javawwa.odersapp.dto.CustomerDto;
import pl.javawwa.odersapp.entities.Customer;
import pl.javawwa.odersapp.entities.CustomerStatus;
import pl.javawwa.odersapp.repositories.CustomerRepository;

import java.util.Locale;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private EmailService emailService;

    @Autowired
    private MessageSource messageSource;

    @Override
    public void registerUser(CustomerDto customerDto) {

        Customer converted = customerConverter.convert(customerDto);
        converted.setStatus(CustomerStatus.NEW);

        customerRepository.save(converted);

        String serviceURI = "http://localhost:8081/customers/activate";
        String mailTitle = messageSource.getMessage("registration.mail.title", new Object[]{customerDto.getFirstName()}, Locale.getDefault());
        String mailBody = "To jest mail aktywacyjny, kliknij w link aby aktywować "
                + serviceURI
                + "?login=" + customerDto.getLogin()
                + "&token=" + converted.getToken();

        emailService.sendEmail(customerDto.getEmail(), mailTitle, mailBody);
    }

    @Override
    @Transactional
    public Boolean activateUser(String login, String token) {
        Customer customer = customerRepository.findOneByLoginAndTokenAndStatus(login, token, CustomerStatus.NEW);

        if (customer == null) {
            return false;
        } else {
            customer.setStatus(CustomerStatus.ACTIVE);
            customerRepository.save(customer);
            return true;
        }
    }

    @Override
    public boolean authenticate(String login, String password) {

        password = DigestUtils.md5Hex(password);

        Customer customer = customerRepository.findOneByLoginAndPasswordAndStatus(login, password, CustomerStatus.ACTIVE);

        return customer != null ? true : false;

    }
}

import hello.controllers.CustomerController;
import hello.domain.DAO.model.Customer;
import hello.services.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ConsumerTest {
    private static final long MOCKED_CUSTOMER_ID = 4898;
    private static final HttpStatus STATUS_CODE_SUCESS = HttpStatus.OK;
    @Mock
    CustomerService customerService;
    @InjectMocks
    CustomerController customerController;
    @Test
    public void controllerTestGet () {
        final Customer customer = mockCustomer();
        Mockito.when(customerService.getCustomer(MOCKED_CUSTOMER_ID)).thenReturn(customer);
        final ResponseEntity<Customer> customerResponseEntity = customerController.getCustomer(MOCKED_CUSTOMER_ID);

        assertEquals(customerResponseEntity.getBody(),customer);
        assertEquals(customerResponseEntity.getStatusCode(),STATUS_CODE_SUCESS);
    }

    private Customer mockCustomer() {
        final Customer customer = new Customer(MOCKED_CUSTOMER_ID,"8AACVD",25);
        return customer;
    }
}

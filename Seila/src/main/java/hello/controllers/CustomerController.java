package hello.controllers;

import hello.domain.DAO.model.Customer;
import hello.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public void customer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @RequestMapping(value = "/customer/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id){
        if (customerService.getCustomer(id) == null)
        {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Customer>(customerService.getCustomer(id),HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/customer",method = RequestMethod.PUT)
    public void putCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @RequestMapping(value = "/customer/{id}",method = RequestMethod.DELETE)
    public void delCustomer(@PathVariable("id")long id){
        customerService.delCustomer(id);
    }

}

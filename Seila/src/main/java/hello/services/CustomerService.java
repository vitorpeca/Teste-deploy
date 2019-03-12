package hello.services;

import hello.domain.DAO.dao.CostumerDao;
import hello.domain.DAO.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    CostumerDao costumerDao;
    @Autowired
    public CustomerService(final CostumerDao costumerDao) {
        this.costumerDao = costumerDao;
    }

    public void addCustomer(Customer customer){
        costumerDao.save(customer);
    }
    public Customer getCustomer(long id){
        return costumerDao.getCustomer(id);
    }

    public void updateCustomer(Customer customer){
       costumerDao.updateCustomer(customer);
    }

    public void delCustomer(long id){
        costumerDao.delCustomer(id);
    }

}

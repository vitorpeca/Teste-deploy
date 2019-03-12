package hello.domain.DAO.dao;

import hello.domain.DAO.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CostumerDao {

    MongoOperations mongoOperations;

    @Autowired
    public CostumerDao(final MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public void save(Customer customer) {
        mongoOperations.save(customer, "Customer_Test");
    }

    public Customer getCustomer(Long id) {
        return mongoOperations.findById(id, Customer.class,"Customer_Test");
    }

    public void updateCustomer(Customer customer) {
        mongoOperations.save(customer,"Customer_Test");
    }

    public void delCustomer(long id){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoOperations.remove(query,Customer.class,"Customer_Test");
    }


}


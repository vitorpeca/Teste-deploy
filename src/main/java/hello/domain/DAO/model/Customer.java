package hello.domain.DAO.model;

import org.springframework.data.annotation.Id;

public class Customer {
    @Id
    private final long id;
    private final String sku;
    private final int qty;

    public Customer(long id, String sku, int qty) {
        this.id = id;
        this.sku = sku;
        this.qty = qty;
    }


    public String getSku() {
        return sku;
    }

    public int getQty() {
        return qty;
    }

    public long getId() {
        return id;
    }

    public String toString() {
        String toString = this.getId()+this.getSku()+this.getQty();
        return toString;
    }
}



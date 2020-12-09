package main.java.backend.Orders.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.function.Function;

@Entity
@Table(name = "independent_sales")
//@Getter
public class IndependentSales implements Serializable {
    @Id
    @Column(name = "saleId")
    private String saleId;

    @Column(name = "sale")
    private Function<Item, Double> sale;

    public String getSaleId() {
        return saleId;
    }

    public Function<Item, Double> getSale() {
        return sale;
    }
}

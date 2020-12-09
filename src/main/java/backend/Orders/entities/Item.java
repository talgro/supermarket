package main.java.backend.Orders.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "items")
//@Getter
public class Item {
    @Id
    @Column(name = "sku")
    private String sku;

    @Column(name = "basePrice")
    private Double basePrice;

    @Column(name = "independent_sales")
    private List<IndependentSales> independentSales;

    @Column(name = "dependent_sales")
    private List<DependentSales> dependentSales;

    public String getSku() {
        return sku;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public List<IndependentSales> getIndependentSales(){
        return independentSales;
    }

    public List<DependentSales> getDependentSales(){
        return dependentSales;
    }
}

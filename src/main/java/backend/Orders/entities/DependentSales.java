package main.java.backend.Orders.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.function.Function;

@Entity
@Table(name = "Dependent_sales")
@IdClass(DependentSales.DependentSalesItems.class)
public class DependentSales implements Serializable {

    @Embeddable
    //@AllArgsConstructor
    public class DependentSalesItems{
        private Item dependentOn;
        private Item dependentItem;

        public DependentSalesItems(Item dependentOn, Item dependentItem) {
            this.dependentOn = dependentOn;
            this.dependentItem = dependentItem;
        }
    }

    @Column(name = "dependent_sales_items")
    private DependentSalesItems dependentSalesItems;

    @Column(name = "sale")
    private Function<DependentSalesItems, Double> sale;

    public DependentSalesItems getDependentSalesItems() {
        return dependentSalesItems;
    }

    public Function<DependentSalesItems, Double> getSale() {
        return sale;
    }
}

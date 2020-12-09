package main.java.backend.Orders.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @Column(name = "order_id")
    private String orderId;

    @Id
    private Item item;

    @Id
    @Column(name = "quantity")
    private Integer quantity;

    Double getFinalPrice() throws Exception {
        Double independentSalesPrice =
                item.getIndependentSales().stream()
                        .map(independentSales -> independentSales.getSale().apply(item))
                        .filter(Objects::nonNull)
                        .mapToDouble(price -> price)
                        .min()
                        .orElse(item.getBasePrice());

        Double dependentSalesPrice =
                item.getDependentSales().stream()
                        .map(dependentSales -> dependentSales.getSale().apply(new DependentSales.DependentSalesItems()))
                        .filter(Objects::nonNull)
                        .mapToDouble(price -> price)
                        .min()
                        .orElse(item.getBasePrice());

        List<Double> prices = new ArrayList<>();
        prices.add(item.getBasePrice());
        prices.add(independentSalesPrice);
        prices.add(dependentSalesPrice);

        OptionalDouble finalPrice = prices.stream().mapToDouble(price -> price).min();

        if (finalPrice.isPresent()){
            return finalPrice.getAsDouble();
        }
        throw new Exception("Error getting final price");
    }
}

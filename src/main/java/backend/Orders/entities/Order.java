package main.java.backend.Orders.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "items")
    private List<OrderItem> items;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "is_closed")
    private boolean isClosed;
}

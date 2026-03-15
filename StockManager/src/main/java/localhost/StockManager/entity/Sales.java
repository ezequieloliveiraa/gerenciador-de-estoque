package localhost.StockManager.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.nio.MappedByteBuffer;
import java.time.Instant;
import java.util.List;

@Entity
public class Sales {

    @OneToMany(mappedBy = "sales_id", cascade = CascadeType.ALL)
    List<Sales_items> sales_items;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant created_at;

    private Double total_price;

    public List<Sales_items> getSales_items() {
        return sales_items;
    }

    public void setSales_items(List<Sales_items> sales_items) {
        this.sales_items = sales_items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }


}

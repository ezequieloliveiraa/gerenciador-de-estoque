package localhost.StockManager.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "client")
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    private String name;

    private String email;

    private Long phone;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    private Double spending;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant created_at;

    private Instant deleted_at;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDeleted_at(Instant deleted_at) {
        this.deleted_at = deleted_at;
    }

    public Double getSpending() {
        return spending;
    }

    public void setSpending(Double spending) {
        this.spending = spending;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public enum Status {
        ACTIVE,
        INACTIVE,
        DELETED;
    }
}

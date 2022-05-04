package io.github.kiwm.Vendas.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private LocalDate dateRequest;

    private BigDecimal total;

    @OneToMany (mappedBy = "request")
    private List<RequestItem> items;

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", dateRequest=" + dateRequest +
                ", total=" + total +
                '}';
    }
}

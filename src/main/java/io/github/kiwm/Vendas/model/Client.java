package io.github.kiwm.Vendas.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
//@Table(name = "tbt_client") so necessario se o nome da tabela for diferente do nome da classe
@Table(name = "tbt_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id") se o nome for diferente e outras propiedades da tabela.
    private int id;
    private String name;
    @OneToMany(mappedBy = "client")
    private Set<Request> requests;
    public Client(String name) {
        this.name = name;
    }

}

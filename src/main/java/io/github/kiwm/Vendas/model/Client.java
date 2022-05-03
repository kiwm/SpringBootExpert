package io.github.kiwm.Vendas.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
//@Table(name = "tbt_client") so necessario se o nome da tabela for diferente do nome da classe
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id") se o nome for diferente e outras propiedades da tabela.
    private int id;

    private String name;

    public Client(String name) {
        this.name = name;
    }
}

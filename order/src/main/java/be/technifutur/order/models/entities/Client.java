package be.technifutur.order.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "username", nullable = false, length = 50, unique = true)
    private String username;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "reference_client", nullable = false, length = 20, unique = true)
    private String reference;
}

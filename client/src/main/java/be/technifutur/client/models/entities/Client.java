package be.technifutur.client.models.entities;

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
public class Client
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "username", nullable = false, length = 50, unique = true)
    private String username;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "mail", nullable = false, length = 50)
    private String mail;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "reference", nullable = false, length = 20, unique = true)
    private String reference;

    @OneToMany
    @JoinColumn(name = "client_id")
    private List<Order> orders = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "client_favorites",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "favorites_id"))
    private List<Product> favorites = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    private List<CartItem> cart = new ArrayList<>();
}
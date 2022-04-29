package be.technifutur.client.models.forms;

import be.technifutur.client.models.entities.Client;
import lombok.Data;

@Data
public class ClientForm
{
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String mail;
    private String address;
    private String reference;

    public Client toClient()
    {
        return Client.builder()
                .firstName(getFirstName())
                .lastName(getLastName())
                .username(getUsername())
                .password(getPassword())
                .mail(getMail())
                .address(getAddress())
                .reference(getReference())
                .build();
    }
}

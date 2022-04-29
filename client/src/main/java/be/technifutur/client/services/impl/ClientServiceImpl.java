package be.technifutur.client.services.impl;

import be.technifutur.client.exceptions.IdNotFoundException;
import be.technifutur.client.models.dtos.ClientDTO;
import be.technifutur.client.models.entities.Client;
import be.technifutur.client.models.forms.ClientForm;
import be.technifutur.client.repos.ClientRepository;
import be.technifutur.client.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService
{
    private final ClientRepository repo;

    public ClientServiceImpl(ClientRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public ClientDTO insert(ClientForm form)
    {
        return ClientDTO.of(form.toClient());
    }

    @Override
    public ClientDTO getOneById(Long id)
    {
        return repo.findById(id).map(ClientDTO::of).orElseThrow(() -> new IdNotFoundException(id));
    }

    @Override
    public ClientDTO updateById(Long id, ClientForm form)
    {
        Client c = repo.findById(id).orElseThrow(() -> new IdNotFoundException(id));

        c.setFirstName(form.getFirstName());
        c.setLastName(form.getLastName());
        c.setUsername(form.getUsername());
        c.setPassword(form.getPassword());
        c.setMail(form.getMail());
        c.setAddress(form.getAddress());

        return ClientDTO.of(repo.save(c));
    }

    @Override
    public ClientDTO deleteById(Long id)
    {
        ClientDTO c = getOneById(id);

        repo.deleteById(id);

        return c;
    }

    @Override
    public List<ClientDTO> getAll()
    {
        return repo.findAll().stream()
                .map(ClientDTO::of)
                .toList();
    }
}

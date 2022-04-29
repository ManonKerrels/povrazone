package be.technifutur.client.controllers;

import be.technifutur.client.models.dtos.ClientDTO;
import be.technifutur.client.models.forms.ClientForm;
import be.technifutur.client.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController
{
    private final ClientService service;

    public ClientController(ClientService service)
    {
        this.service = service;
    }

    @GetMapping
    public List<ClientDTO> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ClientDTO getOne(Long id)
    {
        return service.getOneById(id);
    }

    @PostMapping
    public ClientDTO insert(@RequestBody ClientForm form)
    {
        return service.insert(form);
    }

    @DeleteMapping("/{id}")
    public ClientDTO delete(@PathVariable Long id)
    {
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public ClientDTO update(@PathVariable Long id, @RequestBody ClientForm form)
    {
        return service.updateById(id, form);
    }
}

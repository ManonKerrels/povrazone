package be.technifutur.client.services;

import be.technifutur.client.models.dtos.ClientDTO;
import be.technifutur.client.models.forms.ClientForm;

import java.util.List;

public interface ClientService
{
    ClientDTO insert(ClientForm form);
    ClientDTO getOneById(Long id);
    ClientDTO updateById(Long id, ClientForm form);
    ClientDTO deleteById(Long id);
    List<ClientDTO> getAll();
}

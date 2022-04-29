package be.technifutur.client.exceptions;

import java.util.UUID;

public class UUIDNotFoundException extends RuntimeException
{
    public UUIDNotFoundException(UUID id)
    {
        super("l'element d'id "+id+" n'existe pas");
    }
}

package be.technifutur.client.fillers;

import be.technifutur.client.models.entities.Client;
import be.technifutur.client.repos.ClientRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFiller implements InitializingBean
{
    private final ClientRepository cRepo;

    public DatabaseFiller(ClientRepository cRepo)
    {
        this.cRepo = cRepo;
    }


    @Override
    public void afterPropertiesSet() throws Exception
    {
        setup();
    }

    private void setup()
    {
        Client c = Client.builder()
                .firstName("Testo")
                .lastName("Johnny")
                .username("usertesto")
                .password("password")
                .mail("testo-j@mailtest.test")
                .address("Rue des tests|200|Liege|4000")
                .reference("99.01.01-220.35")
                .build();

        cRepo.save(c);

        c = Client.builder()
                .firstName("Testi")
                .lastName("Jacques")
                .username("usertestij")
                .password("password")
                .mail("testi-ja@mailtest.test")
                .address("Rue du deuxieme test|200|Bruxelles|1000")
                .reference("79.11.15-240.89")
                .build();

        cRepo.save(c);
    }
}

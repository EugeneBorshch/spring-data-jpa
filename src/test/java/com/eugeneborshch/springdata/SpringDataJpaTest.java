package com.eugeneborshch.springdata;

import static org.junit.Assert.*;


import com.eugeneborshch.springdata.model.Client;
import com.eugeneborshch.springdata.repository.ClientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test Spring Data JPA functionality.
 * <p/>
 * User: Eugene Borshch
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class SpringDataJpaTest {

    @Autowired
    private ClientRepository clientRepository;


    @Test
    public void testInsertDelete() {
        Client client = new Client("Peter", 35);

        clientRepository.save(client);
        assertEquals(client, clientRepository.findOne(client.getId()));


        clientRepository.delete(client);
        assertEquals(null, clientRepository.findOne(client.getId()));
    }


    @Test
    public void testGetBy() {

        clientRepository.save(new Client("Peter", 35));
        clientRepository.save(new Client("Jonh", 28));
        clientRepository.save(new Client("Eric", 40));

        assertEquals(1, clientRepository.findByAgeLessThan(35).size());
    }

}

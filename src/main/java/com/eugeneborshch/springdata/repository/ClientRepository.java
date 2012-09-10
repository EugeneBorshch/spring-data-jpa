package com.eugeneborshch.springdata.repository;

import com.eugeneborshch.springdata.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Client Spring Data JPA repository
 * User: Eugene Borshch
 */
public interface ClientRepository extends JpaRepository<Client, Integer> {


    public List<Client> findByAgeLessThan(int age);

}

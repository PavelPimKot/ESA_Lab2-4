package com.example.esa_lab2.beans.repository.impl;

import com.example.esa_lab2.beans.repository.ClientRepository;
import com.example.esa_lab2.entities.Client;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository(value = "clientRepository")
@Transactional
public class ClientRepositoryImpl extends AbstractRepository implements ClientRepository {
    @Override
    public Client getClient(Integer id) {
        return entityManager.find(Client.class, id);
    }

    @Override
    public List<Client> findClientByLoginAndPassword(String login, String password) {
        return entityManager.createQuery(
                "select client from Client client where client.isDeleted = false and client.login = :login and client.password = :password ",
                Client.class).setParameter("login", login).setParameter("password", password).getResultList();
    }
}

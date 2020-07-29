package com.tandem.message.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tandem.message.entity.Message;

@Transactional
@Repository
public class MessageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Message> getMessages() {

        String hql = "FROM Message as atcl ORDER BY atcl.id";
        return (List<Message>) entityManager.createQuery(hql).getResultList();
    }


}

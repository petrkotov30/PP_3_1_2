package com.kotov.pp_3_1_2.dao;

import com.kotov.pp_3_1_2.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    public void update(User updateUser, Long id) {
        User user = getUser(id);
        user.setName(updateUser.getName());
        user.setLastName(updateUser.getLastName());
        user.setAge(updateUser.getAge());
        entityManager.merge(user);
    }

    public void deleteUser(Long id) {
        User user = getUser(id);
        entityManager.remove(user);
    }
}

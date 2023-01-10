package wab.spring_3_1_2.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import wab.spring_3_1_2.model.User;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List getUser() {
        return entityManager.createQuery("from User ").getResultList();
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(show(id));
    }
}

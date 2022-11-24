package web.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getAllUsers() {
        List<User> query = entityManager.createQuery("SELECT user from User user", User.class)
        .getResultList();
        return query;
    }

    public User show(int id) {

        User query = entityManager.createQuery("SELECT user from User user where id=:i", User.class)
        .setParameter("i", id)
        .getSingleResult();
        return query;
    }
    public void save(User user) {
        entityManager.getTransaction().begin();
        //entityManager.joinTransaction();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public void update(User updatedUser) {
        entityManager.merge(updatedUser);
    }
    public void delete(int id) {
          User user = entityManager.find(User.class, id);
          if (user != null) {
              entityManager.getTransaction().begin();
              entityManager.remove(user);
              entityManager.getTransaction().commit();
          }
//        User delUser = show(id);
//        entityManager.joinTransaction();
//        delUser = entityManager.find(User.class, delUser.getId());
//        entityManager.remove(delUser);
    }

}

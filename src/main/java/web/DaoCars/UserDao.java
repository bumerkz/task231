package web.DaoCars;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

@Repository
public class UserDao implements UserDaoInt{

    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> index() {
        TypedQuery<User> query = entityManager.createQuery("SELECT user from User user", User.class);
        return query.getResultList();
    }

    public User show(int id) {
        TypedQuery<User> query = entityManager.createQuery("SELECT user from User user where id=:i", User.class);
        query.setParameter("i", id);
        return query.getSingleResult();
    }
    public void save(User user) {
        entityManager.joinTransaction();
        entityManager.persist(user);
    }

    public void update(int id, User updatedUser) {

        entityManager.joinTransaction();
        User u = show(id);
        u.setName(updatedUser.getName());
        u.setLastName(updatedUser.getLastName());
        u.setbYear(updatedUser.getbYear());
        entityManager.persist(u);
    }
    public void delete(int id) {
        entityManager.joinTransaction();
        entityManager.remove(show(id));
    }

}

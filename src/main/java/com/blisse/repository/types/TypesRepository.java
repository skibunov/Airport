package com.blisse.repository.types;

import com.blisse.model.Types;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.blisse.repository.common.CrudRepository;

import java.util.List;
@Repository("typesRepository")
@Transactional
public class TypesRepository implements CrudRepository<Types> {

    private final SessionFactory sessionFactory;

    @Autowired
    public TypesRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Types types = session.load(Types.class, id);
        session.remove(types);
    }

    @Override
    public void update(Types types) {
        sessionFactory.getCurrentSession().update(types);
    }

    @Override
    public Types create(Types types) {
        return (Types) sessionFactory.getCurrentSession().save(types);
    }

    @Override
    public List<Types> getAll() {
         return sessionFactory.getCurrentSession()
                .createQuery(
                        "select a from Types a", Types.class)
                .list();
    }

    @Override
    public Types getById(Long id) {
        Types types = sessionFactory.getCurrentSession().get(Types.class, id);
        return types;
    }
}

package com.blisse.repository.pilots;

import com.blisse.model.Passengers;
import com.blisse.model.Pilots;
import com.blisse.model.Types;
import com.blisse.repository.common.CrudRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository("pilotsRepository")
@Transactional
public class PilotsRepository implements CrudRepository<Pilots> {
    private final SessionFactory sessionFactory;

    @Autowired
    public PilotsRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Pilots pilots = session.load(Pilots.class, id);
        session.remove(pilots);
    }

    @Override
    public void update(Pilots pilots) {
        sessionFactory.getCurrentSession().update(pilots);
    }

    @Override
    public Pilots create(Pilots pilots) {
        return (Pilots) sessionFactory.getCurrentSession().save(pilots);
    }

    @Override
    public List<Pilots> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery(
                        "select a from Pilots a inner join a.position", Pilots.class)
                .list();
    }

    @Override
    public Pilots getById(Long id) {
        Pilots pilots = sessionFactory.getCurrentSession().get(Pilots.class, id);
        return pilots;
    }
}

package com.blisse.repository.flights;

import com.blisse.model.*;
import com.blisse.repository.common.CrudRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository("flightsRepository")
@Transactional
public class FlightsRepository implements CrudRepository<Flights> {

    private final SessionFactory sessionFactory;

    @Autowired
    public FlightsRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Types types = session.load(Types.class, id);
        session.remove(types);
    }

    @Override
    public void update(Flights flights) {
        sessionFactory.getCurrentSession().update(flights);
    }

    @Override
    public Flights create(Flights flights) {
        return (Flights) sessionFactory.getCurrentSession().save(flights);
    }

    @Override
    public List<Flights> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery(
                        "select a from Flights a inner join fetch a.plane", Flights.class)
                .list();
    }

    @Override
    public Flights getById(Long id) {
        Flights flights = sessionFactory.getCurrentSession().get(Flights.class, id);
        return flights;
    }
}

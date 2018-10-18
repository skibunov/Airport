package com.blisse.repository.positions;

import com.blisse.model.Plane;
import com.blisse.model.Positions;
import com.blisse.repository.common.CrudRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository("positionsRepository")
@Transactional
public class PositionsRepository implements CrudRepository<Positions> {
    private final SessionFactory sessionFactory;

    @Autowired
    public PositionsRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Positions positions = session.load(Positions.class, id);
        session.remove(positions);
    }

    @Override
    public void update(Positions positions) {
        sessionFactory.getCurrentSession().update(positions);
    }

    @Override
    public Positions create(Positions positions) {
        return (Positions) sessionFactory.getCurrentSession().save(positions);
    }

    @Override
    public List<Positions> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery(
                        "select a from Positions a", Positions.class)
                .list();
    }

    @Override
    public Positions getById(Long id) {
        Positions positions = sessionFactory.getCurrentSession().get(Positions.class, id);
        return positions;
    }
}
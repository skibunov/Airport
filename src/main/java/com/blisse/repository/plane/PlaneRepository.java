package com.blisse.repository.plane;

import com.blisse.model.Pilots;
import com.blisse.model.Plane;
import com.blisse.repository.common.CrudRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository("planeRepository")
@Transactional
public class PlaneRepository implements CrudRepository<Plane> {
    private final SessionFactory sessionFactory;

    @Autowired
    public PlaneRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Plane plane = session.load(Plane.class, id);
        session.remove(plane);
    }

    @Override
    public void update(Plane plane) {
        sessionFactory.getCurrentSession().update(plane);
    }

    @Override
    public Plane create(Plane plane) {
        return (Plane) sessionFactory.getCurrentSession().save(plane);
    }

    @Override
    public List<Plane> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery(
                        "select a from Plane a inner join a.type", Plane.class)
                .list();
    }

    @Override
    public Plane getById(Long id) {
        Plane plane = sessionFactory.getCurrentSession().get(Plane.class, id);
        return plane;
    }
}

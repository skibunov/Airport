package com.blisse;


import com.blisse.model.*;
import com.blisse.service.AirportMenu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.blisse.repository.common.CrudRepository;

import java.util.List;

public class HibernateMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AirportConfig.class);

        CrudRepository<Flights> repository =
                (CrudRepository<Flights>) context.getBean("flightsRepository");

        AirportMenu airportMenu = new AirportMenu(repository);

        airportMenu.run();



//        CrudRepository<Flights> repository =
//                (CrudRepository<Flights>) context.getBean("flightsRepository");
//
////        Animal animal = repository.getById(1L);
////        List<Flights> all = repository.getAll();
//
//
//        List<Flights> flightsList = repository.getAll();
//        for (Flights e:flightsList) {
//            System.out.println(e.getPoint()+" "+e.getPassengers()+" "+ e.getPilots());
//        }

    }
}

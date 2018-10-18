package com.blisse.service;

import com.blisse.model.Flights;
import com.blisse.model.Passengers;
import com.blisse.model.Pilots;
import com.blisse.repository.common.CrudRepository;
import com.blisse.repository.flights.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

public class AirportMenu implements Runnable {

    private final Scanner scanner = new Scanner(System.in);
    private  CrudRepository<Flights> repository;

    public AirportMenu(CrudRepository<Flights> repository) {
        this.repository = repository;
    }

    @Override
    public void run() {
        do {
            printflights();
            printMenu();
            int n = scanner.nextInt();
            switch (n){
                case 1:
                    System.out.print("Номер рейса - ");int id_flights = scanner.nextInt();
                    List<Flights> flightsList = repository.getAll();
                    for (Flights f:flightsList) {
                        if (f.getId() == id_flights){
                            System.out.println(f.getPilots());
                        }
                    }
                    break;
                case 2:
                    System.out.print("Номер рейса - ");int flights = scanner.nextInt();
                    List<Flights> flightsLists = repository.getAll();
                    for (Flights f:flightsLists) {
                        if (f.getId() == flights){
                            System.out.println(f.getPassengers());
                        }
                    }
                break;

                case 3:
                    System.out.print("Номер рейса - ");int flightss = scanner.nextInt();
                    List<Flights> flightsListss = repository.getAll();
                    for (Flights f:flightsListss) {
                        if (f.getId() == flightss){
                            System.out.println(f.getPlane().getModel()+" "+f.getPlane().getType().getType());
                        }
                    }

                    break;

                case 4:
                    System.out.print("Номер рейса - ");int flighs = scanner.nextInt();
                    List<Flights> flightsLiss = repository.getAll();
                    for (Flights f:flightsLiss)
                        if (f.getId() == flighs) {
                            System.out.print("secondname - "); String secondname = scanner.nextLine();
                            System.out.print("firstname - ");String firstname = scanner.nextLine();
                            System.out.print("thirdname - ");String thirdname = scanner.nextLine();
                            System.out.print("passport - "); String passport = scanner.nextLine();
                            f.getPassengers().add(new Passengers(secondname,firstname,thirdname,passport));
                            repository.update(f);
                        }
                    break;

            }
        }while (true);
    }



    private void printMenu(){
        String menu = "1)Flight pilots\n"+
                "2)Flight passengers\n"+
                "3)Model Plane\n"+
                "4)Add passengers\n";

        System.out.print(menu);
    }

    private void printflights(){
        List<Flights> flightsList = repository.getAll();
        System.out.println();
        for (Flights e:flightsList) {
            System.out.println("["+e.getId()+"]"+e.getPoint()+" "+e.getDispatchtime()+" "+ e.getArrivaltime()+" "+e.getStatus());
        }
        System.out.println();
    }

}

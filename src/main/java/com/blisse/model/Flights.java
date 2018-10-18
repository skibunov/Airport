package com.blisse.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "flights")
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "point")
    private String point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="plane")
    private Plane plane;

    @Column(name = "dispatchtime")
    private String dispatchtime;

    @Column(name = "arrivaltime")
    private String arrivaltime;

    @Column(name = "status")
    private String status;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "flights_passengers",
            joinColumns = { @JoinColumn(name = "id_flights") },
            inverseJoinColumns = { @JoinColumn(name = "id_passengers") }
    )
    private List<Passengers> passengers = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "flights_pilots",
            joinColumns = { @JoinColumn(name = "id_flights") },
            inverseJoinColumns = { @JoinColumn(name = "id_pilots") }
    )
    private List<Pilots> pilots = new ArrayList<>();

    public Flights(String point, Plane plane, String dispatchtime, String arrivaltime, String status) {
        this.point = point;
        this.plane = plane;
        this.dispatchtime = dispatchtime;
        this.arrivaltime = arrivaltime;
        this.status = status;
    }

    public Flights() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public String getDispatchtime() {
        return dispatchtime;
    }

    public void setDispatchtime(String dispatchtime) {
        this.dispatchtime = dispatchtime;
    }

    public String getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(String arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Passengers> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passengers> passengers) {
        this.passengers = passengers;
    }

    public List<Pilots> getPilots() {
        return pilots;
    }

    public void setPilots(List<Pilots> pilots) {
        this.pilots = pilots;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "id=" + id +
                ", point='" + point + '\'' +
                ", plane=" + plane +
                ", dispatchtime='" + dispatchtime + '\'' +
                ", arrivaltime='" + arrivaltime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

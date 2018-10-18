package com.blisse.model;

import javax.persistence.*;

@Entity
@Table(name = "positions")
public class Positions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "position")
    private String position;

    public Positions(int id, String position) {
        this.id = id;
        this.position = position;
    }

    public Positions() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Positions{" +
                "id=" + id +
                ", position='" + position + '\'' +
                '}';
    }
}

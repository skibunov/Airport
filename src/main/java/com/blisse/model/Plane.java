package com.blisse.model;

import javax.persistence.*;

@Entity
@Table(name = "plane")
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "offsetability")
    private int offsetability;

    @ManyToOne
    @JoinColumn(name="type")
    private Types type;

    public Plane(int id, String model, int offsetability, Types type) {
        this.id = id;
        this.model = model;
        this.offsetability = offsetability;
        this.type = type;
    }

    public Plane() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getOffsetability() {
        return offsetability;
    }

    public void setOffsetability(int offsetability) {
        this.offsetability = offsetability;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", offsetability=" + offsetability +
                ", type=" + type +
                '}';
    }
}

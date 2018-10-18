package com.blisse.model;

import javax.persistence.*;

@Entity
@Table(name = "pilots")
public class Pilots {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "secondname")
    private String secondname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "thirdname")
    private String thirdname;

    @Column(name = "experience")
    private int experience;

    @ManyToOne
    @JoinColumn(name="position")
    private Positions position;

    public Pilots(int id, String secondname, String firstname, String thirdname, int experience, Positions position) {
        this.id = id;
        this.secondname = secondname;
        this.firstname = firstname;
        this.thirdname = thirdname;
        this.experience = experience;
        this.position = position;
    }

    public Pilots() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getThirdname() {
        return thirdname;
    }

    public void setThirdname(String thirdname) {
        this.thirdname = thirdname;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Pilots{" +
                "id=" + id +
                ", secondname='" + secondname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", thirdname='" + thirdname + '\'' +
                ", experience=" + experience +
                ", position=" + position +
                '}';
    }
}

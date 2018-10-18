package com.blisse.model;

import javax.persistence.*;

@Entity
@Table(name = "passengers")
public class Passengers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "secondname")
    private String secondname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "thirdname")
    private String thirdname;

    @Column(name = "passport")
    private String passport;

    public Passengers(String secondname, String firstname, String thirdname, String passport) {
        this.id = id;
        this.secondname = secondname;
        this.firstname = firstname;
        this.thirdname = thirdname;
        this.passport = passport;
    }

    public Passengers() {
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

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Passengers{" +
                "id=" + id +
                ", secondname='" + secondname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", thirdname='" + thirdname + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}

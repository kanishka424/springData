package com.fluffy.database.databasedemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity//defines an entity ,14th ,03 Journey From Spring  JDBC to JPA
@Table(name="person")//simply define the table which the entity maps to,not necessary for our example
public class Person {
    @Id//definies the primary key
    @GeneratedValue//Hibernate generates the value for us
    public int id;

    public String name;
    public String location;
    public Date  birthDate;

    public Person() {//must need for an entity class

    }

    public Person(int id, String name, String location, Date birthDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}


//===================================NOTE=====================
//if the entity name and table name are same we don't nee @Table
//if the fireld name and column name are same we don't nee @Column

package com.fluffy.database.databasedemo.jpa;


import com.fluffy.database.databasedemo.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


//this class for JPA
@Repository//defines repo
@Transactional//says this is for transactions
public class PersonJpaRepository {

    @PersistenceContext//stores all the transactions
    EntityManager entityManager;//maintain db connection to db and stores transactions for a particular session

    public Person findByID(int id){
       return  entityManager.find(Person.class,id);
    }


    public Person  updatePerson(Person person){//this returns the object not the rows affected
       return entityManager.merge(person);//whete we want to update or insert we want to use merge()
    }

    public Person  insertPerson(Person person){//this returns the object not the rows affected
        return entityManager.merge(person);//whete we want to update or insert we want to use merge()
    }

    public void deleteById(int id){
        Person person=findByID(id);//need to find first
        entityManager.remove(person);//remove() is the JPA method for delete
    }

    public List<Person> findAll(){
       TypedQuery<Person> namedQuery=entityManager.createNamedQuery("find_all_persons",Person.class);//first one is name of the query second is return type entity
        //we have to define the query in Person entity
        return namedQuery.getResultList();//getResultList() is how we get results of named query
    }
//
//    public void deletePerson(int id){
//        return entityManager.detach(id);
//    }
}


//=====================NOTE===================
//defines an entity ,15th ,03 Journey From Spring  JDBC to JPA
//1.as long as the EntityManager concern there is no difference between insert and update both use merge()
//if there is no object of given id it would insert if there is an object of given id it would make an update
//remove() is the JPA method for delete


//Here we have migrated from springjdbc to jpa  it requires less effort
//specially see findAll() using namedQuery
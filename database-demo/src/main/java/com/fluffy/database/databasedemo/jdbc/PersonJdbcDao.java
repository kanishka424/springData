package com.fluffy.database.databasedemo.jdbc;


import com.fluffy.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

//this class is for JDBC

@Repository//how to define the repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;//this is how we communicate with db

    class PersonRowMapper implements RowMapper<Person>{//12th ,03 Journey From Spring  JDBC to JPA
        @Override
        public Person mapRow(ResultSet rs,int rowNum) throws SQLException{
            Person person=new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getTimestamp("birth_date"));
            return person;
        }
    }

    public List<Person> findAll(){
        return  jdbcTemplate.query("select * from Person",new PersonRowMapper());
//       return  jdbcTemplate.query("select * from Person",new BeanPropertyRowMapper<Person>(Person.class));//with the default BeanPropertyRowMapper
    }


    public Person findById(int id){
        return  jdbcTemplate.queryForObject("select * from Person where id=?",new BeanPropertyRowMapper<Person>(Person.class),id);//9th ,03 Journey From Spring  JDBC to JPA
    }


    public int deleteById(int id){//update returns number of rows affected
        return  jdbcTemplate.update("delete from Person where id=?",id);//10th ,03 Journey From Spring  JDBC to JPA
    }

    public int insert(Person person){//11th ,03 Journey From Spring  JDBC to JPA
        return jdbcTemplate.update("insert into person(id,name,location,birth_date) values (?,?,?,?)",new Object[]{person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime())});//this  is called an array literal
    }

    public int update(Person person){//11th ,03 Journey From Spring  JDBC to JPA
        return jdbcTemplate.update("update person set name=?,location=?, birth_date=? where id=?",new Object[]{person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime()),person.getId()});
    }
}

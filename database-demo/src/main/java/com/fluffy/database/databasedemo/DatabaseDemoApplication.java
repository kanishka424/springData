package com.fluffy.database.databasedemo;

import com.fluffy.database.databasedemo.entity.Person;
import com.fluffy.database.databasedemo.jdbc.PersonJdbcDao;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.Date;
import java.util.logging.Logger;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {


	@Autowired
	PersonJdbcDao dao;

	//private Logger logger= (Logger) LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println(dao.findAll());
		System.out.println(dao.findById(1001));
		System.out.println(dao.deleteById(1002));
		System.out.println(dao.insert(new Person(1020,"Jackie","Wuhan",new Date())));
		System.out.println(dao.update(new Person(1001,"Peter","Colombo",new Date())));

	}
}

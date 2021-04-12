package com.fluffy.database.databasedemo;

import com.fluffy.database.databasedemo.entity.Person;
import com.fluffy.database.databasedemo.jdbc.PersonJdbcDao;
import com.fluffy.database.databasedemo.jpa.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {


	@Autowired
	PersonJpaRepository personJpaRepository;

	//private Logger logger= (Logger) LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println(personJpaRepository.findByID(1001));
		System.out.println(personJpaRepository.updatePerson(new Person(1001,"Peter","CplomboJPA",new Date())));
		System.out.println(personJpaRepository.insertPerson(new Person("Drake","South POle",new Date())));
		personJpaRepository.deleteById(1001);
		System.out.println(personJpaRepository.findAll());

		//System.out.println(personJpaRepository.deletePerson(1002));
//		System.out.println(dao.findById(1001));
//		System.out.println(dao.deleteById(1002));
//		System.out.println(dao.insert(new Person(1020,"Jackie","Wuhan",new Date())));
//		System.out.println(dao.update(new Person(1001,"Peter","Colombo",new Date())));

	}
}

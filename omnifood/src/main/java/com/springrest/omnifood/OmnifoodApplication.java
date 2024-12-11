package com.springrest.omnifood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OmnifoodApplication implements CommandLineRunner {
	@Autowired
	DB db;

	public OmnifoodApplication(DB db) {
		this.db = db;
	}

	public static void main(String[] args) {
		SpringApplication.run(OmnifoodApplication.class, args);
		//whatever that is passed thru command line to the application will be passed to the run method this way we can have more than one main method in a java application
	}

	@Override
	public void run(String... args)throws Exception{
		System.out.println(db.getData());

	}

}

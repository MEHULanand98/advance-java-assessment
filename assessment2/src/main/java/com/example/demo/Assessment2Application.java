package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Assessment2Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context =
                SpringApplication.run(Assessment2Application.class, args);

        System.out.println("----- Container Loaded -----");

        StorageService storage = context.getBean(StorageService.class);
        storage.storeFile("document.pdf");

        System.out.println("----- Getting Local Storage Beans -----");

        StorageService local1 = context.getBean("localStorage",StorageService.class);
        StorageService local2 = context.getBean("localStorage",StorageService.class);

        System.out.println("Are local1 and local2 same? " + (local1 == local2));

        context.close();
	}

}

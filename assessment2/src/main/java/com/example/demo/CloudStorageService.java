package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("cloudStorage")
@Primary   // Default Bean
@Scope("singleton")   // Default scope (explicitly written)
public class CloudStorageService implements StorageService {

    public CloudStorageService() {
        System.out.println("CloudStorageService Bean Created");
    }

    @PostConstruct
    public void init() {
        System.out.println("CloudStorageService Bean Initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("CloudStorageService Bean Destroyed");
    }

    @Override
    public void storeFile(String fileName) {
        System.out.println("File stored in Cloud Storage: " + fileName);
    }
}
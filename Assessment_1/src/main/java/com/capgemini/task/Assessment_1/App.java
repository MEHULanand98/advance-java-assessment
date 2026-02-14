package com.capgemini.task.Assessment_1;


import jakarta.persistence.*;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("employeePU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        
        Employee emp = new Employee();
        emp.setName("John");
        emp.setEmail("john@example.com");

      
        IDCard card = new IDCard();
        card.setCardNumber("IDC101");
        card.setIssueDate(LocalDate.now());

     
        card.setEmployee(emp);
        emp.setIdCard(card);

        
        em.persist(emp);

        em.getTransaction().commit();

        System.out.println("Employee Created Successfully\n");

        
        Employee fetchedEmp = em.find(Employee.class, 1);

        System.out.println("Employee Details:");
        System.out.println("ID: " + fetchedEmp.getId());
        System.out.println("Name: " + fetchedEmp.getName());
        System.out.println("Email: " + fetchedEmp.getEmail());

        System.out.println("\nID Card Details:");
        System.out.println("Card Number: " +
                fetchedEmp.getIdCard().getCardNumber());
        System.out.println("Issue Date: " +
                fetchedEmp.getIdCard().getIssueDate());

        em.close();
        emf.close();
    }
}


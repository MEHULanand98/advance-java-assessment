

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("----- Container Loaded -----");

        // Get default bean (CloudStorage because of @Primary)
        StorageService storage = context.getBean(StorageService.class);
        storage.storeFile("document.pdf");

        System.out.println("----- Getting Local Storage Beans -----");

        StorageService local1 = (StorageService) context.getBean("localStorage");
        StorageService local2 = (StorageService) context.getBean("localStorage");

        System.out.println("Are local1 and local2 same? " + (local1 == local2));

        context.close();  // To trigger destroy method
    }
}
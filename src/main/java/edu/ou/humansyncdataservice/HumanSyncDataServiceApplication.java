package edu.ou.humansyncdataservice;

import edu.ou.coreservice.annotation.BaseSyncDataAnnotation;
import org.springframework.boot.SpringApplication;

@BaseSyncDataAnnotation
public class HumanSyncDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HumanSyncDataServiceApplication.class, args);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.*;
import boundary.ApplicationManagementUI;
import dao.*;
import entity.*;

/**
 *
 * @author jians
 */
public class ApplicationManagement {
    private ApplicationManagementUI applicationManagementUI = new ApplicationManagementUI();
    private ListInterface<Job> jobList = new DoublyLinkedList<>();
    private ListInterface<Applicant> applicantList = new DoublyLinkedList<>();
    private ListInterface<Application> applicationList = new DoublyLinkedList<>();
    
    
    
//    ListInterface<Applicant> applicantList = applicantInitializer.initializeApplicants();
//    jobList = jobInitializer.initializeJobs();
    
    public ApplicationManagement(ListInterface<Applicant> applicantList) {
        this.applicantList = applicantList;
        ApplicationInitializer applicationInitializer = new ApplicationInitializer();
        applicationList = applicationInitializer.initializeApplications(applicantList);
    }
    
    public void runApplicationManagement() {
        System.out.println("Applicant:\n" + applicantList);
        int choice = 0;
        do {
            choice = applicationManagementUI.getMenuChoice();
            switch(choice) {
                case 0:
                    break;
                case 1:
                    displayApplications();
                    break;
                       
            }
        }while (choice != 0);
    }
    
    public String getAllApplications() {
        String outputStr = "";
        for (int i = 1; i <= applicationList.getNumberOfEntries(); i++) {
            outputStr += applicationList.getEntry(i) + "\n";
        }
        return outputStr;
    }
    
    public void displayApplications() {
        applicationManagementUI.listAllApplications(getAllApplications());
    }
    
//    public static void main(String[] args) {
//        ApplicationManagement applicationManagement = new ApplicationManagement();
//        applicationManagement.runApplicationManagement();
//    }
}

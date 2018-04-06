package main;

import database.Company;
import utils.Factory;

public class Main {

    public static void main(String args[]){
        Data.fill();

        System.out.println("List of Employee by project code");
        br();
        Factory.getEmployeeDAO().printListOfEmployeeByProjectCode("pr-1234");
        br();

        System.out.println("List of Projects by company ID");
        br();
        Factory.getProjectDAO().printListOfProjectsByCompanyID(1);
        br();

        System.out.println("List of Employee by skill type");
        br();
        Factory.getEmployeeDAO().printListOfEmployeeBySkillType("Soft");
        br();

        System.out.println("List of Employee by skill name");
        br();
        Factory.getEmployeeDAO().printListOfEmployeeBySkillName("Java");
        br();

        Factory.getEmployeeDAO().editEmployee(2);

        System.out.println("List of Projects where work at least 4 people skilled in Java");
        br();
        Factory.getProjectDAO().printListOfProjectsWhereFourPeopleInJava();
        br();

        Factory.getEmployeeDAO().deleteEmployee(1);

        System.out.println("List of Employee by skill name");
        br();
        Factory.getEmployeeDAO().printListOfEmployeeBySkillName("Java");
        br();

        System.out.println("List of employee and project of Company");
        br();
        Company company = Factory.getCompanyDAO().getCompanyById(1);
        Factory.getCompanyDAO().printProjectsAndEmployeesOfCompany(company);
    }

    public static void br() {

        System.out.println("________________________________________________________________________________________________________________________________________\n");
    }
}

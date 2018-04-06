package utils;

import dao.*;
import dao.implementation.*;

public class Factory {
    private static CountryDAO countryDAO;
    private static AddressDAO addressDAO;
    private static SkillDAO skillDAO;
    private static CompanyDAO companyDAO;
    private static EmployeeDAO employeeDAO;
    private static ProjectDAO projectDAO;

    public static CountryDAO getCountryDAO(){
        if(countryDAO == null){
            countryDAO = new CountryDAOImplementation();
        }
        return countryDAO;
    }

    public static AddressDAO getAddressDAO(){
        if(addressDAO == null){
            addressDAO = new AddressDAOImplementation();
        }
        return addressDAO;
    }

    public static SkillDAO getSkillDAO(){
        if(skillDAO == null){
            skillDAO = new SkillDAOImplementation();
        }
        return skillDAO;
    }

    public static CompanyDAO getCompanyDAO(){
        if(companyDAO == null){
            companyDAO = new CompanyDAOImplementation();
        }
        return companyDAO;
    }

    public static EmployeeDAO getEmployeeDAO(){
        if(employeeDAO == null){
            employeeDAO = new EmployeeDAOImplementation();
        }
        return employeeDAO;
    }

    public static  ProjectDAO getProjectDAO(){
        if(projectDAO == null){
            projectDAO = new ProjectDAOImplementation();
        }
        return projectDAO;
    }
}

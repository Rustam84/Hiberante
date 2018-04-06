package dao.implementation;

import dao.CompanyDAO;
import database.Company;
import database.Employee;
import database.Project;
import enumerations.State;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.Iterator;
import java.util.List;


public class CompanyDAOImplementation implements CompanyDAO {
    public void addCompany(Company company) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        try{
            session.beginTransaction();
            session.save(company);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    public Company getCompanyById(int id) {
        Company company = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try{
            company = session.load(Company.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return company;
    }

    public void printProjectsAndEmployeesOfCompany(Company company) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        try{
            company = session.load(Company.class, company.getId());
            System.out.println("Company name " + company.getName());

            System.out.println("Employees:");
            List<Employee> employeeList = company.getEmployees();
            Iterator<Employee> employeeIterator = employeeList.iterator();
            while (employeeIterator.hasNext()){
                Employee employee = employeeIterator.next();
                if(employee.getState() == State.ACTIVE) {
                    System.out.println("    UserID - " + employee.getUserId() +
                            ", first name - " + employee.getFirstName() +
                            ", last name - " + employee.getLastName());
                }
            }

            System.out.println("Projects: ");
            List<Project> projectList = company.getProjects();
            Iterator<Project> projectIterator = projectList.iterator();
            while (projectIterator.hasNext()){
                Project project = projectIterator.next();
                if(project.getState() == State.ACTIVE) {
                    System.out.println("    Project code - " + project.getProjectCode() +
                            ", project name - " + project.getName());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}

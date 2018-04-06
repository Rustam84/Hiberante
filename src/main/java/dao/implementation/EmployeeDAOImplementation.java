package dao.implementation;

import dao.EmployeeDAO;
import database.Address;
import database.Employee;
import database.Project;
import database.Skill;
import enumerations.State;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EmployeeDAOImplementation implements EmployeeDAO {

    public void addEmployee(Employee employee) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        try{
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    public void printListOfEmployeeByProjectCode(String projectCode) {
        List<Employee> employees = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try{
            employees = session.createQuery("select e from Employee e join e.projects as p" +
                    " where p.projectCode=:projectCodeVar and e.state = :stateEmployee and p.state = :stateProject")
                    .setParameter("projectCodeVar",projectCode)
                    .setParameter("stateEmployee", State.ACTIVE)
                    .setParameter("stateProject", State.ACTIVE).list();
            Iterator<Employee> employeeIterator = employees.iterator();
            while(employeeIterator.hasNext()){
                Employee employee =  employeeIterator.next();
                System.out.println(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getRole());

                System.out.println("    Company: " + employee.getCompany().getName());

                Address address = employee.getAddress();
                System.out.println("    Address: street - " + address.getStreet() + ", " + address.getStreetNumber()
                                    + ", city - " + address.getCity() + ", country - " + address.getCountry().getName());

                System.out.println("    Projects:");
                Set<Project> projects = employee.getProjects();
                Iterator<Project> projectIterator = projects.iterator();
                while(projectIterator.hasNext()){
                    Project project = projectIterator.next();
                    System.out.println("        Code - " + project.getProjectCode() + ", name - " + project.getName());
                }

                System.out.println("    Skills:");
                Set<Skill> skills = employee.getSkills();
                Iterator<Skill> skillIterator = skills.iterator();
                while(skillIterator.hasNext()){
                    Skill skill = skillIterator.next();
                    System.out.println("        Type - " + skill.getType() + ", skill - " + skill.getSkill());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void printListOfEmployeeBySkillType(String skillType) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Employee> employeeList = null;

        try{
            System.out.println("Skill type - " + skillType + ", employee with such skill type:");
            employeeList = session.createQuery("select distinct e from Employee e join e.skills as s" +
                    " where s.type = :skillType and e.state = :stateEmployee")
                    .setParameter("skillType", skillType)
                    .setParameter("stateEmployee", State.ACTIVE).list();
            if(employeeList.isEmpty()){
                System.out.println("No employee with such skill type");
            }
            Iterator<Employee> employeeIterator = employeeList.iterator();
            while (employeeIterator.hasNext()){
                Employee employee = employeeIterator.next();
                System.out.println("   " + employee.getFirstName() + " " + employee.getLastName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void printListOfEmployeeBySkillName(String skillName) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Employee> employeeList = null;

        try{
            System.out.println("Skill name - " + skillName + ", employee with such skill name:");
            employeeList = session.createQuery("select distinct e from Employee e join e.skills as s" +
                    " where s.skill = :skillName and e.state = :stateEmployee")
                    .setParameter("skillName", skillName)
                    .setParameter("stateEmployee", State.ACTIVE).list();
            if(employeeList.isEmpty()){
                System.out.println("No employee with such skill name");
            }
            Iterator<Employee> employeeIterator = employeeList.iterator();
            while (employeeIterator.hasNext()){
                Employee employee = employeeIterator.next();
                System.out.println("   " + employee.getFirstName() + " " + employee.getLastName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void editEmployee(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            Employee employee = session.load(Employee.class, id);
            employee.setLastName("newName");
            session.merge(employee);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void deleteEmployee(int id) {

        Session session = HibernateUtils.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            Employee employee = session.load(Employee.class, id);
            employee.setState(State.INACTIVE);
            session.merge(employee);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}

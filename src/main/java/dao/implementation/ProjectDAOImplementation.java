package dao.implementation;

import dao.ProjectDAO;
import database.Company;
import database.Project;
import enumerations.State;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.Iterator;
import java.util.List;

public class ProjectDAOImplementation implements ProjectDAO {

    public void addProject(Project project) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        try{
            session.beginTransaction();
            session.save(project);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }

    public void printListOfProjectsByCompanyID(int companyId) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Project> projects = null;

        try{
            Company company = session.load(Company.class, companyId);
            System.out.println("Company - " + company.getName() + ", projects:");
            projects = session.createQuery("select p from Project p join p.company c" +
                    " where c.id = :companyId and p.state = :stateProject")
                    .setParameter("companyId", companyId)
                    .setParameter("stateProject", State.ACTIVE).list();
            Iterator<Project> projectIterator = projects.iterator();
            while (projectIterator.hasNext()) {
                Project project = projectIterator.next();
                System.out.println("    Code - " + project.getProjectCode() + " name - " + project.getName());
            }
        }catch (ObjectNotFoundException e){
            System.out.println("No company with such id");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    public void printListOfProjectsWhereFourPeopleInJava() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try{
            List<Project> projectList = null;
            projectList = session.createQuery("select distinct p from Project p join p.employees as e join e.skills as" +
                    " s where s.skill = 'Java' and p.state = :stateProject and e.state = :stateEmployee" +
                    " group by p.id having count(p.id) >= 4 ")
                    .setParameter("stateProject", State.ACTIVE)
                    .setParameter("stateEmployee", State.ACTIVE).list();
            Iterator<Project> projectIterator = projectList.iterator();
            while (projectIterator.hasNext()){
                Project project = projectIterator.next();
                System.out.println(project.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void deleteProject(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        try{
            session.beginTransaction();
            Project project = session.load(Project.class, id);
            project.setState(State.INACTIVE);
            session.merge(project);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}

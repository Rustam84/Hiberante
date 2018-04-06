package dao.implementation;

import dao.SkillDAO;
import database.Skill;
import org.hibernate.Session;
import utils.HibernateUtils;

public class SkillDAOImplementation implements SkillDAO {
    public void addSkill(Skill skill) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        try{
            session.beginTransaction();
            session.save(skill);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }
}

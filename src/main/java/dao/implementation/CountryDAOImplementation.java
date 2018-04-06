package dao.implementation;

import dao.CountryDAO;
import database.Country;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.List;

public class CountryDAOImplementation implements CountryDAO {

    public void addCountry(Country country) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.save(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}

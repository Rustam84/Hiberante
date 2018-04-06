package dao.implementation;

import dao.AddressDAO;
import database.Address;
import org.hibernate.Session;
import utils.HibernateUtils;

public class AddressDAOImplementation implements AddressDAO {

    public void addAddress(Address address) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        try{
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }
}

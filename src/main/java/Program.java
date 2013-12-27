import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Program {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
            Person person = new Person();
            person.setFirstName("Bob");
            person.setAge(26);
        session.saveOrUpdate(person);

            Person person2 = new Person();
            person2.setFirstName("Mike");
            person2.setAge(16);
        session.saveOrUpdate(person2);
        session.getTransaction().commit();

        List<Person> persons = session.createQuery("from Person").list();
        for (Person s : persons) System.out.println(s);

        session.beginTransaction();
            person = persons.get(0);
            person.setAge(-1);
        session.saveOrUpdate(person);
        session.getTransaction().commit();

        persons = session.createQuery("from Person").list();
        for (Person s : persons) System.out.println(s);

        session.close();
    }
}
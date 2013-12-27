package protein;

import org.hibernate.SessionFactory;

/**
 * Date: 23.12.13 2:40
 */
public class Program {
    public static void main(String... args) {
        System.out.println("Start...");
        SessionFactory s = HibernateUtilities.getSessionFactory();

        s.openSession();
        System.out.println("Middle of session.");
        s.close();
    }
}

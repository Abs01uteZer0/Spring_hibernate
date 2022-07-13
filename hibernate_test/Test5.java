package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {

        //Удаляем строки из таблицы с помощью CreateQuery, в конце .executeUpdate();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        //При работе могут выбрасываться исключения
        try {
            //Получаем из фабрики сессию
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee emp = session.get(Employee.class, 1);
            session.delete(emp);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            //Закрываем фабрику в любом случае
            factory.close();
        }
    }
}

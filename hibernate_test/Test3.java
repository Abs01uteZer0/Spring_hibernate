package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {

        //Получаем объекты из таблицы, метод сессии: createQuery("from className " + "условия отбора").getResultList();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        //При работе могут выбрасываться исключения
        try {
            //Получаем из фабрики сессию
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            //Получение всех строк из таблицы
//            List<Employee> emps = session.createQuery("from Employee").getResultList();

            //Использование HQL (почти как SQL) для выбора отдельных строк
            List<Employee> emps = session.createQuery("from Employee " + "where name = 'Aleksandr' AND salary > 300").getResultList();

            for (Employee e: emps){
                System.out.println(e);
                System.out.println("");
            }

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            //Закрываем фабрику в любом случае
            factory.close();
        }
    }
}

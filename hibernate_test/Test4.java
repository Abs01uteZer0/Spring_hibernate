package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {

        //Делаем update строк в таблице, метод сессии: createQuery("from className " + "условия отбора").executeUpdate();
        //Также возможно изменение с помощью 1 объекта, если выбрать объект по Id, например первого работника и изменить его до getTransaction,
        //то он также изменится и в таблице
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        //При работе могут выбрасываться исключения
        try {
            //Получаем из фабрики сессию
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            session.createQuery("update Employee set salary = 1000 where name = 'Aleksandr'").executeUpdate();

            Employee  employee = session.get(Employee.class, 1);
            employee.setSalary(500);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            //Закрываем фабрику в любом случае
            factory.close();
        }
    }
}

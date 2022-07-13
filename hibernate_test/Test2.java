package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {

        //Получаем 1 объект из таблицы с помощью айди
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        //При работе могут выбрасываться исключения
        try {
            //Получаем из фабрики сессию
            Session session = factory.getCurrentSession();

            //Создаем объект, с помощью конструктора присваиваем ему значения
            //Employee emp = new Employee("Oleg", "Sidorov", "HR", 700);
            //Начинаем работу сессии
            session.beginTransaction();
            //Сохраняем в бд наш объект
            //session.save(emp);
            //Закрываем транзакцию
            //session.getTransaction().commit();

            //Получаем объект из бд по ID
            int myId = 2;
            //session = factory.getCurrentSession();
            //session.beginTransaction();
            Employee  employee = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(employee);

            System.out.println("Done!");
        }
        finally {
            //Закрываем фабрику в любом случае
            factory.close();
        }
    }
}

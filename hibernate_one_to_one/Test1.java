package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {

        //Создаем фабрику сессий, .configure - забирает наш xml файл со всей информацией о локальном сервере (логин, пароль, порт и тд..)
        //.getAnnitatedClass - забирает класс обертку, который совпадает с таблицей в бд
        //.buildSessionFactory - строит фабрику сессий.
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        //При работе могут выбрасываться исключения
        try {
            //Получаем из фабрики сессию
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Andrew", "Pshenichnyj", "IT", 500);
//            Detail detail = new Detail("Rzn", "1235667876", "email email email");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//
//            session.save(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Oleg", "Dyadko", "Sales", 700);
//            Detail detail = new Detail("Moscow", "88005553535", "Dyadko@gmail.com");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//
//            session.save(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            //Вывод деталей для одного человека.
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Employee emp = session.get(Employee.class, 1);
//            System.out.println(emp.getEmpDetail());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");


            session = factory.getCurrentSession();

            session.beginTransaction();

            Employee emp = session.get(Employee.class, 2);
            session.delete(emp);

            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            //Закрываем фабрику в любом случае
            session.close();
            factory.close();
        }
    }
}

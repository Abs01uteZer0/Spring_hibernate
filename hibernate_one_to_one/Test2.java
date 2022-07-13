package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
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
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Detail detail = session.get(Detail.class, 3);
//            System.out.println(detail.getEmployee());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");


            session = factory.getCurrentSession();
            session.beginTransaction();
            Detail detail = session.get(Detail.class, 1);

            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);

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

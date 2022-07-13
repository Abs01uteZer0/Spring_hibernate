package hibernate_test;

import hibernate_test.entity.Employee;
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
                .buildSessionFactory();

        //При работе могут выбрасываться исключения
        try {
            //Получаем из фабрики сессию
            Session session = factory.getCurrentSession();

            //Создаем объект, с помощью конструктора присваиваем ему значения
            Employee emp = new Employee("Aleksandr", "Ustinov", "Sales", 800);
            //Начинаем работу сессии
            session.beginTransaction();
            //Сохраняем в бд наш объект
            session.save(emp);
            //Закрываем транзакцию
            session.getTransaction().commit();


            System.out.println("Done!");
        }
        finally {
            //Закрываем фабрику в любом случае
            factory.close();
        }
    }
}

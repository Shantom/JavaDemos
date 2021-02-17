package com.shantom;


import com.shantom.pojo.Student;
import com.shantom.pojo.Teacher;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

@Data
public class Application {
    private static SessionFactory sessionFactory;
    static {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public static void main(String[] args) {
        Session session = sessionFactory.openSession();
        Teacher teacher = session.get(Teacher.class, 1);
        System.out.println(teacher);
        Student s = teacher.getStudents().iterator().next();
        System.out.println(s);

        session.beginTransaction().commit();
        session.close();

    }

    @Test
    public void testSaveTeacher(){
        Session session = sessionFactory.openSession();

        Teacher t3 = new Teacher();
        t3.setId(3);
        t3.setName("三老师");
        session.saveOrUpdate(t3);
        session.beginTransaction().commit();
        session.close();
    }

    @Test
    public void testCascadeSave(){
        Session session = sessionFactory.openSession();

        Student s1 = new Student();
        s1.setId(6);
        s1.setName("刘备");
        Teacher t1 = new Teacher();
        t1.setId(3);
        s1.setTeacher(t1);

        session.save(s1);
        session.beginTransaction().commit();
        session.close();
    }

}

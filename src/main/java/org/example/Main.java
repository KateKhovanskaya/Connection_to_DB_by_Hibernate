package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Connector connector = new Connector();

        try(Session session = connector.getSession()){
//            Course course1 = new Course("java", 24);
//            addData(course1, session);
//            Course course2 = new Course("python", 12);
//            addData(course2, session);
//            System.out.println(getCoursesList(session));
            Course course = getCourseById(session, 2);
//            course.setDuration(36);
//            updateCourse(session, course);
            deleteCourse(session, course);
            System.out.println(getCoursesList(session));
        }

    }
    private static void addData(Course course, Session session){
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
    }

    private static List<Course> getCoursesList(Session session){
        List<Course> coursesList = session.createQuery("FROM Course", Course.class).getResultList();
        return coursesList;
    }

    private static Course getCourseById (Session session, int id){
        return session.get(Course.class, id);
    }

    private static void updateCourse(Session session, Course course){
        session.beginTransaction();
        session.update(course);
        session.getTransaction().commit();
    }

    private static void deleteCourse(Session session, Course course){
        session.beginTransaction();
        session.delete(course);
        session.getTransaction().commit();
    }

}
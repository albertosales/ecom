/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciaProcessoCompra.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Frede
 */
public class HibernateUtil {

    private static final SessionFactory session = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            return cfg.buildSessionFactory();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSession() {
        return session;
    }
}

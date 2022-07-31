package com.github.a_oleg;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.github.a_oleg.entity")
@EnableJpaRepositories("com.github.a_oleg.repository")
@SpringBootApplication
public class SurveyManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SurveyManagerApplication.class, args);
        //Нужны ли строки ниже? Или нужно перенести их в пакет Service? Если да, то этот объект может понадобится в разных классах, может, его вынести куда-то в общем?
        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.getTransaction().commit();
        sessionFactory.close();
    }
}

package com.sda.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

    // write / read?
    public void create(Author author) {
        Transaction transaction = null;
        // get connection
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // create query
            transaction = session.beginTransaction();

            // execute query
            session.save(author);

            transaction.commit();
        } catch (Exception e) {
            // transaction management
            System.out.println(e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        // close resources
    }

    public List<Author> findAll() {
        List<Author> result = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // sql - uses table names "SELECT * from book"
            // hql - uses entity names

            // JPA -> use typed query<> (with JPQL - java persistence query language)
            // Hibernate -> use query<> (with HQL - hibernate query language)
            String hql = "FROM Author";
            Query<Author> query = session.createQuery(hql, Author.class);
            result = query.getResultList();

        } catch (HibernateException e) {
            System.out.println(e);
        }
        return result;
    }

    // authors whose book price is 100
    public List<Author> findAuthorsWithBookPriceJoinFetch(int price) {
        List<Author> result = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            String hql = "Author.findAuthorsWithBookPriceJoinFetch";
            Query<Author> query = session.createQuery(hql, Author.class);
            query.setParameter("price", price);
            result = query.getResultList();

        } catch (HibernateException e) {
            System.out.println(e);
        }
        return result;
    }

    public List<Author> findAuthorsWithBookPriceStream(int price) {
        // TODO: implement this
        return null;
    }

}

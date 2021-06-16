/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import models.State;

/**
 *
 * @author fabricio
 */

public class StateDAO {

    public List<State> getStates() {
        Session session = SessionUtil.getSession();
        Query query = session.createQuery("from State");
        List<State> states = query.list();
        session.close();
        return states;
    }

    public State getState(int id) {
        Session session = SessionUtil.getSession();
        Query query = session.createQuery("from State where id = :id");
        query.setParameter("id", id);
        List<State> states = query.list();
        session.close();
        return states.get(0);
    }

    public void addState(State bean) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(bean);
        tx.commit();
        session.close();
    }
}

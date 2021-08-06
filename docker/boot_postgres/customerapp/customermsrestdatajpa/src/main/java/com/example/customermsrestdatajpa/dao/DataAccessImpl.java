package com.example.customermsrestdatajpa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DataAccessImpl implements IDataAccess{

    @Autowired
    private EntityManager em;


    @Override
    public List allData(String entityName) {
        Query query = em.createQuery("from " + entityName);
        List list = query.getResultList();
       return list;
    }


}

package com.example.customermsrestdatajpa.service;

import com.example.customermsrestdatajpa.dao.IDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ServiceImpl implements IService{

    @Autowired
    private IDataAccess dao;


    @Override
    public  String findAllRows(String entityName){
        List list=dao.allData(entityName);
        Optional<String> optional = list.stream()
                .map(obj -> obj.toString())
                .reduce((str1, str2) -> str1.toString()+"\r\n" + str2);
        String result = optional.get();
        System.out.println("result=" + result);
        return result;
    }


}

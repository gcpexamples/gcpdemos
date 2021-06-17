package com.example.bootfirestoredemo.dao;

import com.example.bootfirestoredemo.entities.Trainee;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TrainDaoImpl implements ITraineeDao {

    @Autowired
    private Firestore fireStore;

    @Override
    public Trainee findTraineeById(String id) throws Exception {
        DocumentReference docRef = this.fireStore.document("trainees/" + id);
        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = docRef.get();
        DocumentSnapshot document = documentSnapshotApiFuture.get();
        String name = document.getString("ename");
        int age = document.get("age",Integer.class);
        Trainee trainee = new Trainee();
        trainee.setId(id);
        trainee.setName(name);
        trainee.setAge(age);
        return trainee;
    }
}

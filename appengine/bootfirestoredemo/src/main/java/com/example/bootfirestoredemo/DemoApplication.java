package com.example.bootfirestoredemo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.FileInputStream;
import java.io.InputStream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception{
	SpringApplication.run(DemoApplication.class, args);

	}

	@Bean
	public  Firestore firestore() throws Exception{
			// Use a service account
			InputStream serviceAccount = new FileInputStream("/home/vineet/tars/certificates/vinproject7-88b7a73f3d27.json");
			GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(credentials)
					.build();
			FirebaseApp.initializeApp(options);

			Firestore db = FirestoreClient.getFirestore();
           return db;
		}
	}



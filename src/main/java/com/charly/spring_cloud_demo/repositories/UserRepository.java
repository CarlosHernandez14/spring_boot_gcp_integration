package com.charly.spring_cloud_demo.repositories;


import com.charly.spring_cloud_demo.entities.UserEntity;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends FirestoreReactiveRepository<UserEntity> {
}


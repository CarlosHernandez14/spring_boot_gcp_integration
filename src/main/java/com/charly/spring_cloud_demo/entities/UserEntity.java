package com.charly.spring_cloud_demo.entities;


import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Document(collectionName = "users")
public class UserEntity {

    @DocumentId
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private Timestamp createdAt;

}

package com.erdemdis.document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class UserProfile {
    @Id
    String id;
    Long authId;
    String userName;
    String name;
    String surName;
    String email;
    String phone;
    String avatar;
    String insta;
    String twitter;
    String isActive;
    String createAt;

}

package com.topBalance.wishTree.dto;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.text.DateFormat;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Bamboo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int index;
    private String userId;
    private String comment;
    private Date commentDate;

    public Bamboo(String userId, String comment) {
        this.userId = userId;
        this.comment = comment;
        this.commentDate = new Date();
    }
}

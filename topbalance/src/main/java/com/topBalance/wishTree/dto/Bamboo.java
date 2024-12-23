package com.topBalance.wishTree.dto;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.text.DateFormat;

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
    private DateFormat commentDate;
}

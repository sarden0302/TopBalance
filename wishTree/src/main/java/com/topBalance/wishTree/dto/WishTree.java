package com.topBalance.wishTree.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class WishTree {

    @Id
    private String userId;
    private String userWish;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date wishDate;
}

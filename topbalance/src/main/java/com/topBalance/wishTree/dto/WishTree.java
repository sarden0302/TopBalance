package com.topBalance.wishTree.dto;

import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class WishTree {

    @Id
    private String userId;
    private String userWish;
    private String wishDate;
}

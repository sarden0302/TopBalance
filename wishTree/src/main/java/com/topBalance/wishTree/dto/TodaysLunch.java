package com.topBalance.wishTree.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TodaysLunch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int index;
    private CardType lunchMax;
    private CardType lunchMin;
    private String lunchResult;
}

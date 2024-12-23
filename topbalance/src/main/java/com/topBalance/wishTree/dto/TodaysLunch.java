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
    private Enum lunchMax;
    private Enum lunchMin;
    private String lunchResult;
}

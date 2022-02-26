package com.gourianova.format.model;
import lombok.*;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Setter

public class TitleUnit {
    int id;
    private String titlesItem;
    private String timePeriod;

    public TitleUnit() {

    }



}

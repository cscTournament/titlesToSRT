package com.gourianova.format.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Setter

public class TextDto implements Serializable {

    private String text;
    private Integer taskNumber;


}

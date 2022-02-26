package com.gourianova.format.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class TextDto implements Serializable {

    private String text;
    private Integer taskNumber;



}

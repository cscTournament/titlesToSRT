package com.gourianova.format.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
public class UserInputDto implements Serializable {

    private Integer taskNumber;


}

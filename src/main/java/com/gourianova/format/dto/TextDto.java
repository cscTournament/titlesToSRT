package com.gourianova.format.dto;

import com.gourianova.format.model.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Setter
@Getter

public class TextDto implements Serializable {

    private String text;
    private Language language;


}

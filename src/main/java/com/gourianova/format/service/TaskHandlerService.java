package com.gourianova.format.service;

import com.gourianova.format.dto.TextDto;
import com.gourianova.format.model.TitleUnit;
import com.gourianova.format.task.*;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
public class TaskHandlerService {

    public static void handleEnglishTitlesToSrtFormat(TextDto dto) {
        EnglishTitlesToSrtFormat taskTranslateSubtitles = new EnglishTitlesToSrtFormat(dto.getText());
        String textResult="";
        String result = taskTranslateSubtitles.getResult();

        if (result != null) {
            //TODO: сохраняем в базу результат
            textResult = textResult.concat(result.replace("﻿","") + "\n\n");
        } else {
            textResult = "\n\t WE CAN'T GIVE  YOU SUCH A FORMAT \n";
        }
        dto.setText(textResult);
    }
    public static void handleFrenchTitlesToSrtFormat(TextDto dto) {



        FrenchTitlesToSrtFormat taskTranslateSubtitles = new FrenchTitlesToSrtFormat(dto.getText());
        String textResult = "";
        String result = taskTranslateSubtitles.getResult();

        if (result != null) {
            textResult = textResult.concat(result.replace("﻿","") + "\n\n");
        } else {
            textResult = "\n\t WE CAN'T GIVE  YOU SUCH A FORMAT \n";
        }
        dto.setText(textResult);
    }


}

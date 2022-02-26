package com.gourianova.format.service;


import com.gourianova.format.dto.TextDto;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

import static com.gourianova.format.service.TaskHandlerService.*;


@Slf4j
public class TextHandlerService {

    public static void handle(TextDto dto) {

        switch (dto.getTaskNumber()) {
            case (1):
                handleEnglishTitlesToSrtFormat(dto);
                break;
            case (2):
                handleFrenchTitlesToSrtFormat(dto);
                break;
            default:
                 log.info(" PLEASE, PUT THE FILE FOR ANALYSING AND FORMATTING INTO resource.txt"
                         +
                         "format of In-file should be \n"+

                         "00:00:08.929,0:00:09.770\t\tobitel-minsk.org présente\n"+
                         "LOOK LIKE\n");
                break;
        }
    }

}

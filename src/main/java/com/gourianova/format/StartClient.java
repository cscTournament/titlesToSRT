package com.gourianova.format;

import com.gourianova.format.client.Client;
import com.gourianova.format.constants.ClientConstants;
import com.gourianova.format.dto.TextDto;
import com.gourianova.format.dto.UserInputDto;
import com.gourianova.format.model.Language;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import static com.gourianova.format.model.Language.English;
import static com.gourianova.format.model.Language.French;


@Slf4j
public class StartClient {

    private static final String CLIENT_IP = "127.0.0.1";
    private static final Integer SERVER_PORT = 8888;

    public static void main(String[] args) throws IOException, IllegalAccessException, URISyntaxException {
        log.info("Client starting...");
        Client client = new Client();
        client.startConnection(CLIENT_IP, SERVER_PORT);
        log.info(ClientConstants.USER_CHOOSE);

        BufferedReader inputUser = new BufferedReader(new InputStreamReader(System.in));

        Integer taskNumber = Integer.valueOf(inputUser.readLine());

        switch (taskNumber) {
            case (1):
                log.info("Let's start");
                break;
            case (2):
                log.info("Commençons");
                break;
        }

        UserInputDto request = new UserInputDto(taskNumber);
        TextDto response = client.sendMessage(request);
        log.info(String.valueOf(client.getMessage(response)));
        String fileName = "";

        if (response != null) {
            log.info("Result is: {}\n\n", "\n", response.getText());
        }
        if (taskNumber == 1) {

            fileName = "outEnglish.srt";
            response.setLanguage(English);


        } else if (taskNumber == 2) {

            fileName = "outFrench.srt";
            response.setLanguage(French);

        } else {
            log.info("Your choice should be \"1\" or \"2\"");
        }
        log.info("You could find the result file here:\n" + fileName);

        // Path path = Path.of((StartClient.class.getClassLoader().getResource(fileName)).toURI());
        //  log.info("You could find the result file here:\n" + path);
        //  Files.write(path, response.getText().getBytes(), StandardOpenOption.WRITE);

        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.append(response.getText());
            writer.flush();
        }
    }
}


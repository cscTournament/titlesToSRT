package com.gourianova.format.server;


import com.gourianova.format.StartClient;
import com.gourianova.format.dto.TextDto;
import com.gourianova.format.dto.UserInputDto;
import com.gourianova.format.model.Language;
import com.gourianova.format.service.TextHandlerService;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.io.FileUtils.readFileToString;

@Slf4j
public class SingleServer {
   private static final String FILE_PATH = "resource.txt";
    private ServerSocket serverSocket;
    private Socket clientSocket;
    ObjectOutputStream out = null;
    ObjectInputStream in = null;


    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());

            UserInputDto userInput = (UserInputDto) in.readObject();
            TextDto textDto = deserializationFromFile();
            Integer taskNumber=userInput.getTaskNumber();
            if (taskNumber==1)
            textDto.setLanguage(Language.English);
            if (taskNumber==2)
                textDto.setLanguage(Language.French);
            TextHandlerService.handle(textDto);
            out.writeObject(textDto);
        } catch (IOException | ClassNotFoundException e) {
            log.error("Server can't start for reason: {}", e.getMessage());
        }
    }

    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            log.error("Server can't stop for reason: {}", e.getMessage());
        }
    }

    private static TextDto deserializationFromFile() {
        try {
            ClassLoader classLoader = StartClient.class.getClassLoader();
            String resource = requireNonNull(classLoader.getResource(FILE_PATH)).getFile();
            String text = readFileToString(new File(resource), UTF_8);
            return new TextDto(text, Language.French);
        } catch (IOException ex) {
            log.error("Can't read resource for reason: {}", ex.getMessage());
            throw new RuntimeException("Can't read resource.");
        }
    }

}


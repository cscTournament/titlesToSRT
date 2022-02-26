package com.gourianova.format.server;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MultiServer {
/*
    private static final String FILE_PATH = "resource.txt";
    private ServerSocket serverSocket;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            log.error("Server can't start for reason: {}", e.getMessage());
        }
        while (true) {
            try {
                TextDto textDto = deserializationFromFile();
                new ClientHandler(serverSocket.accept(), textDto).start();
            } catch (IOException e) {
                log.error("Server can't start for reason: {}", e.getMessage());
            }
        }
    }

    public void stop() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            log.error("Server can't stop for reason: {}", e.getMessage());
        }
    }

    private static TextDto deserializationFromFile() {
        try {
            ClassLoader classLoader = AppClient.class.getClassLoader();
            String resource = requireNonNull(classLoader.getResource(FILE_PATH)).getFile();
            String text = readFileToString(new File(resource), UTF_8);
            return new TextDto(text, 0,5,"a","a","z");
        } catch (IOException ex) {
            log.error("Can't read resource for reason: {}", ex.getMessage());
            throw new RuntimeException("Can't read resource.");
        }
    }

    private static class ClientHandler extends Thread {

        private Socket clientSocket;
        private TextDto textDto;
        ObjectOutputStream out;
        ObjectInputStream in;

        public ClientHandler(Socket clientSocket, TextDto textDto) {
            this.clientSocket = clientSocket;
            this.textDto = textDto;
        }


        public void run() {
            try {
                out = new ObjectOutputStream(clientSocket.getOutputStream());
                in = new ObjectInputStream(clientSocket.getInputStream());
                UserInputDto userInput = (UserInputDto) in.readObject();
                //TODO: decide which user input server should ignore
                while (userInput.getTaskNumber() != 20) {
                    textDto.setTaskNumber(userInput.getTaskNumber());
                    textDto.setLengthOfWord(userInput.getLengthOfWord());
                    textDto.setLetter(userInput.getLetter());
                    textDto.setWordStart(userInput.getWordStart());
                    textDto.setWordEnd(userInput.getWordEnd());
                    TextHandlerService.handle(textDto);
                    out.writeObject(textDto);
                }
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


 */
}


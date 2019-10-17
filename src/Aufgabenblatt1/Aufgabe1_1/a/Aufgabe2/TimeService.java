package Aufgabenblatt1.Aufgabe1_1.a.Aufgabe2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class TimeService {

    private Socket socket;

    void timeService(){
        try {
            ServerSocket serverSocket = new ServerSocket(75);
            while (true){
                socket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                boolean firstlyConnected = true;
                String recieved = "";
                while (socket != null){
                    if (firstlyConnected){
                        writeOutput("time service", writer);
                        firstlyConnected = false;
                        recieved = reader.readLine();
                    }
                    recieved = checkRecieved(recieved, reader, writer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String checkRecieved(String recieved, BufferedReader reader, BufferedWriter writer){
        if(recieved != null && !recieved.equals("")){
            recieved = checkInput(recieved, writer, reader);
        } else {
            closeConnection(writer);
        }
        return recieved;
    }

    private void closeConnection(BufferedWriter writer){
        try {
            writer.write("wrong input! connection closed!");
            makeNewLineAndFlush(writer);
            this.socket.close();
            this.socket = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void makeNewLineAndFlush(BufferedWriter writer){
        try {
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //checks if input is date or time if not it closes the connection
    private String checkInput(String recieved, BufferedWriter writer, BufferedReader reader){
        if(!checkIfTime(writer, recieved) && !checkIfDate(writer, recieved)){
            closeConnection(writer);
            recieved = null;
        } else {
            recieved = getInput(reader);
        }
        return recieved;
    }

    //reads input
    private String getInput(BufferedReader reader){
        String recieved = "";
        try {
            recieved = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recieved;
    }

    //writes output
    private void writeOutput(String txt, BufferedWriter writer){
        try {
            writer.write(txt);
            makeNewLineAndFlush(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //checks if input equals time and returns boolean
    private boolean checkIfTime(BufferedWriter writer, String recieved){
        boolean isTime = false;
        if (recieved.equals("time")){
            writeOutput(Clock.time(), writer);
            isTime = true;
        }
        return isTime;
    }

    //checks if input equals date and returns boolean
    private boolean checkIfDate(BufferedWriter writer, String recieved){
        boolean isDate = false;
        if (recieved.equals("date")){
            writeOutput(Clock.date(), writer);
            isDate = true;
        }
        return isDate;
    }

}

package Aufgabenblatt1.Aufgabe1_1.a.Aufgabe2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class TimeService {

    void timeService(){
        try {
            ServerSocket serverSocket = new ServerSocket(75);
            while (true){
                Socket socket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                boolean firstlyConnected = true;
                String received = null;
                while (!socket.isClosed()){
                    if (firstlyConnected){
                        writer.write("time service");
                        makeNewLineAndFlush(writer);
                        firstlyConnected = false;
                        received = reader.readLine();
                    }
                    if (received.equals("date")) {
                        writer.write(Clock.date());
                        makeNewLineAndFlush(writer);
                        received = reader.readLine();
                    } else if (received.equals("time")) {
                        writer.write(Clock.time());
                        makeNewLineAndFlush(writer);
                        received = reader.readLine();
                    } else {
                        writer.write("wrong input! connection closed!");
                        makeNewLineAndFlush(writer);
                        socket.close();
                    }
                }
            }
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

}

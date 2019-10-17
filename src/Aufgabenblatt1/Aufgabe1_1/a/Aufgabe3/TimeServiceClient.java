package Aufgabenblatt1.Aufgabe1_1.a.Aufgabe3;

import java.io.*;
import java.net.Socket;

public class TimeServiceClient {

    public String dateFromServer(String ip){
        String received = "";
        try {
            Socket socket = new Socket(ip, 75);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
            writeAndFlush("date", socket);
            received = reader.readLine();
            reader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return received;
    }

    String timeFromServer(String ip){
        String received = "";
        try {
            Socket socket = new Socket(ip, 75);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
            writeAndFlush("time", socket);
            received = reader.readLine();
            reader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  received;
    }

    private void writeAndFlush(String txt, Socket socket){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write(txt);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
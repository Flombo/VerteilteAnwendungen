package Aufgabenblatt1.Aufgabe1_1.a.Aufgabe3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class TimeServiceMultithreaded {

    private ArrayList<Socket> sockets;

    TimeServiceMultithreaded(){
        this.sockets = new ArrayList<>();
    }

    void timeService() {
        try {
            ServerSocket serverSocket = new ServerSocket(75);
            int index = 0;
            while (true) {
                sockets.add(index, serverSocket.accept());
                if(sockets.get(index) != null){
                    WorkingThread workingThread = new WorkingThread(sockets.get(index));
                    workingThread.start();
                    index++;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}

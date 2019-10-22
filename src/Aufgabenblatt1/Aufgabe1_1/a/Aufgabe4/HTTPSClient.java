package Aufgabenblatt1.Aufgabe1_1.a.Aufgabe4;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;
import java.net.URL;

public class HTTPSClient {

    private static void get(String url){
        try {
            URL u = new URL(url);
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket;
            if(u.getPort() != -1){
                socket = (SSLSocket) factory.createSocket(u.getHost(), u.getPort());
            } else {
                socket = (SSLSocket) factory.createSocket(u.getHost(), 443);
            }
            sendRequest(socket, u.getFile(), u.getHost());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(reader.readLine() != null) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendRequest(Socket socket, String file, String host){
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write("GET " + file + " HTTP/1.1");
            writer.newLine();
            writer.write("HOST: " + host);
            writer.newLine();
            writer.write("");
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[]args){
        get("https://www.bundestag.de:443/presse");
    }

}

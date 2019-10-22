package Aufgabenblatt1.Aufgabe1_1.a.Aufgabe4;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;
import java.net.URL;

public class URLExists {

    public boolean urlExists(String s){
        boolean exists = false;
        try {
            URL url = new URL(s);
            if(url.getHost() != null){
                SSLSocket socket = initSocket(url.getHost(), url.getPort());
                if(socket != null && socket.isConnected()) {
                    sendRequest(socket, url.getFile(), url.getHost());
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String response = bufferedReader.readLine();
                    if (response.substring(9,12).equals("200") || response.substring(10, 13).equals("200")) {
                        exists = true;
                    }
                }
            }
        } catch (IOException e) {
            return false;
        }
        return exists;
    }

    String getContent(String u){
        String content = "";
        try {
            URL url = new URL(u);
            SSLSocket socket = initSocket(url.getHost(), url.getPort());
            if(socket != null) {
                sendRequest(socket, url.getFile(), url.getHost());
                content = getResponse(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    private String getResponse(SSLSocket socket){
        StringBuilder response = new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String stream = reader.readLine();
            boolean firstTime = true;
            while(stream != null) {
                if(stream.trim().isBlank() && firstTime){
                    response.delete(0, response.length());
                    firstTime = false;
                }
                response.append(stream);
                stream = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }

    private SSLSocket initSocket(String host, int port){
        SSLSocket sslSocket;
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try {
            if (port != -1) {
                sslSocket = (SSLSocket) factory.createSocket(host, port);
            } else {
                sslSocket = (SSLSocket) factory.createSocket(host, 443);
            }
        }catch (IOException e){
            return null;
        }
        return sslSocket;
    }

    private void sendRequest(Socket socket, String file, String host){
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

}

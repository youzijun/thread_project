package com.ltt.nio;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ZJX-BJ-01-00057 on 2018/4/25.
 */
public class SocketIo {


    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(7777);
            System.out.println("服务端启动...");
            while (true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                while (true){
                    int read = inputStream.read();
                    if(read != -1){
                        String s = new String(bytes,0,read,"GBK");
                        System.out.println(s);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

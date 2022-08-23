package com.learn.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test_Server {
    public static void main(String[] args) throws IOException {
        /**
         * 代表Socket通信的服务端
         * 任务：接收从客户端发过来得数据
         *      给客户端发送数据
         */
        //启动服务器
        ServerSocket ss = new ServerSocket(1025);
        System.out.println("服务器启动成功");
        //接收客户端发来的连接请求
        Socket socket = ss.accept();
        System.out.println("连接成功");
        //接收客户端发来的hello

        //获取输入流,接收用户发来的hello
        InputStream in = socket.getInputStream();
        //遍历
        for (int i = 0; i < 5; i++) {
            int b = in.read();
            char c = (char)b;
            System.out.print(c);
        }

        //向客户机回复Hi
        //获取字接套的输出流
        OutputStream out = socket.getOutputStream();
        out.write("Hi".getBytes());//把字符串放入Byte数组

        ss.close();
        System.out.println("服务器已关闭");
    }
}

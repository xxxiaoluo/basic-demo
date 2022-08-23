package com.learn.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 代表Socket通信的服务器端
 * 职责：接收客户端发来的数据
 *      给客户端发送数据
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //开启服务器
        ServerSocket ss = new ServerSocket(1025);
        System.out.println("服务器已启动");
        //接收客户端发来的连接请求
        Socket socket = ss.accept();
        System.out.println("连接接收成功");
        //接收客户端发来的hello

        InputStream in = socket.getInputStream();
        for(int i=0;i<5;i++){
            int read = in.read();
            //按照字符读就行了别转成int型
            char c = (char)read;
            System.out.print(c);
        }
        //给客户端发出数据--out
        OutputStream out = socket.getOutputStream();
        out.write("world".getBytes());
//        out.close();//将数据刷出去加关闭资源
        out.flush();//把数据刷出去

    }
}

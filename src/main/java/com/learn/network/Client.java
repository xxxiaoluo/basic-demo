package com.learn.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 代表Socket通信的客户端
 * 职责：接收服务端发来的数据
 *      给服务端发送数据
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //连接指定的服务器
        Socket s = new Socket("127.0.0.1",1025);
        System.out.println("与服务器连接成功");
        //给服务器发送hello
        OutputStream out = s.getOutputStream();
        out.write("hello".getBytes());//把字符串放入Byte数组

        //开始写出数据
        InputStream in = s.getInputStream();

        //接收服务器发来的数据 -- in
        for(int i = 0;i < 5;i++){
            int read = in.read();
            //按照字符读就行了,别转成int型
            char c = (char)read;
            System.out.print(c);
        }

        out.close();
        s.close();
    }
}

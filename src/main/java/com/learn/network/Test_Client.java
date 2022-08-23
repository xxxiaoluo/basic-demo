package com.learn.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Test_Client {
    public static void main(String[] args) throws IOException {

        //连接指定的服务器
        Socket s = new Socket("127.0.0.1", 1025);
        System.out.println("服务器连接成功");
        //向服务器发送hello
        OutputStream out = s.getOutputStream();//获取该字节套的输出流
        out.write("hello".getBytes());//把字符串放入Byte数组

        //接收来自服务器的数据
        InputStream in = s.getInputStream();
        for (int i = 0; i < 2; i++) {
            int a = in.read();
            char c = (char)a;
            System.out.print(c);
        }


    }
}

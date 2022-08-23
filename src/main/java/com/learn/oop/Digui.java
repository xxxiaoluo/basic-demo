package com.learn.oop;

import java.io.File;

//用递归算出文件夹的大小
public class Digui {
    public static void main(String[] args) {
        //1.列出文件夹下的所有资源
        File path = new File("D://file");

        int total =  size(path);
        System.out.println(total);
    }

    private static int size(File path) {

        File[] fs = path.listFiles();//该方法只能列文件夹内类型的路径
        //遍历该文件数组
        int sum = 0;
        for (int i = 0 ; i < fs.length; i++) {
            //2.判断当前资源是文件吗？是就直接.length（）求和
            if ( fs[i].isFile() ){//判断是否是文件
                sum+=fs[i].length();
            }else if (fs[i].isDirectory()){
                //3.判断当前资源是文件夹吗，是就开始重复
                sum+=size(fs[i]);
            }
        }
        return sum;
    }
}

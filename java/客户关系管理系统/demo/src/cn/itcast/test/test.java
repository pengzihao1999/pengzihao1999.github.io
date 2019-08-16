package cn.itcast.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class test {
    public static void main(String[] args) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("D:\\学习资料\\java学习\\最新黑马就业班\\黑马java57期\\java\\03-javaWeb\\day17_EL&JSTL\\代码\\demo3\\out\\artifacts\\demo_war_exploded\\WEB-INF\\classes\\words.txt"));
            String line = null;
            while((line = fileReader.readLine())!=null){
                System.out.println("line = " + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class JPanel03 extends JPanel{
    private Main win;
    public String line = "";
    public JPanel03(Main win,String filename) {
        this.win = win;
        String s = "";
        String []a;
        int x = 10;
        int y = 10;
        int width = 750;
        int height = 20;
        int i=0;
        setLayout(null);

        try{

            File file = new File("C:\\Users\\주동민\\Documents\\-Memorization-Program\\studyprogram\\src\\com\\company\\"+filename);
            //파일 객체 생성
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"euc-kr"));
            while((line = bufReader.readLine()) != null){
                JLabel [] contentLabel = new JLabel[30];
                contentLabel[i] = new JLabel(line);
                contentLabel[i].setFont(new Font("명조", Font.BOLD, 20));
                contentLabel[i].setBounds(x, y, width,height);
                add(contentLabel[i]);
                y+=20;
                System.out.println(line);
                //s+=line+" ";
                i++;


            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }



    }


}

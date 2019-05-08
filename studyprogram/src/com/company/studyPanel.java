package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class studyPanel {
    public static JPanel studypane;
    public String line = "";
    public JLabel[] contentLabel = new JLabel[30];
    public studyPanel(String filename) {
        String s = "";
        studypane = new JPanel();
        studypane.setLayout(null);
        studypane.setBounds(0, 0, 1530, 800);                //패널 크기 설정

        try{
            JLabel [] contentLabel = new JLabel[30];
            int x = 10;
            int y = 10;
            int width = 750;
            int height = 20;
            int i=0;

            File file = new File("C:\\Users\\동민\\IdeaProjects\\studyprogram\\src\\com\\company\\운영체제.txt");
            //파일 객체 생성
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"euc-kr"));
            while((line = bufReader.readLine()) != null){

                System.out.println(line);
                s+=line+" ";


            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
        System.out.println(s);


    }


}

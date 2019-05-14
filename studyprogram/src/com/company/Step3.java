package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Stack;

public class Step3 extends JPanel{

    private Main win;
    public String line = "";
    public int textSize = 14;
    public Step3(Main win, String filename,int textSize) {
        this.win = win;
        this.textSize = textSize;
        String s = "";
        win.currentpanelnumber = 3;
        String []parseline;
        win.y = 20;
        int i=0;
        setBounds(win.frameSize.width/4,0,1000,win.frameSize.height);
        boolean titleCheck = false;
        Color color1 = new Color(0xe6e2e2);
        Color color2 = new Color(0xffffff);
        Color color3 = new Color(0x7ecef4);


        setLayout(null);

        try{

            File file = new File(filename);
            //파일 객체 생성
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"euc-kr"));
            while((line = bufReader.readLine()) != null){
                JLabel [] contentLabel = new JLabel[72];
                titleCheck = false;
                if(line.contains("{")) {
                    titleCheck = true;
                }
                parseline = line.split("");
                String newline = "";
                boolean judge = false;
                for(int j=0;j<parseline.length;j++){
                    if(parseline[j].equals("}")){
                        judge = false;
                    }
                    if(judge == true){
                        newline+=parseline[j];
                    }
                    if(parseline[j].equals("{")){
                        judge = true;
                    }

                    if(judge == false){
                        newline+="  ";
                    }



                }
                contentLabel[i] = new JLabel(newline);
                contentLabel[i].setFont(new Font("맑은 고딕", Font.BOLD, textSize));
                contentLabel[i].setBounds(win.x, win.y, win.width,textSize+5);
                if(titleCheck == false) {
                    contentLabel[i].setOpaque(true);
                    contentLabel[i].setBackground(color2);//글자배경색갈
                }
                if(titleCheck){
                    contentLabel[i].setOpaque(true);
                    contentLabel[i].setBackground(color3);//타이틀배경색갈
                }
                add(contentLabel[i]);
                win.y+=textSize+5;



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

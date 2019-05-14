package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

import static com.company.Main.frameHeight;

public class Step1 extends JPanel{
    /*
    @Override
    protected void paintComponent(Graphics g) {
        Dimension d = getSize();
        ImageIcon originupbar = new ImageIcon("C:\\Users\\주동민\\Documents\\-Memorization-Program\\studyprogram\\src\\상단바.png");  //상단 하늘색이미지
        Image originupbarImg = originupbar.getImage();
        Image changeduobarimg= originupbarImg.getScaledInstance(win.width,textSize+3, Image.SCALE_SMOOTH );
        ImageIcon upbarimg = new ImageIcon(changeduobarimg);
        g.drawImage(upbarimg.getImage(),0,0,d.width,d.height,null);
    }
    */

    private Main win;
    private String line = "";
    private int textSize = 14;
    private String []parseline;
    private int i;
    private boolean titleCheck;
    private JLabel [] contentLabel = new JLabel[72];
    private Queue<String> queue = new LinkedList<String>();
    private String newline;
    private boolean judge = false;
    public Step1(Main win, String filename,int textSize) {

        this.win = win;
        this.textSize = textSize;
        win.currentpanelnumber = 1;
        win.y = 20;
        i=0;
        titleCheck = false;
        setLayout(null);

        try{
            File file = new File(filename);
            //파일 객체 생성
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"euc-kr"));
            while((line = bufReader.readLine()) != null){
                titleCheck = false;
                if(line.contains("{")) {
                    titleCheck = true;
                }
                parseline = line.split("");
                newline = "";
                judge = false;
                for(int j=0;j<parseline.length;j++){

                    if(parseline[j].equals("}")){
                        judge = false;
                        continue;
                    }
                    if(judge == true){
                        queue.offer(parseline[j]);
                    }
                    if(parseline[j].equals("{")){
                        judge = true;
                        continue;
                    }
                    if(judge == false){
                        queue.offer(parseline[j]);
                    }
                }
                while(!queue.isEmpty()){
                    newline+=queue.poll();
                }

                contentLabel[i] = new JLabel(newline);
                contentLabel[i].setFont(new Font("맑은 고딕", Font.BOLD, textSize));
                //contentLabel[i].setForeground(Color.orange);
                //contentLabel[i].setBackground(Color.green);
                contentLabel[i].setBounds(win.x, win.y, win.width,textSize+5);

                if(titleCheck == false) {
                    contentLabel[i].setOpaque(true);
                    contentLabel[i].setBackground(new Color(0xffffff));//글자배경색갈
                }
                if(titleCheck){
                    contentLabel[i].setOpaque(true);
                    contentLabel[i].setBackground(new Color(0x7ecef4));//타이틀배경색갈
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

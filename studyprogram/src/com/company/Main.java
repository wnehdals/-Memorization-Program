package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public JPanel01 jPanel01 = null;
    public static Step1 step1 = null;
    public static Step2 step2 = null;
    public static Step3 step3 = null;
    public JMenuBar mb;
    public static int currentpanelnumber = 0;
    public static int x = 0;
    public static int y = 20;
    public static int width = 1530;
    public static int height = 15;
    public int textSize = 14;
    public static double frameHeight=0;
    public String filename = "";
    Dimension frameSize = Toolkit.getDefaultToolkit().getScreenSize();
    JScrollPane scrollPane = new JScrollPane();

    public Main() {
        frameSize = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("K - Sharing");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameHeight = frameSize.getHeight()+5000;
        setBounds(0,0,frameSize.width,(int)frameHeight);
        jPanel01 = new JPanel01(this);
        createMenu();
        setLayout(null);
        add(this.jPanel01);
        setVisible(true);

    }

    public void setName(String a){
        filename = a;
    }
    public void change(String panelName,int textSize){
        if(panelName.equals("panel01")){
            getContentPane().removeAll();
            getContentPane().add(jPanel01);
            revalidate();
            repaint();
        }
        else if(panelName.equals("step1")){

            getContentPane().removeAll();
            String fullname = System.getProperty("user.dir")+"\\"+filename;
            Color color2 = new Color(0xffffff);
            scrollPane = new JScrollPane();
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.getVerticalScrollBar().setUnitIncrement(16);
            scrollPane.setBorder(null);
            scrollPane.setOpaque(true);
            scrollPane.setBackground(color2);//글자배경색갈
            scrollPane.setBounds(0,0,frameSize.width-20,frameSize.height-100);
            getContentPane().add(scrollPane);

            x = frameSize.width/6;                                                     //레이블 시작위치수정
            width = (int)(2*(frameSize.getWidth())/3);                                //레이블 폭 크기수정

            step1 = new Step1(this,fullname,textSize);
            step1.setPreferredSize(new Dimension(frameSize.width,(int)frameHeight));
            scrollPane.setViewportView(step1);

            revalidate();
            repaint();
        }
        else if(panelName.equals("step2")){
            System.out.println(filename);
            getContentPane().removeAll();
            String fullname = System.getProperty("user.dir")+"\\"+filename;
            scrollPane = new JScrollPane();
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.getVerticalScrollBar().setUnitIncrement(16);
            scrollPane.setBorder(null);
            scrollPane.setOpaque(true);
            scrollPane.setBackground(new Color(0xffffff));
            scrollPane.setBounds(0,0,frameSize.width-20,frameSize.height-100);
            getContentPane().add(scrollPane);

            //x = frameSize.width/4;
            //width = 1000;

            step2 = new Step2(this,fullname,textSize);

            step2.setPreferredSize(new Dimension(frameSize.width,(int)frameHeight));
            scrollPane.setViewportView(step2);

            revalidate();
            repaint();
        }
        else if(panelName.equals("step3")){
            System.out.println(filename);
            getContentPane().removeAll();
            String fullname = System.getProperty("user.dir")+"\\"+filename;

            scrollPane = new JScrollPane();
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.getVerticalScrollBar().setUnitIncrement(16);
            scrollPane.setBorder(null);
            scrollPane.setOpaque(true);
            scrollPane.setBackground(new Color(0xffffff));
            scrollPane.setBounds(0,0,frameSize.width-20,frameSize.height-100);
            getContentPane().add(scrollPane);

            //x = frameSize.width/4;
            //width = 1000;

            step3 = new Step3(this,fullname,textSize);
            step3.setLayout(null);
            step3.setPreferredSize(new Dimension(frameSize.width,(int)frameHeight));
            scrollPane.setViewportView(step3);

            revalidate();
            repaint();
        }

    }

    public void createMenu(){
        mb = new JMenuBar();

        JMenuItem [] menuItem = new JMenuItem[4];
        JMenuItem [] menuItem2 = new JMenuItem[5];
        String[] itemTitle = {"1단계","2단계","3단계","처음화면"};
        String[] itemTitle2 = {"10","12","14","16","18","20"};
        JMenu screenMenu = new JMenu("단계");
        JMenu screenMenu2 = new JMenu("글자크기");


        MenuActionListener listener = new MenuActionListener();
        for(int i=0;i<menuItem.length-1;i++){
            menuItem[i] = new JMenuItem(itemTitle[i]);
            menuItem[i].addActionListener(listener);
            screenMenu.add(menuItem[i]);
        }
        screenMenu.addSeparator();
        menuItem[3] = new JMenuItem(itemTitle[3]);
        menuItem[3].addActionListener(listener);
        screenMenu.add(menuItem[3]);
        for(int i=0;i<menuItem2.length;i++){
            menuItem2[i] = new JMenuItem(itemTitle2[i]);
            menuItem2[i].addActionListener(listener);
            screenMenu2.add(menuItem2[i]);
        }

        mb.setForeground(Color.darkGray);
        mb.add(screenMenu);
        mb.add(screenMenu2);

        setJMenuBar(mb);
        if(currentpanelnumber > 1) {
            mb.setVisible(true);
        }
        else
            mb.setVisible(false);



    }
    class MenuActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            switch (cmd){
                case "1단계":
                    change("step1",textSize);
                    break;
                case "2단계":
                    change("step2",textSize);
                    break;
                case "3단계":
                    change("step3",textSize);
                    break;
                case "10":
                    if(currentpanelnumber == 1){
                        textSize = 10;
                        change("step1",textSize);
                    }
                    else if(currentpanelnumber == 2){
                        textSize = 10;
                    change("step2",textSize);
                    }
                    else if(currentpanelnumber == 3){
                        textSize = 10;
                        change("step3",textSize);
                    }
                    break;
                case "12":
                    if(currentpanelnumber == 1){
                        textSize = 12;
                        change("step1",textSize);
                    }
                    else if(currentpanelnumber == 2){
                        textSize = 12;
                        change("step2",textSize);
                    }
                    else if(currentpanelnumber == 3){
                        textSize = 12;
                        change("step3",textSize);
                    }
                    break;
                case "14":
                    if(currentpanelnumber == 1){
                        textSize = 14;
                        change("step1",textSize);
                    }
                    else if(currentpanelnumber == 2){
                        textSize = 14;
                        change("step2",textSize);
                    }
                    else if(currentpanelnumber == 3){
                        textSize = 14;
                        change("step3",textSize);
                    }
                    break;
                case "16":
                    if(currentpanelnumber == 1){
                        textSize = 16;
                        change("step1",textSize);
                    }
                    else if(currentpanelnumber == 2){
                        textSize = 16;
                        change("step2",textSize);
                    }
                    else if(currentpanelnumber == 3){
                        textSize = 16;
                        change("step3",textSize);
                    }
                    break;
                case "18":
                    if(currentpanelnumber == 1){
                        textSize = 18;
                        change("step1",textSize);
                    }
                    else if(currentpanelnumber == 2){
                        textSize = 18;
                        change("step2",textSize);
                    }
                    else if(currentpanelnumber == 3){
                        textSize= 18;
                        change("step3",textSize);
                    }
                    break;
                case "처음화면":
                    change("panel01",textSize);
                    break;

            }
        }
    }




    public static void main(String[] args) {
        Main frame = new Main();

    }
}

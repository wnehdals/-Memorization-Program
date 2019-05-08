package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public JPanel01 jPanel01 = null;
    public static JPanel02 jPanel02 = null;
    public static JPanel03 jPanel03 = null;
    public String filename = "";
    public void setName(String a){
        filename = a;
    }
    public void change(String panelName){
        if(panelName.equals("panel01")){
            getContentPane().removeAll();
            getContentPane().add(jPanel01);
            revalidate();
            repaint();
        }
        else if(panelName.equals("panel02")){
            System.out.println(filename);
            getContentPane().removeAll();
            jPanel02 = new JPanel02(this,filename);
            getContentPane().add(jPanel02);
            revalidate();
            repaint();
        }
        else if(panelName.equals("panel03")){
            System.out.println(filename);
            getContentPane().removeAll();
            jPanel03 = new JPanel03(this,filename);
            getContentPane().add(jPanel03);
            revalidate();
            repaint();
        }

    }

    public void createMenu(){
        JMenuBar mb = new JMenuBar();
        JMenuItem [] menuItem = new JMenuItem[3];
        String[] itemTitle = {"first","second","third"};
        JMenu screenMenu = new JMenu("단계");

        MenuActionListener listener = new MenuActionListener();
        for(int i=0;i<menuItem.length;i++){
            menuItem[i] = new JMenuItem(itemTitle[i]);
            menuItem[i].addActionListener(listener);
            screenMenu.add(menuItem[i]);
        }
        mb.add(screenMenu);
        setJMenuBar(mb);
    }
    class MenuActionListener extends Main implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            switch (cmd){
                case "first":
                    this.change("panel02");
                    break;
                case "second":
                    System.out.println("dd");
                    this.getContentPane().removeAll();
                    this.jPanel03 = new JPanel03(this,filename);
                    this.getContentPane().add(jPanel03);
                    this.revalidate();
                    this.repaint();
                    break;

            }
        }
    }




    public static void main(String[] args) {


        Main frame = new Main();
        frame.setTitle("암기프로그램");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,1530,800);
        frame.jPanel01 = new JPanel01(frame);
        frame.createMenu();
        frame.add(frame.jPanel01);
        //frame.jPanel02 = new JPanel02(frame,frame.jPanel01.filename);
        frame.setVisible(true);


        /*
        JFrame frame = new JFrame("study");
        frame.setBounds(0,0,720,1000);
        JTextField TextField = new JTextField();
        TextField.setBounds(10,10,600,100);
        frame.add(TextField);
        frame.setVisible(true);
        */
    }
}

package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JPanel contentPane;
    public studyPanel StudyPanel = new studyPanel();
    public static String filename;
    public Main(){

        setTitle("암기프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0,720,1000);
        contentPane = new JPanel();
        setContentPane(contentPane);
        //setContentPane(StudyPanel.studypane);
        contentPane.setLayout(null);
        contentPane.add(StudyPanel.studypane);
        StudyPanel.studypane.setVisible(false);



        JLabel titlelabel = new JLabel("암기프로그램");                                       //패널제목
        titlelabel.setFont(new Font("Serif", Font.BOLD, 35));
        titlelabel.setBounds(260, 15, 720, 100);

        JLabel commandlabel = new JLabel("읽어드릴 메모장 파일을 입력하세요");                                       //패널제목
        commandlabel.setFont(new Font("Serif", Font.BOLD, 25));
        commandlabel.setBounds(170, 400, 720, 100);

        JTextField TextField = new JTextField(60);
        TextField.setBounds(260,500,200,30);
        TextField.setText("파일명.txt");


        JButton startButton = new JButton("START");
        startButton.setBounds(260,550,200,60);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filename = TextField.getText();
                StudyPanel.studypane.setVisible(true);
                //contentPane.setVisible(false);

                titlelabel.setVisible(false);
                commandlabel.setVisible(false);
                startButton.setVisible(false);
                TextField.setVisible(false);

            }
        });
        contentPane.add(titlelabel);
        contentPane.add(commandlabel);
        contentPane.add(startButton);
        contentPane.add(TextField);

    }


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();                //메인 프레임 실행
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

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

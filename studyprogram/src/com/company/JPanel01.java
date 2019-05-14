package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanel01 extends JPanel {
    private Main win;
    private String filename;
    private JTextField TextField;
    private JLabel titlelabel;
    private JLabel commandlabel;
    private JButton startButton;
    public JPanel01(Main win) {
        this.win = win;
        win.currentpanelnumber = 0;
        setForeground(Color.WHITE);
        setBackground(Color.white);
        setLayout(null);
        setBounds(0,0,win.frameSize.width,win.frameSize.height);
        titlelabel = new JLabel("암기프로그램");                                       //패널제목
        titlelabel.setFont(new Font("Serif", Font.BOLD, 35));
        titlelabel.setBounds(win.frameSize.width-1100, win.frameSize.height-1000, 700, 100);

        commandlabel = new JLabel("읽어드릴 메모장 파일을 입력하세요");                                       //패널제목
        commandlabel.setFont(new Font("Serif", Font.BOLD, 25));
        commandlabel.setBounds(win.frameSize.width-1200, win.frameSize.height-700, 670, 100);

        TextField = new JTextField(60);
        TextField.setBounds(win.frameSize.width-1100, win.frameSize.height-600, 200, 30);
        TextField.setText("컴구조chapter5.1.txt");


        startButton = new JButton("START");
        startButton.setBounds(win.frameSize.width-1100, win.frameSize.height-500,200, 60);
        add(titlelabel);
        add(commandlabel);
        add(startButton);
        add(TextField);
        startButton.addActionListener(new MyActionListener());
    }

    class MyActionListener implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            filename = TextField.getText();
            win.setName(filename);



            win.change("step1",14);
            win.mb.setVisible(true);
        }
    }
    /*
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filename = TextField.getText();
                Step1 = new Step1(filename);
                contentPane.add(Step1.studypane);
                Step1.studypane.setVisible(false);

                Step1.studypane.setVisible(true);
                //contentPane.setVisible(false);

                titlelabel.setVisible(false);
                commandlabel.setVisible(false);
                startButton.setVisible(false);
                TextField.setVisible(false);

            }
        });



    }
    */
}

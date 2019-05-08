package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanel01 extends JPanel {
    private Main win;
    public String filename;
    JTextField TextField;

    public JPanel01(Main win) {
        this.win = win;
        setLayout(null);

        JLabel titlelabel = new JLabel("암기프로그램");                                       //패널제목
        titlelabel.setFont(new Font("Serif", Font.BOLD, 35));
        titlelabel.setBounds(260, 15, 1280, 100);

        JLabel commandlabel = new JLabel("읽어드릴 메모장 파일을 입력하세요");                                       //패널제목
        commandlabel.setFont(new Font("Serif", Font.BOLD, 25));
        commandlabel.setBounds(170, 400, 1280, 100);

        TextField = new JTextField(60);
        TextField.setBounds(260, 500, 200, 30);
        TextField.setText("운영체제.txt");


        JButton startButton = new JButton("START");
        startButton.setBounds(260, 550, 200, 60);
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

            win.change("panel02");
        }
    }
    /*
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filename = TextField.getText();
                JPanel02 = new JPanel02(filename);
                contentPane.add(JPanel02.studypane);
                JPanel02.studypane.setVisible(false);

                JPanel02.studypane.setVisible(true);
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

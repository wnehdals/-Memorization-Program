package com.company;

import javax.swing.*;
import java.awt.*;

public class studyPanel {
    public static JPanel studypane;
    filename

    public studyPanel() {
        filename = "d";
        studypane = new JPanel();

        studypane.setLayout(null);
        studypane.setBounds(0, 0, 720, 1000);                //패널 크기 설정

        System.out.println(filename);
        JLabel titlelabel = new JLabel(filename);                                       //패널제목
        titlelabel.setFont(new Font("Serif", Font.BOLD, 35));
        titlelabel.setBounds(260, 15, 720, 100);
        studypane.add(titlelabel);
    }
    public void setFilename(String a){
        filename = a;
    }
}

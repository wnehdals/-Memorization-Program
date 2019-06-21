package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class JPanel01 extends JPanel {
    private Main win;
    private String filename;
    private JTextField TextField;
    private JLabel titlelabel;
    private JLabel commandlabel;
    private JButton startButton;
    private JLabel logoLabel01;
    private JLabel logoLabel02;
    private JLabel logoLabel03;
    private JLabel logoLabel04;
    private JLabel blueLabel;
    private JLabel redLabel;
    private JLabel greenLabel;
    private JLabel yellowLabel;
    private JLabel orangeLabel;
    private ImageIcon blueImageIcon;
    private ImageIcon redImageIcon;
    private ImageIcon greenImageIcon;
    private ImageIcon yellowImageIcon;
    private ImageIcon orangeImageIcon;
    private ImageIcon startbuttonImageIcon;
    public JPanel01(Main win) {
        this.win = win;
        win.currentpanelnumber = 0;
        setForeground(Color.WHITE);
        setBackground(Color.white);
        setLayout(null);
        setBounds(0,0,win.frameSize.width,win.frameSize.height);

        /*
        protected void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon originupbar = new ImageIcon("C:\\Users\\주동민\\Documents\\-Memorization-Program\\studyprogram\\src\\상단바.png");  //상단 하늘색이미지
            Image originupbarImg = originupbar.getImage();
            Image changeduobarimg= originupbarImg.getScaledInstance(win.width,textSize+3, Image.SCALE_SMOOTH );
            ImageIcon upbarimg = new ImageIcon(changeduobarimg);
            g.drawImage(upbarimg.getImage(),0,0,d.width,d.height,null);
        }
        */
        logoLabel01 = new JLabel("2019");
        logoLabel02 = new JLabel("KOREA");
        logoLabel03 = new JLabel("TECH");
        logoLabel04 = new JLabel("학습콘텐츠");

        //logoLabel01.setOpaque(true);
        logoLabel01.setFont(new Font("메이플스토리 OTF",Font.BOLD,30));
        logoLabel01.setForeground(Color.gray);
        logoLabel01.setBounds(win.frameSize.width-1700,win.frameSize.height-1000,300,30);
        add(logoLabel01);

        logoLabel02.setFont(new Font("메이플스토리 OTF",Font.BOLD,30));
        logoLabel02.setForeground(new Color(0x175c8e));
        logoLabel02.setBounds(win.frameSize.width-1750,win.frameSize.height-970,100,30);
        add(logoLabel02);

        logoLabel03.setFont(new Font("메이플스토리 OTF",Font.BOLD,30));
        logoLabel03.setForeground(new Color(0xf7941e));
        logoLabel03.setBounds(win.frameSize.width-1650,win.frameSize.height-970,100,30);
        add(logoLabel03);

        logoLabel04.setFont(new Font("메이플스토리 OTF",Font.BOLD,30));
        logoLabel04.setForeground(new Color(0X548235));
        logoLabel04.setBounds(win.frameSize.width-1730,win.frameSize.height-940,170,30);
        add(logoLabel04);


        titlelabel = new JLabel("암기프로그램");                                       //패널제목
        titlelabel.setFont(new Font("메이플스토리 OTF", Font.BOLD, 35));
        titlelabel.setBounds(win.frameSize.width-1750, win.frameSize.height-700, 300, 50);

        commandlabel = new JLabel("메모장 이름");                                       //패널제목
        commandlabel.setFont(new Font("메이플스토리 OTF", Font.BOLD, 35));
        commandlabel.setBounds(win.frameSize.width-1750, win.frameSize.height-600, 300, 50);

        TextField = new JTextField(60);
        TextField.setBounds(win.frameSize.width-1550, win.frameSize.height-595, 200, 40);
        TextField.setText(".txt");

        URL imageURL = JPanel01.class.getClassLoader().getResource("startbuttonimg.png");
        startbuttonImageIcon = changeImg(imageURL,400,60);
        //startbuttonImageIcon = changeImg("C:\\Users\\주동민\\Documents\\-Memorization-Program\\studyprogram\\image\\startbuttonimg.png",400,60);
        startButton = new JButton("",startbuttonImageIcon);
        startButton.setBounds(win.frameSize.width-1750, win.frameSize.height-520,400, 60);

        int imageIconWidth = 500;
        int imageIconHeight = 370;

        imageURL = JPanel01.class.getClassLoader().getResource("blueimg.png");
        blueImageIcon = changeImg(imageURL,imageIconWidth,imageIconHeight);
        blueLabel = new JLabel("");
        blueLabel.setIcon(blueImageIcon);
        blueLabel.setBounds(win.frameSize.width-650,win.frameSize.height-1050,imageIconWidth,imageIconHeight);
        //blueLabel.setOpaque(true);
        blueLabel.setBackground(Color.gray);
        add(blueLabel);

        imageURL = JPanel01.class.getClassLoader().getResource("orangeimg.png");
        orangeImageIcon = changeImg(imageURL,imageIconWidth,imageIconHeight);
        //orangeImageIcon = changeImg("C:\\Users\\주동민\\Documents\\-Memorization-Program\\studyprogram\\image\\orangeimg.png",imageIconWidth,imageIconHeight);
        orangeLabel = new JLabel("");
        orangeLabel.setIcon(orangeImageIcon);
        orangeLabel.setBounds(win.frameSize.width-1150,win.frameSize.height-900,imageIconWidth,imageIconHeight);
        //orangeLabel.setOpaque(true);
        orangeLabel.setBackground(Color.gray);
        add(orangeLabel);

        imageURL = JPanel01.class.getClassLoader().getResource("greenimg.png");
        greenImageIcon = changeImg(imageURL,imageIconWidth-200,imageIconHeight-200);
        //greenImageIcon = changeImg("C:\\Users\\주동민\\Documents\\-Memorization-Program\\studyprogram\\image\\greenimg.png",imageIconWidth-200,imageIconHeight-200); //300 180
        greenLabel = new JLabel("");
        greenLabel.setIcon(greenImageIcon);
        greenLabel.setBounds(win.frameSize.width-450,win.frameSize.height-680,imageIconWidth-200,imageIconHeight-200);
        //greenLabel.setOpaque(true);
        greenLabel.setBackground(Color.gray);
        add(greenLabel);

        imageURL = JPanel01.class.getClassLoader().getResource("yellowimg.png");
        yellowImageIcon = changeImg(imageURL,imageIconWidth,imageIconHeight);
        //yellowImageIcon = changeImg("C:\\Users\\주동민\\Documents\\-Memorization-Program\\studyprogram\\image\\yellowimg.png",imageIconWidth,imageIconHeight);
        yellowLabel = new JLabel("");
        yellowLabel.setIcon(yellowImageIcon);
        yellowLabel.setBounds(win.frameSize.width-750,win.frameSize.height-500,imageIconWidth,imageIconHeight);
        //yellowLabel.setOpaque(true);
        yellowLabel.setBackground(Color.gray);
        add(yellowLabel);

        imageURL = JPanel01.class.getClassLoader().getResource("redimg.png");
        redImageIcon = changeImg(imageURL,imageIconWidth-150,imageIconHeight-150);
        //redImageIcon = changeImg("C:\\Users\\주동민\\Documents\\-Memorization-Program\\studyprogram\\image\\redimg.png",imageIconWidth-150,imageIconHeight-150);
       redLabel = new JLabel("");
       redLabel.setIcon(redImageIcon);
       redLabel.setBounds(win.frameSize.width-1100,win.frameSize.height-530,imageIconWidth-150,imageIconHeight-150);
       //redLabel.setOpaque(true);
       redLabel.setBackground(Color.gray);
        add(redLabel);






        add(titlelabel);
        add(commandlabel);
        add(startButton);
        add(TextField);
        startButton.addActionListener(new MyActionListener());
    }
    private static ImageIcon changeImg(URL url,int width,int height) {

        ImageIcon originimgIcon = new ImageIcon(url);  //상단 하늘색이미지
        Image originImg = originimgIcon.getImage();
        Image changeimg= originImg.getScaledInstance(width,height, Image.SCALE_SMOOTH );
        ImageIcon changeimgIcon = new ImageIcon(changeimg);
        return changeimgIcon;
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

}

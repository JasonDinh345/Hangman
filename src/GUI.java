import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private JFrame frame;
    private Dimension defaultSize;
    private JPanel gamePanel;
    private JPanel createPlayer;
    private Game game;
    private JPanel startScreen;
    private JButton playButton;
    private JLabel title;
    private ImageIcon home;
    private Image scaledHome;
    private ImageIcon newHome;
    private JButton homeButton;
    private JButton homeButton2;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton player1btn;
    private JButton player2btn;
    private JButton player3btn;
    private JButton player4btn;
    private JButton player5btn;
    private JButton player6btn;
    private JButton player7btn;
    private JButton player8btn;
    private JLabel titleCreatePlayer;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Player player5;
    private Player player6;
    private Player player7;
    private Player player8;
    private JLabel q,w,e,r,t,y,u,i,o,p,a,s,d,f,g,h,j,k,l,z,x,c,v,b,n,m,one,two,three,four,five,six,seven,eight,nine,zero;
    private JTextField userAnswerInput;
    private JButton submitbtn;
    private Row messageR1;
    private Picture hangImage;
    

    public GUI(){
        javax.swing.UIManager.put("OptionPane.messageFont", new Font("Comic Sans MS", Font.PLAIN, 20));
        javax.swing.UIManager.put("OptionPane.buttonFont", new Font("Comic Sans MS", Font.PLAIN, 15));
        
        defaultSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width =(int)defaultSize.getWidth();
        int height = (int)defaultSize.getHeight();
        System.out.println();
       
        //card layout
        cardLayout = new CardLayout();

        
        //game setup
        game = new Game();


         //play button
        playButton = new JButton("Play");
        playButton.setBounds(width/2 - 400, height/2,800,200);
        playButton.setFocusable(false);
        playButton.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        playButton.addActionListener(this);

        
        //title

        title = new JLabel("HANGMAN",SwingConstants.CENTER);
        title.setBounds(width/2 - 400, 200,800,200);
        title.setFont(new Font("Comic Sans MS", Font.PLAIN,80));

        //start screen 
        startScreen = new JPanel();
        startScreen.setLayout(null);
        startScreen.setVisible(true);


        startScreen.add(playButton);
        startScreen.add(title);
    

        //home button
        home = new ImageIcon(".//res//house.png");
        scaledHome = home.getImage().getScaledInstance(home.getIconWidth()/3, home.getIconHeight()/3, 1);
        newHome = new ImageIcon(scaledHome);
        homeButton = new JButton();
        homeButton.setBounds(20,20,home.getIconWidth()/3,home.getIconHeight()/3 );
        homeButton.setFocusable(false);
        homeButton.setIcon(newHome);
        homeButton.addActionListener(this);



        //player button row 1
        player1btn = new JButton();
        game.readTextForButton(player1btn, 0,game.getPlayerList()[0]);
        player1btn.setBounds((5),height/3,(width/4) -25,300);
        player1btn.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        player1btn.setFocusable(false);
        player1btn.addActionListener(this);

        player2btn = new JButton();
        game.readTextForButton(player2btn, 1, game.getPlayerList()[1]);
        player2btn.setBounds((5)+width/4,height/3,(width/4) -25,300);
        player2btn.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        player2btn.setFocusable(false);
        player2btn.addActionListener(this);

        player3btn = new JButton();
        game.readTextForButton(player3btn, 2,game.getPlayerList()[2]);
        player3btn.setBounds((5)+width/2,height/3,(width/4) -25,300);
        player3btn.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        player3btn.setFocusable(false);
        player3btn.addActionListener(this);


        player4btn = new JButton();
        game.readTextForButton(player4btn, 3,game.getPlayerList()[3]);
        player4btn.setBounds((5)+(width/2 + width/4),height/3,(width/4) -25,300);
        player4btn.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        player4btn.setFocusable(false);
        player4btn.addActionListener(this);


        //row2
        player5btn = new JButton();
        game.readTextForButton(player5btn, 4, game.getPlayerList()[4]);
        player5btn.setBounds(5,(height/3+height/3)-50,(width/4) -25,300);
        player5btn.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        player5btn.setFocusable(false);
        player5btn.addActionListener(this);


        player6btn = new JButton();
        game.readTextForButton(player6btn, 5, game.getPlayerList()[5]);
        player6btn.setBounds((5)+width/4,(height/3+height/3)-50,(width/4) -25,300);
        player6btn.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        player6btn.setFocusable(false);
        player6btn.addActionListener(this);


        player7btn = new JButton();
        game.readTextForButton(player7btn, 6, game.getPlayerList()[6]);
        player7btn.setBounds((5)+width/2,(height/3+height/3)-50,(width/4) -25,300);
        player7btn.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        player7btn.setFocusable(false);
        player7btn.addActionListener(this);


        player8btn = new JButton();
        game.readTextForButton(player8btn, 7, game.getPlayerList()[7]);
        player8btn.setBounds((5)+(width/2 + width/4),(height/3+height/3) -50,(width/4) -25,300);
        player8btn.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        player8btn.setFocusable(false);
        player8btn.addActionListener(this);


        //title for create plyer
        titleCreatePlayer = new JLabel("Choose a Player",SwingConstants.CENTER);
        titleCreatePlayer.setBounds(width/2 - 400, 20,800,300);
        titleCreatePlayer.setFont(new Font("Comic Sans MS", Font.PLAIN,80));
        

        //panel to show players
        createPlayer = new JPanel();
        createPlayer.setLayout(null);
      
  

      
        createPlayer.add(player1btn);
        createPlayer.add(player2btn);
        createPlayer.add(player3btn);
        createPlayer.add(player4btn);
        createPlayer.add(player5btn);
        createPlayer.add(player6btn);
        createPlayer.add(player7btn);
        createPlayer.add(player8btn);
        createPlayer.add(homeButton);
        createPlayer.add(titleCreatePlayer);
        //homebutton 2
        homeButton2 = new JButton();
        homeButton2.setBounds(20,20,home.getIconWidth()/3,home.getIconHeight()/3 );
        homeButton2.setFocusable(false);
        homeButton2.setIcon(newHome);
        homeButton2.addActionListener(this);


        


        //letters

        //row 1
        q = new JLabel("Q");
        q.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        q.setBounds(174,height/2+100,50,100);

        w= new JLabel("W");
        w.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        w.setBounds(349,height/2+100 ,50,100);
       
        
        e= new JLabel("E");
        e.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        e.setBounds(524,height/2+100,50,100);
    
        r= new JLabel("R");
        r.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        r.setBounds(698,height/2 +100,50,100);

        t= new JLabel("T");
        t.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        t.setBounds(872,height/2 +100,50,100);

        y= new JLabel("Y");
        y.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        y.setBounds(1047,height/2+100 ,50,100);

        u= new JLabel("U");
        u.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        u.setBounds(1222,height/2+100 ,50,100);

        i= new JLabel("I");
        i.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        i.setBounds(1396,height/2+100 ,50,100);

        o= new JLabel("O");
        o.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        o.setBounds(1571,height/2 +100,50,100);

        p= new JLabel("P");
        p.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        p.setBounds(1745,height/2 +100,50,100);


        //row 2
        a= new JLabel("A");
        a.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        a.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        a.setBounds(((w.getX()-q.getX())/3) + q.getX(),height/2+180 ,50,100);

        s= new JLabel("S");
        s.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        s.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        s.setBounds(((e.getX()-w.getX())/3) + w.getX(),height/2+180 ,50,100);

        d= new JLabel("D");
        d.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        d.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        d.setBounds(((r.getX()-e.getX())/3) + e.getX(),height/2 +180,50,100);

        f= new JLabel("F");
        f.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        f.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        f.setBounds(((t.getX()-r.getX())/3) + r.getX(),height/2 +180,50,100);

        g= new JLabel("G");
        g.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        g.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        g.setBounds(((y.getX()-t.getX())/3) + t.getX(),height/2 +180,50,100);

        h= new JLabel("H");
        h.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        h.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        h.setBounds(((u.getX()-y.getX())/3) + y.getX(),height/2 +180,50,100);

        j= new JLabel("J");
        j.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        j.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        j.setBounds(((i.getX()-u.getX())/3) + u.getX(),height/2 +180,50,100);

        k= new JLabel("K");
        k.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        k.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        k.setBounds(((o.getX()-i.getX())/3) + i.getX(),height/2+180 ,50,100);

        l= new JLabel("L");
        l.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        l.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        l.setBounds(((p.getX()-o.getX())/3) + o.getX(),height/2+180 ,50,100);

        //row 3
        z= new JLabel("Z");
        z.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        z.setBounds(((s.getX()-a.getX())/3) + a.getX(),height/2+260 ,50,100);

        x= new JLabel("X");
        x.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        x.setBounds(((d.getX()-s.getX())/3) + s.getX(),height/2+260 ,50,100);

        c= new JLabel("C");
        c.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        c.setBounds(((f.getX()-d.getX())/3) + d.getX(),height/2+260 ,50,100);

        v= new JLabel("V");
        v.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        v.setBounds(((g.getX()-f.getX())/3) + f.getX(),height/2+260 ,50,100);

        b= new JLabel("B");
        b.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        b.setBounds(((h.getX()-g.getX())/3) + g.getX(),height/2+260 ,50,100);

        n= new JLabel("N");
        n.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        n.setBounds(((j.getX()-h.getX())/3) + h.getX(),height/2+260 ,50,100);

        m= new JLabel("M");
        m.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        m.setBounds(((k.getX()-j.getX())/3) + j.getX(),height/2+260 ,50,100);
        
        //NUMBRES
         one = new JLabel("1");
        one .setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        one .setBounds(174-((t.getX()-r.getX())/3),height/2 +40,50,100);
        
        two = new JLabel("2");
        two .setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        two .setBounds(174*2-((t.getX()-r.getX())/3),height/2+40,50,100);

        three = new JLabel("3");
        three .setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        three .setBounds(174*3-((t.getX()-r.getX())/3),height/2+40,50,100);

        four = new JLabel("4");
        four .setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        four .setBounds(174*4-((t.getX()-r.getX())/3),height/2+40,50,100);

        five = new JLabel("5");
        five .setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        five .setBounds(174*5-((t.getX()-r.getX())/3),height/2+40,50,100);

        six = new JLabel("6");
        six .setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        six .setBounds(174*6-((t.getX()-r.getX())/3),height/2+40,50,100);


        seven = new JLabel("7");
        seven .setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        seven .setBounds(174*7-((t.getX()-r.getX())/3),height/2+40,50,100);

        eight = new JLabel("8");
        eight .setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        eight .setBounds(174*8-((t.getX()-r.getX())/3),height/2+40,50,100);

        nine = new JLabel("9");
        nine .setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        nine .setBounds(174*9-((t.getX()-r.getX())/3),height/2+40,50,100);

        zero = new JLabel("0");
        zero .setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        zero .setBounds(174*10-((t.getX()-r.getX())/3),height/2+40,50,100);
       


        //message row 1
        messageR1 = new Row("");
        messageR1.setFont(new Font("Comic Sans MS", Font.PLAIN,60));
        messageR1.setBounds(width/2 - (messageR1.getText().length())*16,height/2 -140, 1920, 70);

        

        System.out.println(width/2 - (messageR1.getText().length())*40);
        System.out.println(width/2);
        System.out.println((messageR1.getText().length())*40);
        System.out.println(messageR1.getText().length());

        //submit btn
        submitbtn = new JButton("SUBMIT");
        submitbtn.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
        submitbtn.setBounds(20,900, 150, 50);
        submitbtn.setFocusable(false);
        submitbtn.addActionListener(this);
        //user enter leter thing
        userAnswerInput = new JTextField();
        userAnswerInput.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        userAnswerInput.setBounds(200, 900,1650,50);

        //hang img
        hangImage  = new Picture();
        ImageIcon image = new ImageIcon(".//res//hang.png");
        hangImage.setIcon(image);
        hangImage.setBounds(width/2 - image.getIconWidth()/2, -80, image.getIconWidth(), image.getIconHeight());
        //panel for game  
        gamePanel = new JPanel();
        gamePanel.setLayout(null);
      
       gamePanel.add(q);
        gamePanel.add(w);
        gamePanel.add(e);
        gamePanel.add(r);
        gamePanel.add(t);
        gamePanel.add(y);
        gamePanel.add(u);
        gamePanel.add(i);
        gamePanel.add(o);
        gamePanel.add(p);
        gamePanel.add(a);
        gamePanel.add(s);
        gamePanel.add(d);
        gamePanel.add(f);
        gamePanel.add(e);
        gamePanel.add(g);
        gamePanel.add(h);
        gamePanel.add(j);
        gamePanel.add(k);
        gamePanel.add(l);
        gamePanel.add(z);
        gamePanel.add(x);
        gamePanel.add(c);
        gamePanel.add(v);
        gamePanel.add(b);
        gamePanel.add(n);
        gamePanel.add(m);
        gamePanel.add(one);
        gamePanel.add(two);
        gamePanel.add(three);
        gamePanel.add(four);
        gamePanel.add(five);
        gamePanel.add(six);
        gamePanel.add(seven);
        gamePanel.add(eight);
        gamePanel.add(nine);
        gamePanel.add(zero);
        gamePanel.add(userAnswerInput);
        gamePanel.add(submitbtn);
        gamePanel.add(messageR1);
        gamePanel.add(hangImage);
        
        
    

        gamePanel.add(homeButton2);
         //main pnael
        mainPanel = new JPanel();
        mainPanel.setLayout(cardLayout);

        mainPanel.add("1", startScreen);
        mainPanel.add("2", createPlayer);
        mainPanel.add("3", gamePanel);
        //frame
        frame = new JFrame("Hangman");
        frame.setMinimumSize(defaultSize);
        frame.setMaximumSize(defaultSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        cardLayout.show( mainPanel, "1");
        //adding panels
        frame.add(mainPanel);
          frame.pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
      //sumbit guess
        if(e.getSource() == submitbtn){
            game.checkAnswer(userAnswerInput.getText(), messageR1, cardLayout, mainPanel, hangImage);
            userAnswerInput.setText("");
            
        }
        
        //on start to create word
        if(e.getSource() == playButton){
            cardLayout.show( mainPanel, "2");
            
        }
        //home button on create word
        if(e.getSource()==homeButton){
           cardLayout.show( mainPanel, "1");
           hangImage.changeImage(".//res//hang.png");
           game.getSelectedPlayer().restartLives();
            
        }
        //home button on game panel
         if(e.getSource()==homeButton2){
            cardLayout.show( mainPanel, "1");
            hangImage.changeImage(".//res//hang.png");
            game.getSelectedPlayer().restartLives();
           
        }
        //player 1

        if(e.getSource() == player1btn){
            game.addPlayerToButton(player1btn, player1, cardLayout, mainPanel, messageR1, 0);
            }
            //plater 2
         if(e.getSource() == player2btn){
           game.addPlayerToButton(player2btn, player2, cardLayout, mainPanel, messageR1, 1);
            }
            //plater 3
             if(e.getSource() == player3btn){
          game.addPlayerToButton(player3btn, player3, cardLayout, mainPanel, messageR1, 2);
            }
            //player 4
             if(e.getSource() == player4btn){
           game.addPlayerToButton(player4btn, player4, cardLayout, mainPanel, messageR1, 3);
            }
            //player 5
             if(e.getSource() == player5btn){
           game.addPlayerToButton(player5btn, player5, cardLayout, mainPanel, messageR1, 4);
            }
         //player 6   
         if(e.getSource() == player6btn){
           game.addPlayerToButton(player6btn, player6, cardLayout, mainPanel, messageR1, 5);
            }
        //player 7
        if(e.getSource() == player7btn){
           game.addPlayerToButton(player7btn, player7, cardLayout, mainPanel, messageR1, 6);
            }
        //player 8
        if(e.getSource() == player8btn){
           game.addPlayerToButton(player8btn, player8, cardLayout, mainPanel, messageR1, 7);
            }
           
        
    }
}

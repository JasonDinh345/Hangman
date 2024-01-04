import java.awt.CardLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Game {
    private String hiddenMessage;
    private String shownWord;
    private Player[] playerList= {new Player(),new Player(),new Player(),new Player(),new Player(),new Player(),new Player(),new Player()};
    private Player selectedPlayer;
    private File textFile;
    private Scanner scan;
    private String fileContents;
    private StringBuffer buffer;
    private FileWriter writer;
    private String nameFromFile;
    private String[] selectedMan = {"","","","","","",""};
    public Game() {

        hiddenMessage = "";
        selectedPlayer = null;
        shownWord = "";

       textFile = new File(".//res//playerData.txt");
        try {
            scan = new Scanner(textFile);
        } catch (FileNotFoundException e) {
           
            e.printStackTrace();
        }
        buffer = new StringBuffer();
        while (scan.hasNextLine()){
            buffer.append(scan.nextLine() + System.lineSeparator());
        }
        fileContents = buffer.toString();
        
        scan.close();
    }
    public void setSelectedMan(){
        Man man = new Man();
        man.getManFiles(selectedMan);
    } 
    public void characterOptions(CardLayout cardLayout, Row messageR1, JPanel mainPanel, int playerNum, JButton playerBtn){
        String[] options = {"Play", "Rename", "Delete"};
         int check = JOptionPane.showOptionDialog(null, playerList[playerNum].getName(), "Choose an Option", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,0);
        if (check==0){
                 cardLayout.show(mainPanel,"3");
                 this.createHiddenMsg(cardLayout, mainPanel);
                 this.showMessageOnScreen(messageR1,  cardLayout, mainPanel);
                 this.setSelectedMan();

        }else if(check == 1){
            renamePlayer(playerNum, playerBtn);
        }else if(check == 2){
            deleteCharacter(playerNum, playerBtn);
        }else{
            return;
        }
    }
    public void checkLife(CardLayout cLayout, JPanel main, Picture man){
        int lives = selectedPlayer.getLives();
     
        String[] responses = {"Play Again","Select New Player", "Home"};
        if(lives  != 7&& lives  != 0){
          man.changeImage((selectedMan[7-lives-1]));
        }else if(lives == 0){
            man.changeImage((selectedMan[6]));
           selectedPlayer.restartLives();
       
           
        
            int check = JOptionPane.showOptionDialog(null, "Game Over", "You Lost! Word: "+ hiddenMessage, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responses,0);
            shownWord ="";
            hiddenMessage = "";
            if(check==0){
                cLayout.show(main, "3");
                man.changeImage(".//res//hang.png");
                this.createHiddenMsg(cLayout, main);
                this.setSelectedMan();
                
            }else if(check == 1){
                cLayout.show(main, "2");
                man.changeImage(".//res//hang.png");
            }else if(check == 2){
                cLayout.show(main, "1");
                man.changeImage(".//res//hang.png");
            }else{
                cLayout.show(main, "1");
                man.changeImage(".//res//hang.png");
            }
        }
    }
    public void deleteCharacter(int playerNum, JButton playerBtn){
        playerNum++;
        String oldLine = "P" +playerNum+" Name:" + selectedPlayer.getName();
        String newLine = "P" +playerNum+" Name:";
            fileContents = fileContents.replaceAll(oldLine, newLine);
                try {
                    writer = new FileWriter(".//res//playerData.txt");
                    writer.append(fileContents);
                    writer.flush();
                
                } catch (IOException e) {
                            
                     e.printStackTrace();
                }
                playerNum--;
            playerList[playerNum].setName("(Create New Player)");
            readTextForButton(playerBtn, playerNum, selectedPlayer);
    }
    public void renamePlayer(int playerNum, JButton playerButton){
       playerNum++;
        String newName = JOptionPane.showInputDialog("Choose a New Name");
        if(newName == null || newName.toString().equals("1")||newName.toString().equals("-1")){
            return;
        }else if(newName.equals("")||newName.length()>10){
            JOptionPane.showMessageDialog(null,"Enter a Valid Name","Error", JOptionPane.ERROR_MESSAGE);
            this.renamePlayer(playerNum, playerButton);
            return;
        }

        String oldLine = "P" +playerNum+" Name:" + selectedPlayer.getName();
        String newLine = "P" +playerNum+" Name:" + newName;
            fileContents = fileContents.replaceAll(oldLine, newLine);
                try {
                    writer = new FileWriter(".//res//playerData.txt");
                    writer.append(fileContents);
                    writer.flush();
                
                } catch (IOException e) {
                            
                     e.printStackTrace();
                }
        playerNum--;
        playerList[playerNum].setName(newName);
        readTextForButton(playerButton, playerNum, selectedPlayer);
    }
    public void checkIfDone(CardLayout cLayout, JPanel main, Row row1, Picture man){
        boolean lastCharDone = false;
        boolean hasDash = true;
        if(shownWord.length() != 0){
        if(!shownWord.substring(shownWord.length()-1).equals("-")||shownWord.substring(shownWord.length()-1).equals(" ")){
            lastCharDone = true;
        }
    }
        if(shownWord.length() != 0){
        for (int i =0;i<shownWord.length()-1;i++){
            if(shownWord.substring(i, i+1).equals("-")){
                hasDash = true;
                break;
            }else{
                hasDash = false;
            }
        }
    }
            if(lastCharDone && !hasDash){
                
                selectedPlayer.restartLives();
                String[] responses = {"Play Again","Select New Player", "Home"};
            int check1 = JOptionPane.showOptionDialog(null, "Victory", "You Win! Word: " + shownWord, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responses,0);
            shownWord ="";
            hiddenMessage = "";
            if(check1==0){
                cLayout.show(main, "3");
                man.changeImage(".//res//hang.png");
                this.createHiddenMsg(cLayout, main);
                this.showMessageOnScreen(row1, cLayout, main);
                this.setSelectedMan();
            }else if(check1 == 1){
                cLayout.show(main, "2");
                man.changeImage(".//res//hang.png");
            }else if(check1 == 2){
                cLayout.show(main, "1");
                man.changeImage(".//res//hang.png");
            }else{
                cLayout.show(main, "1");
                man.changeImage(".//res//hang.png");
            }
            
            }

        
        
    }
    public void checkAnswer(String answer, Row row1,CardLayout cLayout, JPanel main, Picture man){
       
        int length = answer.length();
       
        if(length> hiddenMessage.length()){
            selectedPlayer.reduceLife();
           
        }
        if(length !=0){
            boolean doesntHave = true;
            for(int i =0; i<hiddenMessage.length()-answer.length()+1; i += length){
                
            if(hiddenMessage.substring(i,i+length).equalsIgnoreCase(answer)){
               
                shownWord = shownWord.substring(0,i) + hiddenMessage.substring(i,i+length) + shownWord.substring(i+length);
                row1.changeTextRow1(shownWord);
                doesntHave = false;
                checkIfDone(cLayout,main,row1, man);
            } 
            }
            if(doesntHave){
                selectedPlayer.reduceLife();
            }
        }
        checkLife(cLayout, main, man);
        checkIfDone(cLayout,main,row1, man);
    }
    public void showMessageOnScreen(Row row1, CardLayout cLayout, JPanel main){
      
        if(shownWord.length()<=60){
           row1.changeTextRow1(shownWord);
           
        }else{
               JOptionPane.showMessageDialog(null,"Input a valid phrase (Word too long)","Error", JOptionPane.ERROR_MESSAGE);
             shownWord = "";
                 this.createHiddenMsg(cLayout, main);
            }
        
    }
    public String getShownWord(){
        return shownWord;
    }
    public Player getSelectedPlayer(){
        return selectedPlayer;
    }
    public void setSelectedPlayer(Player person){
        selectedPlayer = person;
    }
    public void createHiddenMsg(CardLayout cLayout, JPanel main){
        shownWord = "";
       String phrase = JOptionPane.showInputDialog("Enter the hidden phrase");
     
        Pattern special = Pattern.compile ("[!@#$%^&*()_+=|<>?{}\\[\\]~-]");
          Matcher hasSpecialCharacter;
          shownWord = "";
       int count =0;
       if (phrase == null){ //checks if they pressed canecl
        cLayout.show(main, "2");
        }else if(phrase.toString().equals("0")){
                cLayout.show(main, "2");
            }else if(phrase.length()==0 ||phrase.toString().equals("-1")|| phrase.equals("")){//checks if they entered nothing
                JOptionPane.showMessageDialog(null,"Enter a vaild phrase","Error", JOptionPane.ERROR_MESSAGE);
                createHiddenMsg(cLayout, main);
                    }else{//user imputs  something
                        if(phrase.length()>60 || phrase.length()==0){
                            JOptionPane.showMessageDialog(null,"Enter a vaild phrase","Error", JOptionPane.ERROR_MESSAGE);
                        createHiddenMsg(cLayout, main);
                        }else{
                            hiddenMessage= phrase;
                            for(int i =0; i<phrase.length()-1;i++){//couts if they have any special characters
                                hasSpecialCharacter = special.matcher(phrase.substring(i, i+1));
                                if(hasSpecialCharacter.find()==true){
                                    count++;
                            }
                    }
            //testing last character
            hasSpecialCharacter = special.matcher(phrase.substring(phrase.length()-1));
             if(hasSpecialCharacter.find()==true){
                    count++;
                }
            if(count == phrase.length() || phrase.length() == 0){//sees if its all speciail charactesr or note
                 JOptionPane.showMessageDialog(null,"Enter a vaild phrase","Error", JOptionPane.ERROR_MESSAGE);
                createHiddenMsg(cLayout, main);
            }else{//if valid it creates - to hide the real message
                hiddenMessage = phrase;
                 for(int i =0; i<phrase.length()-1;i++){
                hasSpecialCharacter = special.matcher(phrase.substring(i, i+1));
                if(phrase.substring(i,i+1).equals(" ")){
                     shownWord +=phrase.substring(i, i+1);
                }
                else if(hasSpecialCharacter.find()==false){
                    shownWord += "-";
                }else{
                    shownWord +=phrase.substring(i, i+1);
                }
            
                
            }
             //testing last character
                 hasSpecialCharacter = special.matcher(phrase.substring(phrase.length()-1));
                 if(phrase.substring(phrase.length()-1).equals(" ")){
                    shownWord +=phrase.substring(phrase.length()-1);
                }
                else if(hasSpecialCharacter.find()==false){
                     shownWord += "-";
                }else{
                    shownWord +=phrase.substring(phrase.length()-1);
                }
            }
        }
            
       }
     
    }

        public String getMessage(){
            return hiddenMessage;
        }
        public void setMessage(String word){
            hiddenMessage = word;
        }
        public Player[] getPlayerList(){
            return playerList;
        }

        public String getPlayerName(int i){
        return this.getPlayerList()[i].getName();
        }

        public void setPlayerName(int i, String name){
            this.getPlayerList()[i].setName(name);
        }
        public void readTextForButton(JButton btn, int indexNum,Player p1 ){
            indexNum++;
            int index =  0;
            int indexOfSpace = 0;
          
            
                
                index = fileContents.indexOf("P" +indexNum + " Name:") + 8;
                if(!fileContents.substring(index-8, index+("P" +indexNum + " Name:").length()-6).equals(("P" +indexNum + " Name:")  +System.lineSeparator())){
                    if(indexNum ==3){
             
               }
                    while(indexOfSpace ==0){
                     
                        for(int k = index; k< index + 10; k++){
                            
                            if(fileContents.substring(k,k+1).equals("\n")){
                               
                                if(indexOfSpace ==0){
                                    if(k-index==1){
                                        indexOfSpace = -1;
                                    }else{
                                        indexOfSpace = k;
                                    }
                                }
                            }
                        }
                    break;
                    }
                    

                
        }
        
        if(indexOfSpace != 0 && indexOfSpace != -1){//has name in file
           
            btn.setText(fileContents.substring(index, indexOfSpace-1));
            p1.setName(fileContents.substring(index, indexOfSpace-1));
            nameFromFile = fileContents.substring(index, indexOfSpace-1);
        
        }else{//no name in file
           
            indexNum--;
            btn.setText(playerList[indexNum].getName());
            nameFromFile = "";
        
            

        }
       
          }
          

        
        public void addPlayer(Player player, int indexNum){
            if(indexNum <=8){
            indexNum++;
              
                   
                    indexNum--;
                    playerList[indexNum]=player;
                    indexNum += 1;
                    if(nameFromFile.equals("")){
                    String oldLine = "P" +indexNum+" Name:";
                    String newLine = "P" +indexNum+" Name:" + player.getName();
                    fileContents = fileContents.replaceAll(oldLine, newLine);
                        try {
                            writer = new FileWriter(".//res//playerData.txt");
                            writer.append(fileContents);
                             writer.flush();
                
                        } catch (IOException e) {
                            
                            e.printStackTrace();
                        }
                    }
                        
                    
                
            }
        
            if(playerList.length < 8){
                playerList[playerList.length] = player;
            }
        }
        public void removePlayer(Player player){
            String playerName = player.getName();
            String checkName;
            for(int i =0; i< playerList.length; i++){
                checkName = playerList[i].getName();
                if (checkName.equals(playerName)){
                    playerList[i] = null;
                }
            }
        }
        public void addPlayerToButton(JButton playerBtn, Player newPlayer, CardLayout cardLayout, JPanel mainPanel, Row messageR1, int playerNum){
            String name = "";
            
            Boolean enteredName = false;
            if(playerBtn.getText().equals("(Create New Player)")){//seees if the button has a name already
               name = JOptionPane.showInputDialog("Insert Name");//if doesnt  it prompts user to make one
               enteredName  = true;
            }else{
                newPlayer = new Player(nameFromFile); 
              
                 this.setSelectedPlayer(newPlayer);
                
                 playerBtn.setText(this.getPlayerName(playerNum));//
                 this.addPlayer(newPlayer, playerNum);
                 this.readTextForButton(playerBtn, playerNum, newPlayer);
                 
             
                
                 characterOptions(cardLayout, messageR1, mainPanel, playerNum, playerBtn);
            }
            
           if (name==null  || name.toString().equals("-1")){
                 
            }else if(enteredName){
                
                newPlayer = new Player(name);
                
                 this.setSelectedPlayer(newPlayer);
                
                 playerBtn.setText(name);//
                 this.addPlayer(newPlayer, playerNum);
                 this.readTextForButton(playerBtn, playerNum, newPlayer);
                 
                 
            
                  
                
                  characterOptions(cardLayout, messageR1, mainPanel, playerNum, playerBtn);
                
            }
        }
    }

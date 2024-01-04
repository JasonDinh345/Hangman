public class Player {
    private String name;
    private int lives;
    
    public Player(){
        name = "(Create New Player)";
        lives = 7;
    }
    public Player(String person){
        name = person;
        lives = 7;
    }

    public String getName(){
        return name;
    }
    public void setName(String person){
        name =  person;
    }
    public int getLives(){
        return lives;
    }
    public void reduceLife(){
        if(lives > 0){
            lives--;
        }else{
            lives =0;
        }
    }
    public void restartLives(){
        lives =7;
    }
    
}

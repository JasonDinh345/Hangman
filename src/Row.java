import javax.swing.JLabel;

public class Row extends JLabel{
    public Row(String word){
        this.setText(word);
    }
    public void changeTextRow1(String text){
        this.setText(text);
        this.setBounds(960 - (this.getText().length())*16,1080/2 -70, 1920, 70);
    }
 
}

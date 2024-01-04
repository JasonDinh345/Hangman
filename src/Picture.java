import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Picture extends JLabel {
    private ImageIcon image;
    public void changeImage(String file){
        image = new ImageIcon(file);
        this.setIcon(image);
    }

    
}

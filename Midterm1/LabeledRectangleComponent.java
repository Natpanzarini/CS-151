import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

class LabeledRectangleComponent extends JPanel{
  private LabeledRectangle s;
  public LabeledRectangleComponent(LabeledRectangle s){
    this.s = s;
  }
  public void paintComponent(Graphics g)
  {
     Graphics2D g2 = (Graphics2D) g;
     s.draw(g2);
  }

}

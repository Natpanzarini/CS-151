import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class LabeledRectangle extends Rectangle{
  private int x;
  private int y;
  private int width;
  private int height;
  private Rectangle rectangle;

  public LabeledRectangle(int x, int y, int width, int height, String text){
    //Create rectangle object
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;

    str = text;
  }

  public String getLabel(){
    return str;
  }

  public void draw(Graphics g){
    Graphics2D g2 = (Graphics2D) g;
    rectangle = new Rectangle(x,y,width,height);

    g2.drawString(str,(x+(width/2)) - 10,(y+(height/2)));
    g2.draw(rectangle);
  }

  private String str;
}

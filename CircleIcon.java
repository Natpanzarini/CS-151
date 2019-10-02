import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
   An icon that has the shape of the planet Mars.
*/
public class CircleIcon implements Icon
{
   /**
      Constructs a Mars icon of a given size.
      @param aSize the size of the icon
   */
   private Color color = Color.RED;
   public CircleIcon(int aSize)
   {
      size = aSize;
   }

   public int getIconWidth()
   {
      return size;
   }

   public int getIconHeight()
   {
      return size;
   }

   public void setColor(Color color){
     this.color = color;
   }

   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D) g;
      Ellipse2D.Double planet = new Ellipse2D.Double(x, y,
            size, size);
      g2.setColor(color);
      g2.fill(planet);
   }

   private int size;
}

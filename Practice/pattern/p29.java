//CREATE AN APPLET THAT DRAW A POLYGON USING AN ARRAY
package pattern;

/*<applet code="p29" height=300 width=300>
</applet>*/
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class p29 extends Applet
   {
   public void paint(Graphics g)
      {
      int x[]={50,220,50,220,50};
      int y[]={50,50,220,220,50};
      setBackground(new Color(255,255,255));
      int number=4;
      g.fillPolygon(x,y,number);
      }
   }


package Vista;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JLabel;


public class ImagenAdaptable extends JLabel {
    
    
    String path = "";
    BufferedImage image;
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(image!=null){
            Graphics2D g2 = (Graphics2D)g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
            
            g2.drawImage(image,0,0,getWidth(),getHeight(),null);
            g2.dispose();
            
        } 
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        cargarImage();
    }
    
    private void cargarImage(){
    
        URL abopath = getClass().getResource(path);
        if(abopath != null){
            try {
                image = ImageIO.read(abopath);
            } catch (IOException ex) {
                System.getLogger(ImagenAdaptable.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            repaint();
        }
    }
        
}

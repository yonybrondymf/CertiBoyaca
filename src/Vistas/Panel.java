package Vistas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Panel extends JPanel{
     private JFrame prueba;
    
    /** Creates new form PnlFondo */
    public Panel() {
       
        this.setSize(1600, 1600);
    }
    
    @Override
    public void paintComponent(Graphics g){
        System.out.println("paintComponent");
        Dimension tamanio = getSize();        
        ImageIcon imagenFondo = new ImageIcon(getClass().
                getResource("/imagenes/1511.jpeg"));
        g.drawImage(imagenFondo.getImage(), 0, 0, 
                tamanio.width, tamanio.height, null);
        setOpaque(false);
        
        super.paintComponent(g);
    }
    
}



//import java.awt.Graphics;
//import java.awt.Image;
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;
//
//
//public class Panel extends JPanel{
//    private Image fondo=null;
//    @Override
//    protected void paintComponent(Graphics g){
//        
////        super.paintComponent(g);
//        g.drawImage(fondo,0,0,getWidth(),getHeight(),null);
//        setOpaque(false);
//        super.paintComponent(g);
//        
//    }
//    public void setImage(String image){
//        if (image!=null) {
//            fondo=new ImageIcon(getClass().getResource(image)).getImage();
//            setOpaque(false);
//        }
//    }
//    
//}


 
//import java.awt.Graphics;
//import java.awt.Image;
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;
// 
//public class Panel extends JPanel {
// 
//    private Image imagen;
// 
//    public Panel() {
//    }
// 
//    public Panel(String nombreImagen) {
//        if (nombreImagen != null) {
//            imagen = new ImageIcon(
//                           getClass().getResource(nombreImagen)
//                           ).getImage();
//        }
//    }
// 
//    public Panel(Image imagenInicial) {
//        if (imagenInicial != null) {
//            imagen = imagenInicial;
//        }
//    }
// 
//    public void setImagen(String nombreImagen) {
//        if (nombreImagen != null) {
//            imagen = new ImageIcon(
//                   getClass().getResource(nombreImagen)
//                   ).getImage();
//        } else {
//            imagen = null;
//        }
// 
//        repaint();
//    }
// 
//    public void setImagen(Image nuevaImagen) {
//        imagen = nuevaImagen;
// 
//        repaint();
//    }
// 
//    @Override
//    public void paint(Graphics g) {
//        if (imagen != null) {
//            g.drawImage(imagen, 0, 0, getWidth(), getHeight(),
//                              this);
// 
//            setOpaque(false);
//        } else {
//            setOpaque(true);
//        }
// 
//        super.paint(g);
//    }
//}




package Ventanas;

import Arbol.ArbolBB;
import Arbol.NodoBB;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Lienzo extends Canvas{
   
    public void drawArbol(Graphics g,ArbolBB arbol){
       
        g.clearRect(0, 0, 1000, 1000);
        ArrayList<NodoBB> nodos=arbol.getPreordenNodos();
        for(NodoBB dato:nodos){
            g.setColor(Color.black);
            g.fillOval(dato.x-10, dato.y-10, 25, 25);
            if(dato.getHijo_der()!=null)
                g.drawLine(dato.x, dato.y,dato.getHijo_der().x, dato.getHijo_der().y);
            if(dato.getHijo_izq()!=null)
                g.drawLine(dato.x, dato.y,dato.getHijo_izq().x, dato.getHijo_izq().y);
            g.setColor(Color.white);
            g.drawString(dato.valor+"", dato.x-5,dato.y+5);
        }
        
        
    }
}

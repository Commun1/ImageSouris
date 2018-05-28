package DessinerDansFenetre;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author grosjean
 */
public class Fen extends Frame
{

    private final int MAX = 5;   // nombre maximum de traits 
    private Point starts[] = new Point[MAX]; // points de départ 
    private Point ends[] = new Point[MAX]; // points d'arrivée 
    private Point anchor;    // point de départ de la ligne courante
    private Point currentPoint;   // point d'arrivée de la ligne courante 
    private int currline = 0;    // nombre de ligne tracées  

    public Fen()
    {

        new EcouteSouris(this); // création écouteur qui va gérer les actions de la souris dans la fenetre
        new EcouteFenetre(this);  //création écouteur qui va gérer les actions de la fenetre dans la fenetre
        setBounds(300, 300, 300, 300);// def position et taille fenetre dans le constructeur
        setVisible(true);
    }

    void debuterTrait(Point p) //point de depart de la ligne
    {
        if (currline < MAX) 
        {   
      anchor = p; 
        }   
        else   {    System.out.println("trop de lignes");   } 
    }
    
   public void arreterTrait(Point p) //point d' arrivée de la ligne
   {
        if (currline < MAX) 
        {   
             ends[currline] = p;
            starts[currline] = anchor; 
             currline++; 
             currentPoint = null;
             anchor = null;  
             repaint();
        }
        
   }
   public void voirTrait(Point p) //quand on glisee on voit le trait
   {
       if (currline < MAX) 
       {    
           currentPoint = p; 
           repaint();  
       }   
   }
   
   
    @Override
    public void paint(Graphics g)  // colore le trait et change la couleur entre le début et la fin
    {   // dessin des lignes validées
        g.setColor(Color.green); //permet le changement de couleur du trait quand il est fini
        for (int i = 0; i < currline; i++)
        {
            g.drawLine(starts[i].x, starts[i].y, ends[i].x, ends[i].y);

        }
        // dessin de la ligne courante si elle existe 
        g.setColor(Color.red);
        if (currentPoint != null)
        {
            g.drawLine(anchor.x, anchor.y, currentPoint.x, currentPoint.y);
        }
        titre(); // on appelle dans paint pour qu 'il s' affiche dans la fenétre
        messageEncore();
    }
     public void effacerTout(){
         
        currline = 0; //  fait le nombre de lignes = 0
        repaint();
     }
     public void effacerDernierTrait()
     {
         if( currline > 0)
         {
           currline = currline -1;// efface la derniére ligne
           repaint();
         }      
     }
     
     public void titre()
     {
         
         if(MAX == currline)   //quand le nombre maximum de lignes est atteint marque le message
         {
             setTitle("le maximum de traits est atteint");
         }
     }
     public void messageEncore()
     {
         if (currline < MAX)
             setTitle(" vous pouvez  dessiner");
     }
     
     
}

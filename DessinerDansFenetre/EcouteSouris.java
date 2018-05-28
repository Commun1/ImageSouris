/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DessinerDansFenetre;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author grosjean
 */
public class EcouteSouris implements MouseListener, MouseMotionListener
{

      
    private int currline = 0;    // nombre de ligne  
    private Fen fen;

    public EcouteSouris(Fen s)

    {
        fen = s;
        fen.addMouseListener(this);
        fen.addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount()== 2)
        {
            fen.effacerTout();
            //System.out.println("coucou click gauche");
        } else if (SwingUtilities.isRightMouseButton(e))
        {
           fen.effacerDernierTrait();
            // System.out.println("coucou click droit");
        }

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (SwingUtilities.isLeftMouseButton(e))
        {
            fen.debuterTrait(e.getPoint());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
       if (SwingUtilities.isLeftMouseButton(e))
        {
            fen.arreterTrait(e.getPoint());
        }
        //System.out.println("coucou relache");
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        System.out.println(" coucou dedans");
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        System.out.println(" coucou dehors");
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        if (SwingUtilities.isLeftMouseButton(e))
        {
            fen.voirTrait(e.getPoint());
        }
        //System.out.println("coucou glisse")
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        System.out.println("coucou bouge");
    }

   

    

}

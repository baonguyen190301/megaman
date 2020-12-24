/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */

public class GamePanel extends JPanel implements Runnable,KeyListener {
    private Thread thread;
    private boolean isRunning;
    
   @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(0,0, GameFrame.SCREEN_WIDTH,GameFrame.SCREEN_HEIGH);
        
    }
    
    public void startGame()
    {
        if(thread == null)
        {
            isRunning = true;
            thread = new Thread(this);
            thread.start();
        }
    }
    @Override
    public void run() {
        long FPS =80;
        long period = 1000*1000000/FPS; // 1s = 1000000000 nano s;
        long beginTime;
        long sleepTime;
        int a = 1;
        // uppdate game and render;
        beginTime = System.nanoTime();
        while(isRunning)
        {
            //System.out.println("a="+(a++));
            
            long deltaTime = System.nanoTime() - beginTime;
            sleepTime = period - deltaTime;
            try {
                if(sleepTime>0){
                    Thread.sleep(sleepTime/1000000);
                }else{
                    Thread.sleep(period/2000000);
                }
            } catch (InterruptedException ex) {
                beginTime = System.nanoTime();
            }
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//      System.out.println("key press ");
//      if(e.getKeyCode() == KeyEvent.VK_A){
//          System.out.println("you press A");
        switch(e.getKeyCode()){
          case KeyEvent.VK_UP:
              System.out.println("you press up");
              break;
          case KeyEvent.VK_DOWN:
              System.out.println("you press down");
              break;
          case KeyEvent.VK_RIGHT:
              System.out.println("you press right");
              break;
          case KeyEvent.VK_LEFT:
              System.out.println("you press left");
              break;
          case KeyEvent.VK_ENTER:
              System.out.println("you press enter");
              break;
          case KeyEvent.VK_SPACE:
              System.out.println("you press space");
              break;
      }
    }
    

    @Override
    public void keyReleased(KeyEvent e) {
//      System.out.println("key releasee");
    switch(e.getKeyCode()){
          case KeyEvent.VK_UP:
              System.out.println("you released up");
              break;
          case KeyEvent.VK_DOWN:
              System.out.println("you released down");
              break;
          case KeyEvent.VK_RIGHT:
              System.out.println("you released right");
              break;
          case KeyEvent.VK_LEFT:
              System.out.println("you released left");
              break;
          case KeyEvent.VK_ENTER:
              System.out.println("you releaesed enter");
              break;
          case KeyEvent.VK_SPACE:
              System.out.println("you released space");
              break;
      }
    }
    
}

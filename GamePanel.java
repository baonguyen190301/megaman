/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */

public class GamePanel extends JPanel implements Runnable {
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
            System.out.println("a="+(a++));
            
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
    
}

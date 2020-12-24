/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class GameFrame extends JFrame {
    public static final int SCREEN_WIDTH = 1000;
    public static final int SCREEN_HEIGH = 600;
    GamePanel gamePanel;
    public GameFrame()
    {
        Toolkit toolkit = this.getToolkit();
        // gget size of scrence's computer
        Dimension dimension = toolkit.getScreenSize();// dimension contains heigh and width
        this.setBounds((dimension.width - SCREEN_WIDTH)/2,(dimension.height-SCREEN_HEIGH)/2,SCREEN_WIDTH,SCREEN_HEIGH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePanel = new GamePanel();
        add(gamePanel);
        this.addKeyListener(gamePanel);
    }
    public void starGame()
    {
        gamePanel.startGame();
    }
    public static void main(String[] args)
    {
        GameFrame gameFrame = new GameFrame();
        gameFrame.setVisible(true);
        gameFrame.starGame();
    }
}

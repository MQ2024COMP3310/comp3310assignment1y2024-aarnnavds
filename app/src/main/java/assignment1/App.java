package assignment1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.time.Duration;
import java.time.Instant;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class App extends JFrame {

    class CheckersGame extends JPanel implements KeyListener{
        Board board;
        String strrr = "";
        boolean stageBuilt = false;

        public CheckersGame(){
            setPreferredSize(new Dimension(730, 900));
            this.addKeyListener(this);
            board = new Board();
            stageBuilt = true;
            this.setFocusable(true);
            this.requestFocus();
        }

        @Override
        public void paint(Graphics g) {
          if (stageBuilt && isVisible()) {
            board.paint(g);
          }
        }

        @Override
        public void keyPressed (KeyEvent e) {}    
        
        @Override
        public void keyReleased (KeyEvent e) {
            board.keyPressed(e);
        }    

        @Override
        public void keyTyped (KeyEvent e) {}    

    }

    public static void main(String[] args) throws Exception {
        App window = new App();
        window.run();
    }

    App() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CheckersGame canvas = new CheckersGame();
        this.setContentPane(canvas);
        this.pack(); 
        this.setVisible(true);
    }

    public void run() {
        while (true) {
            Instant startTime = Instant.now();
            this.repaint();
            Instant endTime = Instant.now();
            long howLong = Duration.between(startTime, endTime).toMillis();
            try {
                Thread.sleep(20L - howLong);
            } catch (InterruptedException e) {
                System.out.println("thread was interrupted, but who cares?");
            } catch (IllegalArgumentException e) {
                System.out.println("application can't keep up with framerate");
            }
        }
    }

    public String getGreeting() {
        return "";
    }

    public String getGreeting3() {
        return "";
    }




}

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Window extends JFrame implements Runnable {

    Graphics2D g2;
    KL keyListener = new KL();

    //set up the window
    public Window() {
        this.setSize(Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        g2 = (Graphics2D) this.getGraphics();
    }

    public void update(double dt){
        g2.setColor(Color.BLACK);
        g2.fillRect(0,0,Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);

        if(keyListener.isKeyPressed(KeyEvent.VK_UP)){
            System.out.println("UP");
        } else if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)){
            System.out.println("DOWN");

        }
    }

    public void run() {
        double lastFrameTime = 0.0;
        while (true) {
        double time = Time.getTime();
        double deltaTime = time - lastFrameTime;
        lastFrameTime = time;

        update(deltaTime);


        //limit framerate
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        }
    }
}

package waiting;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import utils.ImageUtils;


public class WaitNotify extends JFrame implements Runnable {

	private static final long serialVersionUID = 876489310788597834L;

	// resource: flag
    volatile boolean suspended = false;

    Container conn = this.getContentPane();
    static Thread thread;

    private static final String TITLE = "Ex04 - Image Random";
    private final String path = "/images/";
    private JLabel picLabel;
    private JButton btStop;
    private JButton btResume;
    private Color highlightButton = Color.ORANGE;
    String[] imagesName = {"1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg", "8.jpg", "9.jpg", "10.jpg", "11.jpg", "12.jpg", "13.jpg", "14.jpg"};
    public Random rd = new Random();
    int W = 500;
    int H = 500;

    public WaitNotify() {
        this.setTitle(TITLE);
        this.setSize(W, H);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(ImageUtils.createImage(ImageUtils.FLOWER_64PX, WaitNotify.class));
        conn.setLayout(null);
        initComponents();
        initEvent();
    }

    void suspend() {
        suspended = true;
    }

    synchronized void resume() {
        suspended = false;
        notify();
    }

    private void initEvent() {
        btStopEvent();
        btResumeEvent();
    }

    private void btStopEvent() {
        Color defaultColor = btStop.getBackground();
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                suspend();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btStop.setBackground(highlightButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btStop.setBackground(defaultColor);
            }
        });
    }

    private void btResumeEvent() {
        btResume.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                resume();
            }
        });
    }

    private void initComponents() {
        picLabel = new JLabel();
        int preferredWidth = 150;
        int preferredHeigth = 250;
        picLabel.setBounds((W - preferredWidth) / 2, 0, preferredWidth, preferredHeigth);
        Image image = new ImageIcon(getClass().getResource(ImageUtils.DEF_GHOST)).getImage();
        image = image.getScaledInstance(preferredWidth, preferredHeigth, Image.SCALE_SMOOTH);
        picLabel.setIcon(new ImageIcon(image));
        conn.add(picLabel);

        Font font = new Font("Arial", Font.BOLD, 20);
        btStop = new JButton("STOP");
        btStop.setFont(font);
        btStop.setFocusPainted(false);
        btStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Dimension p2 = btStop.getPreferredSize();
        btStop.setBounds(120, 350, (int) p2.getWidth(), (int) p2.getHeight());
        conn.add(btStop);

        btResume = new JButton("Resume");
        btResume.setFont(font);
        btResume.setFocusPainted(false);
        btResume.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Dimension p3 = btResume.getPreferredSize();
        btResume.setBounds(250, 350, (int) p3.getWidth(), (int) p3.getHeight());
        conn.add(btResume);

    }

    public static void main(String[] args) {
        // Runnable
        WaitNotify ex04 = new WaitNotify();
        ex04.setVisible(true);

        thread = new Thread(ex04);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("suspend: " + suspended);
            int numRandom = rd.nextInt(imagesName.length);
            Image image = new ImageIcon(getClass().getResource(path + imagesName[numRandom])).getImage();
            image = image.getScaledInstance(190, 200, Image.SCALE_SMOOTH);
            picLabel.setIcon(new ImageIcon(image));
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {

            }

            synchronized (this) {
                while (suspended) {
                    try {
                        System.out.println("suspend wait: " + suspended);
                        wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(WaitNotify.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }
    }
}

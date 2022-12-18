import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.TextField;
import java.awt.event.KeyEvent;



public class guess extends JFrame {
    int f;
    int tries;

    TextField b1 = new TextField("");
    JLabel b2 = new JLabel("check");
    // b2.setPreferredSize(new Dimension(30, 30));
    JLabel l1 = new JLabel("tries");
    JLabel l2 = new JLabel("  ?  ");

    JLabel l3 = new JLabel("answer");

    JLabel l4 = new JLabel("");

    // l3.setPreferredSize(30, 30);

    public guess(int f)
    {
        super("угадайка");
        this.f = f;
        setLayout(new BorderLayout());
        l1.setBackground(Color.green);
        l2.setBackground(Color.red);
        l3.setBackground(Color.white);
        b1.setBackground(Color.blue);
        b2.setBackground(Color.yellow);
        l2.setBounds(10,10,10,30);
        l4.setVisible(false);

        // b1.setToolTipText("Click this button.");
        b2.setToolTipText("центр");
        l3.setToolTipText("юг");
        l2.setToolTipText("восток");
        l1.setToolTipText("запад");

        add(l1, BorderLayout.WEST);
        add(b1, BorderLayout.NORTH);
        add(b2, BorderLayout.CENTER);
        add(l2, BorderLayout.EAST);
        add(l3, BorderLayout.SOUTH);



        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setVerticalAlignment(SwingConstants.CENTER);


        l2.setHorizontalAlignment(SwingConstants.CENTER);
        l2.setVerticalAlignment(SwingConstants.CENTER);


        b2.setHorizontalAlignment(SwingConstants.CENTER);
        b2.setVerticalAlignment(SwingConstants.CENTER);


        l3.setHorizontalAlignment(SwingConstants.CENTER);
        l3.setVerticalAlignment(SwingConstants.CENTER);


        l4.setHorizontalAlignment(SwingConstants.CENTER);
        l4.setVerticalAlignment(SwingConstants.CENTER);

        // panel[8].add(l3);

        setLocationRelativeTo (null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(255, 39, 30));
        setSize(300, 300);
        setVisible(true);

        // b1.addTextListener(new MyTextListener("Text Field"));
        b2.addMouseListener(new MouseAdapter() {
                                public void mouseEntered(MouseEvent mEvt) {
                                    l4.setVisible(true);
                                    l4.setText("добро пожаловать в ЦАО");
                                    System.out.println("Hello World!");
                                }
                            });




        b1.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    tries++;
                    l1.setText(String.valueOf(tries));
                    // String tc = (String) e.getSource();
                    int i = Integer.parseInt(b1.getText());
                    // System.out.println("Typed value in TextComponent " + tc.getText());
                    winnerIs(i, tries);
                    b1.setText("");
                    // tries--;
                }
            }
        });


    }

    /* class MyTextListener implements TextListener {
        String preface;
        int tries=0;

        public MyTextListener(String source) {
            preface = source; 
        }

         public void textValueChanged(TextEvent e) {
            if (b1.getText()!="") {
                tries++;
                l1.setText(String.valueOf(tries));
                // String tc = (String) e.getSource();
                int i = Integer.parseInt(b1.getText());
                // System.out.println("Typed value in TextComponent " + tc.getText());
                winnerIs(i, tries);
                b1.setText("");
                tries--;
            }
        }
    } */

    public void winnerIs(int tc, int tries)
    {
        if (tries >20)
        {
               l3.setText("вы продули, ответ " + f);
            l2.setText(String.valueOf(f));
        }

        if (tc > f) {
            b2.setText("больше числа");
        } else if (tc < f) {
            b2.setText("меньше числа");
        } else {
            b2.setText("ПРАВИЛЬНО");
            l3.setText("вы выиграли, ответ " + f);
            l2.setText(String.valueOf(f));
        }
    }

    // int f;

    public static void main (String[] args)
    {
        // f = 10;
        new guess(10).setVisible(true);

    }

}

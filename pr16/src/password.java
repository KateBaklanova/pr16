import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import static java.awt.Color.GREEN;
import static java.awt.Color.RED;

public class password extends JFrame  {



    String name="fmdfmdsm";
    String pass="mcdmf";
    String serv="ewklwdfcnj";

        JLabel l1 = new JLabel("Service");
        JLabel l2 = new JLabel("USer name");

        JLabel l3 = new JLabel("Password");

        JPasswordField r1 = new JPasswordField();

        JPasswordField r2 = new JPasswordField();

        JPasswordField r3 = new JPasswordField();

        // l3.setPreferredSize(30, 30);

        public password() {
            super("угадайка");
            // this.f = f;
            setBackground(new Color(200, 39, 30));
            setSize(300, 300);
            setPreferredSize( new Dimension(300, 300));
            setVisible(true);

            setLayout(new GridLayout(3, 2));

            JPanel panel = new JPanel();
            panel.setBackground(Color.orange);
            GridLayout layout = new GridLayout(3, 2);
            // layout.setHgap(40);
            panel.setLayout(layout);
            panel.add(l1);
            panel.add(r1);
            panel.add(l3);
            panel.add(r2);
            panel.add(l2);
            panel.add(r3);

            add(panel);

            char[] password = r1.getPassword();



            r1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    JPasswordField field = (JPasswordField) event.getSource();
                    char[] password = field.getPassword();

                    if (password.length < 5) {
                        System.out.println("Password must contain at least 5 characters!");
                        r1.setBackground(RED);
                    }
                    else if (isPasswordCorrect(password)) {
                        r1.setBackground(GREEN);
                    }
                    else
                    {
                        r1.setBackground(RED);
                    }

                    r1.setText("");
                }
            });

            r2.addActionListener(new ActionListener() {
                                     @Override
                                     public void actionPerformed(ActionEvent event) {
                                         JPasswordField field = (JPasswordField) event.getSource();
                                         char[] password = field.getPassword();

                                         if (password.length < 5) {
                                             System.out.println("Password must contain at least 5 characters!");
                                             r2.setBackground(RED);
                                         } else if (isPasswordCorrect(password)) {
                                             r2.setBackground(GREEN);
                                         } else {
                                             r2.setBackground(RED);
                                         }

                                         r2.setText("");
                                     }
                                 });

            r3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    JPasswordField field = (JPasswordField) event.getSource();
                    char[] password = field.getPassword();

                    if (password.length < 5) {
                        System.out.println("Password must contain at least 5 characters!");
                        r3.setBackground(RED);
                    }
                    else if (isPasswordCorrect(password)) {
                        r3.setBackground(GREEN);
                    }
                    else
                    {
                        r3.setBackground(RED);
                    }
                    r3.setText("");
                }});




        }

        boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;
        char[] correctPassword = { 'm', 'u', 'm', 'u', 'm', 'u', 'm' };

        if (input.length != correctPassword.length) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals (input, correctPassword);
        }

        //Zero out the password.
        Arrays.fill(correctPassword,'0');

        return isCorrect;
    }

        public static void main (String[] args)
        {
            // f = 10;
            new password().setVisible(true);

        }

    }


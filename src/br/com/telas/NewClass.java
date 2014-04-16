/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.telas;

/**
 *
 * @author Produção
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class NewClass extends JPanel {

    JProgressBar pbar;

    static final int MY_MINIMUM = 0;

    static final int MY_MAXIMUM = 100;

    public NewClass() {
        pbar = new JProgressBar();
        pbar.setMinimum(MY_MINIMUM);
        pbar.setMaximum(MY_MAXIMUM);
        pbar.setStringPainted(true);
        add(pbar);
    }

    public void atualizaBarra(int valor) {
        pbar.setValue(valor);
    }

    public static void main(String args[]) {

        final NewClass barra = new NewClass();

        JFrame frame = new JFrame("Progress Bar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(barra);

        frame.pack();
        frame.setVisible(true);
        frame.setLocation(1, 500); // aonde vai aparecer na tela 

        for (int i = MY_MINIMUM; i <= MY_MAXIMUM; i++) {
            final int percent = i;
            try {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        barra.atualizaBarra(percent);
                    }
                });
                Thread.sleep(5);
            } catch (InterruptedException e) {

            }
        }
    }
}

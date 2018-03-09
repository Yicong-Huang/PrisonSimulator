package menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JButton implements ActionListener {

    Menu(String text) {

        super(text, null);
        addActionListener(this);
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(this.getText() + " clicked!!! ");
    }
}

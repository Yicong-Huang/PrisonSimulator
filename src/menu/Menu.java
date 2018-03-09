package menu;


import base.PrisonSimulation;
import base.State;
import base.start;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Menu extends JButton implements ActionListener {

    Menu(String text) {

        super(text, null);
        addActionListener(this);
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(this.getText() + " clicked!!! ");
        if (e.getActionCommand().equals("Object")) {
            PrisonSimulation.currentState = State.BUILD_OBJECT;


        } else if (e.getActionCommand().equals("Selector")) {
            PrisonSimulation.currentState = State.BUILD_WALL;
        } else if (e.getActionCommand().equals("Reload Simulation")) {
            start.prisonSimulation.dispatchEvent(new WindowEvent(start.prisonSimulation, WindowEvent.WINDOW_CLOSING));


            start.main(new String[]{});
        }
    }
}

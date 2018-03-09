package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuBar extends JPanel implements MouseListener {

//    private ArrayList<Menu> menus;


    public MenuBar() {

        setLayout(new FlowLayout());
        add(new Menu("Selector"));
        add(new Menu("Runner"));
        setBounds(0, 400, 400, 100);
        setVisible(true);
        addMouseListener(this);


    }


    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("in MenuBar Click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("in MenuBar Press");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        System.out.println("in MenuBar Release");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        System.out.println("in MenuBar Enter");
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        System.out.println("in MenuBar Exit");
    }


}

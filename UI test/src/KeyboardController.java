/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jawesome
 */
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.text.JTextComponent;


public class KeyboardController implements KeyListener {

    private HotelReservationUI ui;

    public KeyboardController(HotelReservationUI ui) {
        this.ui = ui;
    }



    public void attach() {

        // 1. Add this controller as a KeyListener to the UI.
        ui.addKeyListener(this);

        // 2. Make sure the JFrame can receive keyboard focus.
        ui.setFocusable(true);

        // Also attach to every component inside the frame, so the
        // keys keep working after clicking a button, field, or
        // dropdown (those steal focus away from the frame itself).
        addListenerToChildren(ui.getContentPane());
    }

    private void addListenerToChildren(Container container) {

        for (Component child : container.getComponents()) {

            child.addKeyListener(this);

            if (child instanceof Container) {
                addListenerToChildren((Container) child);
            }
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        // 1. ESCAPE:
        //    If the key is ESC, exit the application.
        if (keyCode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        // 2. X:
        //    If the key is X, trigger the same cancellation
        //    process as pressing the CANCEL button.
        //    Reuses ReservationController instead of creating
        //    another cancellation system.
        //    Ignored while typing in a text field, so a guest
        //    name like "Alex" does not trigger a cancellation.
        else if (keyCode == KeyEvent.VK_X
                && !(e.getSource() instanceof JTextComponent)) {

            ui.getReservationController().cancelReservation();
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

        // blank
    }


    @Override
    public void keyTyped(KeyEvent e) {

        // blank
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jawesome
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController implements KeyListener {

    private HotelReservationUI ui;

    public KeyboardController(HotelReservationUI ui) {
        this.ui = ui;
    }

  

    public void attach() {

        // YOUR CODE HERE
        /*
         * Instructions:
         *
         * 1. Add this controller as a KeyListener to the UI.
         *
         *
         * 2. Make sure the JFrame can receive keyboard focus.
         *
         *
         */
    }


    @Override
    public void keyPressed(KeyEvent e) {

        // YOUR CODE HERE
        /*
         * Instructions:
         *
         * Check which key was pressed.
         *
         * 1. ESCAPE:
         *
         *    If the key is ESC:
         *       Exit the application.
         *
         *    Hint:
         *    e.getKeyCode()
         *    KeyEvent.VK_ESCAPE
         *
         *
         * 2. X:
         *
         *    If the key is X:
         *       Trigger the same cancellation process
         *       as pressing the CANCEL button.
         
         *    ui.getReservationController()
         *       .cancelReservation();
         *
         *
         * Do not create another cancellation system here.
         * Reuse ReservationController.
         */
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jawesome
 */

 import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelTimer {

    private HotelReservationUI ui;

    private Timer timer;

    private int countdown = 3;

    public CancelTimer(HotelReservationUI ui) {
        this.ui = ui;
    }

   

    public void startCountdown() {

        // YOUR CODE HERE
        /*
         * Instructions:
         *
         * 1. Stop any previous timer.
         *
         *    stopTimer();
         *
         * 2. Reset countdown to 3.
         *
         * 3. Change the button text:
         *
         *    ui.setCancelButtonText(
         *        "UNDO CANCELLATION"
         *    );
         *
         * 4. Display:
         *
         *    "Cancellation Timer: 3"
         *
         * 5. Create a Swing Timer that runs every
         *    1000 milliseconds.
         *
         *    Hint:
         *
         *    timer = new Timer(
         *        1000,
         *        new ActionListener() {
         *
         *            @Override
         *            public void actionPerformed(
         *                ActionEvent e
         *            ) {
         *
         *                timerTick();
         *            }
         *        }
         *    );
         *
         * 6. Start the timer.
         */
    }

    

    public void stopTimer() {

        // YOUR CODE HERE
        /*
         * Instructions:
         *
         * 1. Check if timer is not null.
         *
         * 2. Check if timer is running.
         *
         * 3. If running, stop it.
         */
    }

    
    public boolean isRunning() {

        // YOUR CODE HERE
        /*
         * Instructions:
         *
         * Return true if the timer exists and is running.
         *
         *
         * return timer != null && timer.isRunning();
         */

        return false;
    }

  

    public void undoCancellation() {

        // YOUR CODE HERE
        /*
         * Instructions:
         *
         * This method is called when the user clicks
         * "UNDO CANCELLATION".
         *
         * 1. Stop the timer.
         *
         * 2. Reset countdown to 3.
         *
         * 3. Change the button back to:
         *
         *    "CANCEL"
         *
         * 4. Change the timer label back to:
         *
         *    "Cancellation Timer: Not started"
         *
         * 5. The reservation MUST remain active.
         *
         * Do NOT call:
         *
         * reservationCancelled()
         */
    }

    
    public void reset() {

        // YOUR CODE HERE
        /*
         * Instructions:
         *
         * This is used when CLEAR is pressed.
         *
         * 1. Stop the timer.
         * 2. Reset countdown to 3.
         * 3. Set button text back to:
         *
         *    "CANCEL"
         *
         * 4. Set timer label back to:
         *
         *    "Cancellation Timer: Not started"
         */
    }

    // =========================================================
    // TIMER TICK
    // =========================================================

    private void timerTick() {

        // YOUR CODE HERE
        /*
         * Instructions:
         *
         * This method runs every 1 second.
         *
         * 1. Decrease countdown:
         *
         *    countdown--;
         *
         * 2. Update the timer label.
         *
         * 3. Check if countdown has reached 0.
         *
         *
         * If countdown > 0:
         *
         * Keep the timer running.
         *
         *
         * If countdown == 0:
         *
         *      1. Stop the timer.
         *
         *      2. Reset the button:
         *
         *         ui.setCancelButtonText("CANCEL");
         *
         *      3. Reset the timer display:
         *
         *         "Cancellation Timer: Not started"
         *
         *      4. Tell ReservationController that
         *         cancellation is COMPLETE:
         *
         *         ui.getReservationController()
         *             .reservationCancelled();
         *
         *
         * This is the ONLY point where the reservation
         * should actually become cancelled.
         */
    }
}
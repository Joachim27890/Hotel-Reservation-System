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
    private int countdown = 10;

    public CancelTimer(HotelReservationUI ui) {
        this.ui = ui;
    }

   

    public void startCountdown() {

        // YOUR CODE HERE

        /*
         * The cancellation grace period is 10 seconds.
         *
         * 1. Stop any existing timer first.
         *
         * 2. Reset countdown to 10.
         *
         * 3. Change the CANCEL button text to:
         *
         *      "UNDO CANCELLATION"
         *
         * 4. Change the timer label to:
         *
         *      "Cancellation Timer: 10"
         *
         * 5. Create a Swing Timer that runs every
         *    1000 milliseconds (1 second).
         *
         * 6. The Timer's ActionListener should call:
         *
         *      timerTick();
         *
         * 7. Start the timer.
         */
    }



    public void stopTimer() {

        // YOUR CODE HERE

        /*
         * If timer is not null AND the timer is running,
         * stop it.
         */
    }

   
    public boolean isRunning() {

        // YOUR CODE HERE

        /*
         * Return true if:
         *
         *      timer != null
         *      AND
         *      timer.isRunning()
         *
         * Otherwise return false.
         */

        return false;
    }

    
    public void undoCancellation() {

        // YOUR CODE HERE

        /*
         * This method is called when the user clicks
         * "UNDO CANCELLATION".
         *
         * 1. Stop the timer.
         *
         * 2. Reset countdown back to 10.
         *
         * 3. Change the button text back to:
         *
         *      "CANCEL"
         *
         * 4. Change the timer label back to:
         *
         *      "Cancellation Timer: Not started"
         *
         * IMPORTANT:
         *
         * Do NOT cancel the reservation here.
         *
         * The reservation should remain active.
         */
    }


    public void reset() {

        // YOUR CODE HERE

        /*
         * This method is used when CLEAR is pressed.
         *
         * 1. Stop the timer.
         *
         * 2. Reset countdown back to 10.
         *
         * 3. Change the button text back to:
         *
         *      "CANCEL"
         *
         * 4. Change the timer label back to:
         *
         *      "Cancellation Timer: Not started"
         */
    }

    
    private void timerTick() {

        // YOUR CODE HERE

        /*
         * This method runs every 1 second.
         *
         * 1. Decrease countdown by 1.
         *
         * 2. Update the timer label.
         *
         * Example:
         *
         *      Cancellation Timer: 9
         *      Cancellation Timer: 8
         *      Cancellation Timer: 7
         *      ...
         *
         * 3. When countdown reaches 0:
         *
         *      a. Stop the timer.
         *
         *      b. Change the button text back to:
         *
         *             "CANCEL"
         *
         *      c. Change the timer label back to:
         *
         *             "Cancellation Timer: Not started"
         *
         *      d. Tell ReservationController that the
         *         cancellation is now FINAL by calling:
         *
         *             ui.getReservationController()
         *                 .reservationCancelled();
         *
         * IMPORTANT:
         *
         * This method is the ONLY place where the timer
         * confirms that the cancellation period has ended.
         *
         * Do NOT directly change reservationMade here.
         */
    }
}
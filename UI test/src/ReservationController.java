/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jawesome
 */
import javax.swing.JOptionPane;

public class ReservationController {

    private HotelReservationUI ui;

    private boolean reservationMade = false;

    private boolean checkedIn = false;

    public ReservationController(HotelReservationUI ui) {
        this.ui = ui;
    }

    public void makeReservation() {

        String guestName = ui.getGuestName();

        // YOUR CODE HERE
        /*
         * Instructions:
         *
         * The UI has already read the guest name.
         *
         *  implement the reservation logic.
         *
         * 1. Check if guestName is empty.
         *
         * 2. If empty:
         *      - Show a JOptionPane warning.
         *      - Stop the method using return.
         *
         * 3. If the name is valid:
         *      - Set reservationMade to true.
         *      - Set checkedIn to false.
         *
         * 4. Update the status.
         *
         *    Example:
         *    "Reservation confirmed."
         *
         * 5. You may show a confirmation dialog.
         */
    }

   

    public void checkIn() {

        // YOUR CODE HERE
        /*
         * Instructions:
         *
         * 1. Check if reservationMade is false.
         *
         * 2. If there is no reservation:
         *      - Show a warning.
         *      - return;
         *
         * 3. Check if checkedIn is already true.
         *
         * 4. If already checked in:
         *      - Show a message.
         *      - return;
         *
         * 5. Otherwise:
         *      - Set checkedIn = true.
         *      - Update the status.
         *
         * Example:
         * "Guest checked in."
         */
    }


    public void cancelReservation() {

        // YOUR CODE HERE
        /*
         * Instructions:
         *
         * 1. Check whether reservationMade is true.
         *
         * 2. If there is no reservation:
         *      - Show a warning.
         *      - return;
         *
         * 3. If there is an active reservation:
         *      - Update the status to indicate that
         *        cancellation is in progress.
         *
         * 4. Start the cancellation timer.
         *
         *
         * IMPORTANT:
         *
         * Do NOT set reservationMade to false here.
         *
         * CancelTimer will tell this controller when
         * the countdown reaches zero.
         */
    }


    public void clear() {

        // YOUR CODE HERE
        /*
         * Instructions:
         *
         * Return the entire application to its initial state.
         *
         * 1. Set reservationMade = false.
         * 2. Set checkedIn = false.
         *
         * 3. Reset the cancellation timer.
         *
         *    ui.getCancelTimer().reset();
         *
         * 4. Clear the lead guest field.
         *
         *    ui.getLeadGuestField().setText("");
         *
         * 5. Reset PAX to the first option.
         *
         * 6. Reset Room to the first option.
         *
         * 7. Reset nights to 1.
         *
         * 8. Clear the summary.
         *
         * 9. Clear the status.
         */
    }

    public void reservationCancelled() {

        // YOUR CODE HERE
        /*
         * This method is called by CancelTimer after
         * the countdown reaches 0.
         *
         * 1. Set reservationMade = false.
         * 2. Set checkedIn = false.
         *
         * 3. Update the status:
         *
         *    "Reservation cancelled."
         *
         * 4. You may show a confirmation dialog.
         */
    }

   

    public boolean isReservationMade() {
        return reservationMade;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }
}
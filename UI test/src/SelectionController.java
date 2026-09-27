/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jawesome
 */
public class SelectionController {

    private HotelReservationUI ui;

    public SelectionController(HotelReservationUI ui) {
        this.ui = ui;
    }

    public void paxChanged() {

        String pax = ui.getSelectedPax();

        // YOUR CODE HERE
        /*
         * Instructions:
         *
         * The UI has already read the selected PAX.
         *
         * make sure the reservation summary
         * is updated.
         *
         *
         * updateSummary();
         */
    }

  

    public void roomChanged() {

        String room = ui.getSelectedRoom();

        // YOUR CODE HERE
        /*
         * Instructions:
         *
         * UI has already read the selected room.
         *
         *  make sure the reservation summary
         * is updated.
         *
         *
         * updateSummary();
         */
    }


    public void updateSummary() {

        // Already provided by the UI:
        String room = ui.getSelectedRoom();
        String pax = ui.getSelectedPax();
        int nights = ui.getNights();

        // YOUR CODE HERE
        /*
         *
         * 1. Determine the room price.
         *
         *    Standard Room = PHP 1500
         *    Deluxe Room   = PHP 2500
         *    Suite         = PHP 4000
         *
         * 2. Calculate:
         *
         *    total = room price × nights
         *
         * 3. Format the total as PHP.
         *
         *    Example:
         *
         *    String totalText =
         *        String.format(
         *            "PHP %.2f",
         *            total
         *        );
         *
         * 4. Send the result back to the UI:
         *
         *    ui.updateSummary(
         *        room,
         *        pax,
         *        String.valueOf(nights),
         *        totalText
         *    );
         */
    }
}
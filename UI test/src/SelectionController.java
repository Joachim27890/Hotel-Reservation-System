/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KaiHonu
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
         * 
         */
        updateSummary();
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
        updateSummary();
    }


    public void updateSummary() {

        // Already provided by the UI:
        String room = ui.getSelectedRoom();
        String pax = ui.getSelectedPax();
        int nights = ui.getNights();

        // YOUR CODE HERE
        //room price based on selection
        double roomPrice = 0;
        
        if (room != null) {
            if (room.equalsIgnoreCase("Standard Room")) {
                roomPrice = 1500;
            } else if (room.equalsIgnoreCase("Deluxe Room")) {
                roomPrice = 2500;
            } else if (room.equalsIgnoreCase("Suite")) {
                roomPrice = 4000;
            }
        }

        //Calculates the total cost
        double total = roomPrice * nights;

        //Format the total as PHP currency
        String totalText = String.format("PHP %.2f", total);

        // 4. Send the result back to the UI
        ui.updateSummary(
            room,
            pax,
            String.valueOf(nights),
            totalText
        );
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

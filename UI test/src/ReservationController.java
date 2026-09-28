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

        if (guestName.isEmpty()) {

            JOptionPane.showMessageDialog(
                ui,
                "Please enter the lead guest name.",
                "Missing Guest Name",
                JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        reservationMade = true;
        checkedIn = false;

        ui.updateStatus("Reservation confirmed.");

        JOptionPane.showMessageDialog(
            ui,
            "Reservation successfully created for "
            + guestName + ".",
            "Reservation Confirmed",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void checkIn() {

        if (!reservationMade) {

            JOptionPane.showMessageDialog(
                ui,
                "There is no active reservation.",
                "Check-In Error",
                JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (checkedIn) {

            JOptionPane.showMessageDialog(
                ui,
                "Guest is already checked in.",
                "Check-In",
                JOptionPane.INFORMATION_MESSAGE
            );

            return;
        }

        checkedIn = true;

        ui.updateStatus("Guest checked in.");

        JOptionPane.showMessageDialog(
            ui,
            "Guest successfully checked in.",
            "Check-In Successful",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void cancelReservation() {

        if (!reservationMade) {

            JOptionPane.showMessageDialog(
                ui,
                "There is no active reservation to cancel.",
                "Cancellation Error",
                JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (ui.getCancelTimer().isRunning()) {

            ui.getCancelTimer().undoCancellation();

            ui.updateStatus("Reservation active.");

            return;
        }

        ui.updateStatus("Cancellation pending...");

        ui.getCancelTimer().startCountdown();
    }

    public void clear() {

        reservationMade = false;
        checkedIn = false;

        ui.getCancelTimer().reset();

        ui.getLeadGuestField().setText("");

        ui.getPaxCombo().setSelectedIndex(0);

        ui.getRoomCombo().setSelectedIndex(0);

        ui.getNightsSpinner().setValue(1);

        ui.clearSummary();

        ui.clearStatus();
    }

    public void reservationCancelled() {


        reservationMade = false;
        checkedIn = false;

        ui.updateStatus("Reservation cancelled.");

        JOptionPane.showMessageDialog(
            ui,
            "The reservation has been cancelled.",
            "Reservation Cancelled",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public boolean isReservationMade() {
        return reservationMade;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }
}
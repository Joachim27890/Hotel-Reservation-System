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

    private String savedGuestName = "";
    private String savedRoom = "";
    private String savedPax = "";
    private int savedNights = 1;

    private int assignedRoom = 0;

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

        savedGuestName = guestName;
        savedRoom = ui.getSelectedRoom();
        savedPax = ui.getSelectedPax();
        savedNights = ui.getNights();

        reservationMade = true;
        checkedIn = false;
        assignedRoom = 0;

        ui.getNewReservationButton().setEnabled(true);

        ui.updateStatus("Reservation confirmed.");

        JOptionPane.showMessageDialog(
            ui,
            "Reservation successfully created for "
            + savedGuestName + ".",
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

        assignedRoom = 201 + (int)(Math.random() * 10);

        checkedIn = true;

        ui.updateStatus("Guest checked in.");

        JOptionPane.showMessageDialog(
            ui,
            "Guest successfully checked in.\n\n"
            + "Assigned Room: Room " + assignedRoom + "\n"
            + "Please proceed to Counter 3 to claim your key card.",
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

    public void reservationCancelled() {

        reservationMade = false;
        checkedIn = false;

        savedGuestName = "";
        savedRoom = "";
        savedPax = "";
        savedNights = 1;
        assignedRoom = 0;

        ui.getLeadGuestField().setText("");
        ui.getPaxCombo().setSelectedIndex(0);
        ui.getRoomCombo().setSelectedIndex(0);
        ui.getNightsSpinner().setValue(1);

        ui.clearSummary();

        ui.getNewReservationButton().setEnabled(false);

        ui.updateStatus("Reservation cancelled.");

        JOptionPane.showMessageDialog(
            ui,
            "The reservation has been cancelled.",
            "Reservation Cancelled",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void newReservation() {

        if (!reservationMade) {

            JOptionPane.showMessageDialog(
                ui,
                "There is no active reservation.",
                "New Reservation",
                JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (ui.getCancelTimer().isRunning()) {
            ui.getCancelTimer().stopTimer();
        }

        reservationMade = false;
        checkedIn = false;

        savedGuestName = "";
        savedRoom = "";
        savedPax = "";
        savedNights = 1;
        assignedRoom = 0;

        ui.getLeadGuestField().setText("");
        ui.getPaxCombo().setSelectedIndex(0);
        ui.getRoomCombo().setSelectedIndex(0);
        ui.getNightsSpinner().setValue(1);

        ui.clearSummary();

        ui.getCancellationTimerLabel()
            .setText("Cancellation Timer: Not started");

        ui.setCancelButtonText("CANCEL");

        ui.getNewReservationButton().setEnabled(false);

        ui.updateStatus("Ready for new reservation.");

        ui.getLeadGuestField().requestFocus();
    }

    public boolean isReservationMade() {
        return reservationMade;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public int getAssignedRoom() {
        return assignedRoom;
    }
}
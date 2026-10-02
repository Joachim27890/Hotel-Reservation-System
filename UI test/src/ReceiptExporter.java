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
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptExporter {

    public static void exportReceipt(
        String guestName,
        String room,
        String pax,
        int nights,
        String total,
        int assignedRoom
    ) {

        if (assignedRoom <= 0) {
            JOptionPane.showMessageDialog(
                null,
                "You can only export a receipt after the guest has checked in.",
                "Export Receipt",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int randomNumber = 10000 + (int)(Math.random() * 90000);
        String fileName = "UI test/src/receipts/Receipt" + randomNumber + ".txt";

        // Generates a unique receipt filename, prepares the receipt content
        // This also saves it as a new text file in the receipts folder.

        String receipt =
            "========================================\n" +
            "             SUNRISE HOTEL\n" +
            "        RESERVATION RECEIPT\n" +
            "========================================\n\n" +

            "Guest Information\n" +
            "----------------------------------------\n" +
            "Lead Guest: " + guestName + "\n" +
            "PAX: " + pax + "\n\n" +

            "Reservation Details\n" +
            "----------------------------------------\n" +
            "Room Type: " + room + "\n" +
            "Nights: " + nights + "\n" +
            "Total: " + total + "\n\n" +

            "Check-In Information\n" +
            "----------------------------------------\n" +
            "Assigned Room: Room " + assignedRoom + "\n" +
            "Key Card: Counter 3\n\n" +

            "========================================\n" +
            "Thank you for choosing Sunrise Hotel!\n" +
            "Affordable stays for everyone.\n" +
            "========================================\n";

        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(receipt);
            writer.close();

            JOptionPane.showMessageDialog(
                null,
                "Receipt exported successfully!"
            );

        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                null,
                "Error exporting receipt: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
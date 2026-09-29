/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jawesome
 */
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;

public class HotelReservationUI extends JFrame {

    private static final Color NAVY = new Color(20, 45, 80);
    private static final Color BLUE = new Color(40, 100, 180);
    private static final Color GREEN = new Color(45, 140, 90);
    private static final Color RED = new Color(190, 60, 60);
    private static final Color LIGHT_BG = new Color(245, 247, 250);

    private ReservationController reservationController;
    private SelectionController selectionController;
    private KeyboardController keyboardController;
    private CancelTimer cancelTimer;

    private JTextField leadGuestField;
    private JComboBox<String> paxCombo;
    private JComboBox<String> roomCombo;
    private JSpinner nightsSpinner;
    private JLabel roomSummaryLabel;
    private JLabel paxSummaryLabel;
    private JLabel nightsSummaryLabel;
    private JLabel totalSummaryLabel;
    private JLabel statusLabel;
    private JLabel cancellationTimerLabel;
    private JButton reserveButton;
    private JButton checkInButton;
    private JButton cancelButton;
    private JButton newReservationButton;

    public HotelReservationUI() {
        setTitle("Sunrise Hotel - Reservation & Check-In System");
        setSize(850, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(LIGHT_BG);

        reservationController = new ReservationController(this);
        selectionController = new SelectionController(this);
        keyboardController = new KeyboardController(this);
        cancelTimer = new CancelTimer(this);

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(LIGHT_BG);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(NAVY);
        headerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("SUNRISE HOTEL");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitleLabel = new JLabel("Reservation & Check-In System");
        subtitleLabel.setForeground(Color.WHITE);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        headerPanel.add(titleLabel);
        headerPanel.add(Box.createVerticalStrut(5));
        headerPanel.add(subtitleLabel);

        headerPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(
                    HotelReservationUI.this,
                    "<html>"
                    + "<div style='width:380px;'>"
                    + "<h2>Sunrise Hotel</h2>"
                    + "<p><b>Affordable stays for everyone.</b></p>"
                    + "<p>"
                    + "Sunrise Hotel offers <b>room-based pricing</b>, meaning our rates "
                    + "are charged per room, per night rather than per guest. This allows "
                    + "guests to share a room without additional per-person charges, "
                    + "making our hotel a practical and budget-friendly option for "
                    + "individuals, families, and groups."
                    + "</p>"
                    + "<h3>Room Rates</h3>"
                    + "<p>"
                    + "Standard Room: ₱1,500/night<br>"
                    + "Deluxe Room: ₱2,500/night<br>"
                    + "Suite: ₱4,000/night"
                    + "</p>"
                    + "</div>"
                    + "</html>",
                    "About Sunrise Hotel",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        centerPanel.setBackground(LIGHT_BG);

        JPanel guestPanel = createPanel("GUEST INFORMATION");

        JLabel leadGuestLabel = new JLabel("Lead Guest:");
        leadGuestField = new JTextField();

        JLabel paxLabel = new JLabel("PAX:");
        paxCombo = new JComboBox<>(
            new String[]{"1 Person", "2 Persons", "3 Persons", "4 Persons"}
        );

        JPanel guestForm = new JPanel(new GridBagLayout());
        guestForm.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        guestForm.add(leadGuestLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        guestForm.add(leadGuestField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        guestForm.add(paxLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        guestForm.add(paxCombo, gbc);

        guestPanel.add(guestForm, BorderLayout.CENTER);
        centerPanel.add(guestPanel);

        JPanel roomPanel = createPanel("ROOM RESERVATION");

        JPanel roomForm = new JPanel(new GridBagLayout());
        roomForm.setBackground(Color.WHITE);

        GridBagConstraints roomGbc = new GridBagConstraints();
        roomGbc.insets = new Insets(6, 8, 6, 8);
        roomGbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel roomLabel = new JLabel("Room Type:");

        roomCombo = new JComboBox<>(
            new String[]{"Standard Room", "Deluxe Room", "Suite"}
        );

        JLabel nightsLabel = new JLabel("Number of Nights:");

        nightsSpinner = new JSpinner(
            new SpinnerNumberModel(1, 1, 30, 1)
        );

        roomGbc.gridx = 0;
        roomGbc.gridy = 0;
        roomGbc.weightx = 0;
        roomForm.add(roomLabel, roomGbc);

        roomGbc.gridx = 1;
        roomGbc.weightx = 1;
        roomForm.add(roomCombo, roomGbc);

        roomGbc.gridx = 0;
        roomGbc.gridy = 1;
        roomGbc.weightx = 0;
        roomForm.add(nightsLabel, roomGbc);

        roomGbc.gridx = 1;
        roomGbc.weightx = 1;
        roomForm.add(nightsSpinner, roomGbc);

        roomPanel.add(roomForm, BorderLayout.NORTH);

        JPanel summaryPanel = new JPanel();
        summaryPanel.setLayout(new BoxLayout(summaryPanel, BoxLayout.Y_AXIS));
        summaryPanel.setBackground(Color.WHITE);
        summaryPanel.setBorder(
            BorderFactory.createTitledBorder("RESERVATION SUMMARY")
        );

        roomSummaryLabel = new JLabel("Room:");
        paxSummaryLabel = new JLabel("PAX:");
        nightsSummaryLabel = new JLabel("Nights:");
        totalSummaryLabel = new JLabel("TOTAL:");

        summaryPanel.add(roomSummaryLabel);
        summaryPanel.add(Box.createVerticalStrut(5));
        summaryPanel.add(paxSummaryLabel);
        summaryPanel.add(Box.createVerticalStrut(5));
        summaryPanel.add(nightsSummaryLabel);
        summaryPanel.add(Box.createVerticalStrut(5));
        summaryPanel.add(totalSummaryLabel);

        roomPanel.add(summaryPanel, BorderLayout.CENTER);

        JPanel statusPanel = new JPanel(new GridLayout(2, 1));
        statusPanel.setBackground(Color.WHITE);

        statusLabel = new JLabel(" ");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));

        cancellationTimerLabel =
            new JLabel("Cancellation Timer: Not started");

        statusPanel.add(statusLabel);
        statusPanel.add(cancellationTimerLabel);

        roomPanel.add(statusPanel, BorderLayout.SOUTH);

        centerPanel.add(roomPanel);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(
            new FlowLayout(FlowLayout.CENTER, 10, 5)
        );

        buttonPanel.setBackground(LIGHT_BG);

        reserveButton = new JButton("MAKE RESERVATION");
        checkInButton = new JButton("CHECK IN");
        cancelButton = new JButton("CANCEL");
        newReservationButton = new JButton("NEW RESERVATION");

        reserveButton.setBackground(BLUE);
        reserveButton.setForeground(Color.WHITE);

        checkInButton.setBackground(GREEN);
        checkInButton.setForeground(Color.WHITE);

        cancelButton.setBackground(RED);
        cancelButton.setForeground(Color.WHITE);

        newReservationButton.setEnabled(false);

        buttonPanel.add(reserveButton);
        buttonPanel.add(checkInButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(newReservationButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);

        reserveButton.addActionListener(
            e -> reservationController.makeReservation()
        );

        checkInButton.addActionListener(
            e -> reservationController.checkIn()
        );

        cancelButton.addActionListener(
            e -> reservationController.cancelReservation()
        );

        newReservationButton.addActionListener(
            e -> reservationController.newReservation()
        );

        paxCombo.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                selectionController.paxChanged();
            }
        });

        roomCombo.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                selectionController.roomChanged();
            }
        });

        nightsSpinner.addChangeListener(
            e -> selectionController.updateSummary()
        );

        keyboardController.attach();

        setJMenuBar(createMenuBar());
    }

    private JMenuBar createMenuBar() {

        JMenuBar menuBar = new JMenuBar();

        JMenu reservationMenu = new JMenu("Reservation");

        JMenuItem viewReservationItem =
            new JMenuItem("View Reservation");

        reservationMenu.add(viewReservationItem);

        JMenu helpMenu = new JMenu("Help");

        JMenuItem aboutItem = new JMenuItem("About");

        helpMenu.add(aboutItem);

        reservationMenu.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                updateStatus("Reservation menu opened.");
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

        helpMenu.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                updateStatus("Help menu opened.");
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

        viewReservationItem.addActionListener(e -> {

            String guest = getGuestName();
            String room = getSelectedRoom();
            String pax = getSelectedPax();
            int nights = getNights();

            JOptionPane.showMessageDialog(
                this,
                "Lead Guest: " + guest + "\n"
                + "Room: " + room + "\n"
                + "PAX: " + pax + "\n"
                + "Nights: " + nights,
                "Current Reservation",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        aboutItem.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                this,
                "<html>"
                + "<div style='width:380px;'>"
                + "<h2>Sunrise Hotel</h2>"
                + "<p><b>Affordable stays for everyone.</b></p>"
                + "<p>"
                + "Sunrise Hotel offers <b>room-based pricing</b>, meaning our rates "
                + "are charged per room, per night rather than per guest. This allows "
                + "guests to share a room without additional per-person charges, "
                + "making our hotel a practical and budget-friendly option for "
                + "individuals, families, and groups."
                + "</p>"
                + "<h3>Room Rates</h3>"
                + "<p>"
                + "Standard Room — ₱1,500/night<br>"
                + "Deluxe Room — ₱2,500/night<br>"
                + "Suite — ₱4,000/night"
                + "</p>"
                + "</div>"
                + "</html>",
                "About Sunrise Hotel",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        menuBar.add(reservationMenu);
        menuBar.add(helpMenu);

        return menuBar;
    }

    private JPanel createPanel(String title) {

        JPanel panel =
            new JPanel(new BorderLayout(10, 10));

        panel.setBackground(Color.WHITE);

        panel.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(NAVY),
                title
            )
        );

        return panel;
    }

    public String getGuestName() {
        return leadGuestField.getText().trim();
    }

    public String getSelectedRoom() {
        return roomCombo.getSelectedItem().toString();
    }

    public String getSelectedPax() {
        return paxCombo.getSelectedItem().toString();
    }

    public int getNights() {
        return (Integer) nightsSpinner.getValue();
    }

    public void updateSummary(
        String room,
        String pax,
        String nights,
        String total
    ) {

        roomSummaryLabel.setText("Room: " + room);
        paxSummaryLabel.setText("PAX: " + pax);
        nightsSummaryLabel.setText("Nights: " + nights);
        totalSummaryLabel.setText("TOTAL: " + total);
    }

    public void clearSummary() {
        roomSummaryLabel.setText("Room:");
        paxSummaryLabel.setText("PAX:");
        nightsSummaryLabel.setText("Nights:");
        totalSummaryLabel.setText("TOTAL:");
    }

    public void updateStatus(String status) {
        statusLabel.setText("Status: " + status);
    }

    public void clearStatus() {
        statusLabel.setText(" ");
    }

    public void setCancelButtonText(String text) {
        cancelButton.setText(text);
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JButton getNewReservationButton() {
        return newReservationButton;
    }

    public JTextField getLeadGuestField() {
        return leadGuestField;
    }

    public JComboBox<String> getPaxCombo() {
        return paxCombo;
    }

    public JComboBox<String> getRoomCombo() {
        return roomCombo;
    }

    public JSpinner getNightsSpinner() {
        return nightsSpinner;
    }

    public JLabel getCancellationTimerLabel() {
        return cancellationTimerLabel;
    }

    public ReservationController getReservationController() {
        return reservationController;
    }

    public CancelTimer getCancelTimer() {
        return cancelTimer;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            HotelReservationUI ui =
                new HotelReservationUI();

            ui.setVisible(true);
        });
    }
}
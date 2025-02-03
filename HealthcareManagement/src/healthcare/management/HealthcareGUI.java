package healthcare.management;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class HealthcareGUI extends JFrame {
    private static final long serialVersionUID = -1892440601815955113L;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    // Components for the login page
    private JTextField usernameField;
    private JPasswordField passwordField;

    // Components for the appointment management page
    private JTextField appointmentIdField, appointmentDateField, appointmentTimeField;
    private JTextField patientIdField, patientNameField, patientAgeField;
    private JTextField doctorIdField, doctorNameField, doctorSpecialtyField;
    private JButton submitButton;

    private AppointmentManagement appointmentManagement;
    private PatientManagement patientManagement;
    private DoctorManagement doctorManagement;

    public HealthcareGUI() {
        setTitle("Healthcare Management System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        add(cardPanel);

        createWelcomePage();
        createLoginPage();
        createAppointmentPage();

        appointmentManagement = new AppointmentManagement();
        patientManagement = new PatientManagement();
        doctorManagement = new DoctorManagement();
    }

    private void createWelcomePage() {
        ImagePanel welcomePanel = new ImagePanel("welcome.jpeg");
        welcomePanel.setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("Welcome to Healthcare Management System", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblTitle.setForeground(new Color(70, 130, 180)); // Steel blue
        welcomePanel.add(lblTitle, BorderLayout.CENTER);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> cardLayout.show(cardPanel, "login"));
        welcomePanel.add(nextButton, BorderLayout.SOUTH);

        cardPanel.add(welcomePanel, "welcome");
    }

    private void createLoginPage() {
        ImagePanel loginPanel = new ImagePanel("welcome.jpeg"); // Check the file name and path
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("SansSerif", Font.PLAIN, 18));
        gbc.gridx = 0; gbc.gridy = 0; loginPanel.add(lblUsername, gbc);

        usernameField = new JTextField(15);
        gbc.gridx = 1; loginPanel.add(usernameField, gbc);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 18));
        gbc.gridx = 0; gbc.gridy = 1; loginPanel.add(lblPassword, gbc);

        passwordField = new JPasswordField(15);
        gbc.gridx = 1; loginPanel.add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if ("suna2".equals(username) && "123".equals(password)) {
                cardLayout.show(cardPanel, "appointment");
            } else {
                JOptionPane.showMessageDialog(null, "Error: Incorrect username or password.");
            }
        });
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; loginPanel.add(loginButton, gbc);

        cardPanel.add(loginPanel, "login");
    }

    private void createAppointmentPage() {
        // Create an ImagePanel with the desired background image
        ImagePanel appointmentPanel = new ImagePanel("welcome.jpeg"); // Ensure this image exists
        appointmentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST; // Align components to the west (left)

        // Title Label
        JLabel lblAppointment = new JLabel("Appointment Details:");
        lblAppointment.setFont(new Font("SansSerif", Font.BOLD, 20)); // Increased font size
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; // Use grid width of 2 to span across
        appointmentPanel.add(lblAppointment, gbc);

        // Appointment ID
        JLabel lblId = new JLabel("Appointment ID:");
        lblId.setFont(new Font("SansSerif", Font.PLAIN, 18)); // Increased font size
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; // Reset grid width for the next row
        appointmentPanel.add(lblId, gbc);
        appointmentIdField = new JTextField(10);
        gbc.gridx = 1; appointmentPanel.add(appointmentIdField, gbc);

        // Date
        JLabel lblDate = new JLabel("Date (YYYY-MM-DD):");
        lblDate.setFont(new Font("SansSerif", Font.PLAIN, 18));
        gbc.gridx = 0; gbc.gridy = 2; appointmentPanel.add(lblDate, gbc);
        appointmentDateField = new JTextField(10);
        gbc.gridx = 1; appointmentPanel.add(appointmentDateField, gbc);

        // Time
        JLabel lblTime = new JLabel("Time (HH:MM):");
        lblTime.setFont(new Font("SansSerif", Font.PLAIN, 18));
        gbc.gridx = 0; gbc.gridy = 3; appointmentPanel.add(lblTime, gbc);
        appointmentTimeField = new JTextField(10);
        gbc.gridx = 1; appointmentPanel.add(appointmentTimeField, gbc);

        // Patient Details
        JLabel lblPatient = new JLabel("Patient Details");
        lblPatient.setFont(new Font("SansSerif", Font.BOLD, 20));
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; appointmentPanel.add(lblPatient, gbc);
        JLabel lblPatientId = new JLabel("Patient ID:");
        lblPatientId.setFont(new Font("SansSerif", Font.PLAIN, 18));
        gbc.gridwidth = 1; gbc.gridx = 0; gbc.gridy = 5; appointmentPanel.add(lblPatientId, gbc);
        patientIdField = new JTextField(10);
        gbc.gridx = 1; appointmentPanel.add(patientIdField, gbc);

        JLabel lblPatientName = new JLabel("Patient Name:");
        lblPatientName.setFont(new Font("SansSerif", Font.PLAIN, 18));
        gbc.gridx = 0; gbc.gridy = 6; appointmentPanel.add(lblPatientName, gbc);
        patientNameField = new JTextField(10);
        gbc.gridx = 1; appointmentPanel.add(patientNameField, gbc);

        JLabel lblPatientAge = new JLabel("Patient Age:");
        lblPatientAge.setFont(new Font("SansSerif", Font.PLAIN, 18));
        gbc.gridx = 0; gbc.gridy = 7; appointmentPanel.add(lblPatientAge, gbc);
        patientAgeField = new JTextField(10);
        gbc.gridx = 1; appointmentPanel.add(patientAgeField, gbc);

        // Doctor Details
        JLabel lblDoctor = new JLabel("Doctor Details");
        lblDoctor.setFont(new Font("SansSerif", Font.BOLD, 20));
        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2; appointmentPanel.add(lblDoctor, gbc);
        JLabel lblDoctorId = new JLabel("Doctor ID:");
        lblDoctorId.setFont(new Font("SansSerif", Font.PLAIN, 18));
        gbc.gridwidth = 1; gbc.gridx = 0; gbc.gridy = 9; appointmentPanel.add(lblDoctorId, gbc);
        doctorIdField = new JTextField(10);
        gbc.gridx = 1; appointmentPanel.add(doctorIdField, gbc);

        JLabel lblDoctorName = new JLabel("Doctor Name:");
        lblDoctorName.setFont(new Font("SansSerif", Font.PLAIN, 18));
        gbc.gridx = 0; gbc.gridy = 10; appointmentPanel.add(lblDoctorName, gbc);
        doctorNameField = new JTextField(10);
        gbc.gridx = 1; appointmentPanel.add(doctorNameField, gbc);

        JLabel lblDoctorSpecialty = new JLabel("Specialty:");
        lblDoctorSpecialty.setFont(new Font("SansSerif", Font.PLAIN, 18));
        gbc.gridx = 0; gbc.gridy = 11; appointmentPanel.add(lblDoctorSpecialty, gbc);
        doctorSpecialtyField = new JTextField(10);
        gbc.gridx = 1; appointmentPanel.add(doctorSpecialtyField, gbc);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        submitButton.addActionListener(e -> handleSubmit());
        gbc.gridx = 0; gbc.gridy = 12; gbc.gridwidth = 2; appointmentPanel.add(submitButton, gbc);

        // Add appointment panel to the card layout
        cardPanel.add(appointmentPanel, "appointment");
    }


    private void handleSubmit() {
        try {
            long appointmentIdFromField = Long.parseLong(appointmentIdField.getText());
            String appointmentDate = appointmentDateField.getText();
            String appointmentTime = appointmentTimeField.getText();
            long patientId = Long.parseLong(patientIdField.getText());
            String patientName = patientNameField.getText();
            int patientAge = Integer.parseInt(patientAgeField.getText());
            long doctorId = Long.parseLong(doctorIdField.getText());
            String doctorName = doctorNameField.getText();
            String doctorSpecialty = doctorSpecialtyField.getText();

            doctorManagement.addDoctor(doctorId, doctorName, doctorSpecialty);
            patientManagement.addPatient(patientId, patientName, patientAge);
            long appointmentId = appointmentManagement.addAppointment(patientId, doctorId, appointmentIdFromField, appointmentDate, appointmentTime);

            JOptionPane.showMessageDialog(null, "Appointment booked successfully! Appointment ID: " + appointmentId);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error: Please enter valid numbers for Patient ID, Age, and Doctor ID.");
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HealthcareGUI gui = new HealthcareGUI();
            gui.setVisible(true);
        });
    }
}

package healthcare.management;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppointmentManagement {
    private String url = "jdbc:mysql://localhost:3306/healthcare_management";
    private String user = "root";
    private String password = "root"; 

    public long addAppointment(long appointmentIdLong, long patientIdLong, long doctorIdLong, String appointmentDate, long appointmentTime) throws SQLException {
        String sql = "INSERT INTO appointments (appointment_id, patient_id, doctor_id, appointment_date, appointment_time) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, doctorIdLong);
            pstmt.setLong(2, appointmentIdLong);
            pstmt.setLong(3, patientIdLong);
            pstmt.setString(4, appointmentDate);
            pstmt.setLong(5, appointmentTime);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Appointment added successfully.");
            } else {
                System.out.println("Failed to add appointment.");
            }
            return appointmentTime; 
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // rethrow the exception for the calling method to handle
        }
    }

	public long addAppointment(long patientId, long doctorId, long appointmentIdFromField, String appointmentDate,
			String appointmentTime) {
		// TODO Auto-generated method stub
		return 0;
	}
}

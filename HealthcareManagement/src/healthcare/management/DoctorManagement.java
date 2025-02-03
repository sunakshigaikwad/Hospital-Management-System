package healthcare.management;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DoctorManagement {
    private String url = "jdbc:mysql://localhost:3306/healthcare_management";
    private String user = "root";
    private String password = "root"; 

    public void addDoctor(Long doctorId, String doctorName, String doctorSpecialty) throws SQLException {
        String sql = "INSERT INTO doctors (doctor_id, doctor_name, doctor_specialty) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, doctorId);
            pstmt.setString(2, doctorName);
            pstmt.setString(3, doctorSpecialty);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Doctor added successfully.");
            } else {
                System.out.println("Failed to add doctor.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // rethrow the exception for the calling method to handle
        }
    }

	public void addDoctor(long doctorId, String doctorName, String doctorSpecialty) {
		// TODO Auto-generated method stub
		
	}
}

package healthcare.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientManagement {
    
    public void addPatient(Long patientId, String patientName, int age) {
        String query = "INSERT INTO patients (patient_id, patient_name, patient_age) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setLong(1, patientId);
            stmt.setString(2, patientName);
            stmt.setInt(3, age);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void addPatient(long patientId, String patientName, int patientAge) {
		// TODO Auto-generated method stub
		
	}
}

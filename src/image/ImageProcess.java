package image;

import java.awt.Image;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageProcess implements ImageInterface {
	
	public void imageExportProcess(int id) throws SQLException, IOException {
		String sqlstr = "select * from Image_Process where imageId = ?";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setInt(1, id);
		ResultSet rs = state.executeQuery();
		
		if(rs.next()) {
			Blob blob = rs.getBlob(3);
			int length = (int) blob.length();
			//System.out.println("length: " + length);
			
			BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream("c:/project1/Test_Export.jpg"));
			bos1.write(blob.getBytes(1, length));
			bos1.flush();
			bos1.close();
			System.out.println("export success!");
			rs.close();
			state.close();
		}else {
			System.out.println("image not found!");
		}
	}
	
	public void imageStoreProcess() throws SQLException, FileNotFoundException {
		
		FileInputStream fis = new FileInputStream("c:/project1/Tomorrowland-2022-W3-04.jpg");
		String sqlstr = "insert into Image_Process(imageName, imageFile) values (?,?)";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setString(1, "Tomorrowland_2022_Mainstage");
		state.setBinaryStream(2, fis);
		state.execute();
		System.out.println("import success!");
		state.close();
		
	}
	
	private Connection conn;

	public void createConn() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String urlstr = "jdbc:sqlserver://localhost:1433;databaseName=KchoDB;user=watcher;password=P@ssw0rd;encrypt=true;trustServerCertificate=true";
		conn = DriverManager.getConnection(urlstr);
		//System.out.println("Connection status: " + !conn.isClosed());
	}
	
	public void closeConn() throws SQLException {
		if(conn != null) {
		conn.close();
		}
		//System.out.println("Connection closed");
	}
}

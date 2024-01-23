package image;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public interface ImageInterface {
	
	public void imageExportProcess(int id) throws SQLException, IOException; 
	public void imageStoreProcess() throws SQLException, FileNotFoundException;
	public void createConn() throws Exception;
	public void closeConn() throws SQLException;
}

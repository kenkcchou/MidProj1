package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VenueDaoImpl implements VenueDao {

	private Connection conn;

	@Override
	public void add(Venue v) throws SQLException {
		
		
	}

	@Override
	public void update(Venue v) throws SQLException {
		String sqlstr = "update Venue set organizer = ? where id = ?";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setString(1, v.getOrganizer());
		state.setInt(2, v.getId());
		state.executeUpdate();
		state.close();
		
	}

	@Override
	public void deleteById(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Venue findById(int id) throws SQLException {
		String sqlstr = "select * from Venue where id = ?";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setInt(1, id);
		ResultSet rs = state.executeQuery();
		
		Venue v = null;
		if(rs.next()) {
			v = new Venue(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
		}
		rs.close();
		state.close();
		return v;
	}

	@Override
	public void writeInto() throws SQLException {
		File file = new File("c:\\project1\\總爺藝文中心機關團體預約導覽登記表.csv");
		String sqlstr = "insert into Venue (id, event_date, start_time, end_time, attendance, activity, organizer) values (?,?,?,?,?,?,?)";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			br.readLine();
			while((line = br.readLine()) != null) {
				String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String event_date = data[1];
                String start_time = data[2];
                String end_time = data[3];
                String attendence = data[4];
                String activity = data[5];
                String organizer = data[6];
                
                state.setInt(1, id);
                state.setString(2, event_date);
                state.setString(3, start_time);
                state.setString(4, end_time);
                state.setString(5, attendence);
                state.setString(6, activity);
                state.setString(7, organizer);
                state.addBatch();
			}
				state.executeBatch();
				br.close();
				System.out.println("import success!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createConn() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String urlstr = "jdbc:sqlserver://localhost:1433;databaseName=KchoDB;user=watcher;password=P@ssw0rd;encrypt=true;trustServerCertificate=true";
		conn = DriverManager.getConnection(urlstr);
		//System.out.println("Connection status: " + !conn.isClosed());
		
	}

	@Override
	public void closeConn() throws SQLException {
		if(conn != null) {
			conn.close();
			}
			//System.out.println("Connection closed");
	}
	
	@Override
	public void fuzzyDelete(String str) throws SQLException {
		String sqlstr = "delete Venue where id like ? or event_date like ? or start_time like ? or end_time like ? or attendance like ? or activity like ? or organizer like ?";
		String fuzzystr = "%" + str + "%";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setString(1, fuzzystr);
		state.setString(2, fuzzystr);
		state.setString(3, fuzzystr);
		state.setString(4, fuzzystr);
		state.setString(5, fuzzystr);
		state.setString(6, fuzzystr);
		state.setString(7, fuzzystr);
		int deleteCount = state.executeUpdate();
		System.out.println("delete success!");
		System.out.println("number of records deleted: " + deleteCount);
		
		state.close();
	}

}

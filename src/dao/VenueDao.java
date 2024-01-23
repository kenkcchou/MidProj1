package dao;

import java.sql.SQLException;

import dao.Venue;

public interface VenueDao {
	public void add(Venue v) throws SQLException;
	public void update(Venue v) throws SQLException;
	public void deleteById(int id) throws SQLException;
	public Venue findById(int id) throws SQLException;
	public void writeInto() throws SQLException;
	public void fuzzyDelete(String str) throws SQLException;
	public void createConn() throws Exception;
	public void closeConn() throws SQLException;
}

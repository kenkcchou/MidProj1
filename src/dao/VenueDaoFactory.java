package dao;

public class VenueDaoFactory {
	
	public static VenueDao createVenueDaoFactory() {
		return new VenueDaoImpl();
	}
}

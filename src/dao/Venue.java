package dao;

public class Venue {
	
	private int id;
	private String event_date;
	private String start_time;
	private String end_time;
	private String attendance;
	private String activity;
	private String organizer;
	
	public Venue() {
	}
	
	public Venue(int id, String event_date, String start_time, String end_time, String attendance, String activity, String organizer) {
		this.id = id;
		this.event_date = event_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.attendance = attendance;
		this.activity = activity;
		this.organizer = organizer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEvent_date() {
		return event_date;
	}

	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendence(String attendence) {
		this.attendance = attendence;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	
	
}

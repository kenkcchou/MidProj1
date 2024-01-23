package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

import dao.Venue;
import dao.VenueDao;
import dao.VenueDaoFactory;

public class VenueDaoTest {

	public static void main(String[] args) throws Exception {
		VenueDao vdao = VenueDaoFactory.createVenueDaoFactory();
		vdao.createConn();

//匯入
//		vdao.writeInto();

//查詢匯出txt		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("please enter search id");				
//		int inputId = scanner.nextInt();
//		Venue v = vdao.findById(inputId);
//		if(v != null) {
//			System.out.println(v.getId() + " " + v.getEvent_date() + " " + v.getStart_time() + " " + v.getEnd_time() + " " + v.getAttendance() + " " + v.getActivity() + " " + v.getOrganizer());
//			BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\project1\\" + inputId + ".txt"));
//			bw.write(v.getId() + " " + v.getEvent_date() + " " + v.getStart_time() + " " + v.getEnd_time() + " " + v.getAttendance() + " " + v.getActivity() + " " + v.getOrganizer());
//			bw.close();
//		}else {
//			System.out.println("id does not exist");
//		}

//模糊刪除
//		Scanner scanner2 = new Scanner(System.in);
//		System.out.println("please enter key world");
//		String inputId2 = scanner2.next();
//		vdao.fuzzyDelete(inputId2);

//修改	
//		Scanner scanner3 = new Scanner(System.in);
//		System.out.println("please enter search id");
//		int inputId3 = scanner3.nextInt();
//		Venue v2 = vdao.findById(inputId3);
//		if (v2 == null) {
//			System.out.println("id does not exist");
//		} else {
//			scanner3.nextLine();
//			System.out.println("please enter field name");
//			String inputField = scanner3.next();
//			if (inputField.equals("organizer")) {
//				System.out.println("please enter update info");
//				scanner3.nextLine();
//				String inputField2 = scanner3.nextLine();
//				v2.setOrganizer(inputField2);
//			}
//			vdao.update(v2);
//			System.out.println("update success!");
//		}

		vdao.closeConn();
	}

}

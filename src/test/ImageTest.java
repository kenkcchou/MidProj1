package test;

import java.util.Scanner;

import image.ImageInterfaceFactory;
import image.ImageProcess;

public class ImageTest {

	public static void main(String[] args) throws Exception {
		ImageProcess ip = ImageInterfaceFactory.createImageInterfaceFactory();
		ip.createConn();
//圖片匯入
//		ip.imageStoreProcess();

		
//圖片匯出		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("please enter image id");
//		int inputId = scanner.nextInt();
//		ip.imageExportProcess(inputId);
			
		
		ip.closeConn();
	}

}

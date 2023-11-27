package NhanVien;

import java.util.Scanner;

public class Kho extends NhanVien{
	Scanner sc=new Scanner(System.in);
	String ngaykiemkho;
	public Kho() {
		ngaykiemkho="";
	}

	public void nhap() {
		super.nhap();
		System.out.println("Ngay kiem kho: ");
		ngaykiemkho=sc.nextLine();
	}
	public void xuat() {
		super.xuat();
		System.out.println("Cong viec: Kho");
		System.out.println("Ngay kiem kho: "+ngaykiemkho);
	}
}
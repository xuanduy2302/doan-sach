package NhanVien;

import java.util.Scanner;

public class ThuNgan extends NhanVien{
	Scanner sc=new Scanner(System.in);
	String ngaybanhang;
	public ThuNgan() {
		ngaybanhang="";
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		super.nhap();
		System.out.println("Ngay ban hang: ");
		ngaybanhang=sc.nextLine();
	}
	public void xuat() {
		super.xuat();
		System.out.println("Cong viec: Thu ngan");
		System.out.println("Ngay ban hang: "+ngaybanhang);
	}
			
}
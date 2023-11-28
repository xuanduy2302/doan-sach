package NHANVIEN;

import java.util.ArrayList;
import java.util.Scanner;
import abstr_interf.*;

public class DSNhanVien extends MENU{
	public static ArrayList<NHANVIEN> DanhSachNhanVien;
	public DSNhanVien() {
		DanhSachNhanVien = new ArrayList<NHANVIEN>(0);
	}
    Scanner sc = new Scanner(System.in);
    
    public void them() {
    	String choose;
    	System.out.println("Nhap cong viec cua nhan vien: \n1.Thu ngan. \n2.Kho. \n3.Bao ve."); choose=sc.nextLine();
		if(choose.equals("1")) {
			NHANVIEN x=new THUNGAN();
			x.nhap();
			DanhSachNhanVien.add(x);
		}
		else if(choose.equals("2")) {
			NHANVIEN x=new KHO();
			x.nhap();
			DanhSachNhanVien.add(x);
		}
		else if(choose.equals("3")) {
			NHANVIEN x=new BAOVE();
			x.nhap();
			DanhSachNhanVien.add(x);
		}
    }
    public void xoa(){
        String MaNVXoa;
        boolean found=false;
        System.out.print("Nhap ma nhan vien muon xoa: "); MaNVXoa=sc.nextLine();
        for (NHANVIEN NhanVien : DanhSachNhanVien)
            if (NhanVien.manv.equals(MaNVXoa)){
                DanhSachNhanVien.remove(NhanVien);
                found = true;
                System.out.println("Da xoa !");
                break;
            }
        if (!found)
            System.out.println("Khong tim thay nhan vien de xoa");
    }
    public void sua(){
        String MaNVSua;
        boolean found=false;
        System.out.print("Nhap ma nhan vien muon sua: "); MaNVSua=sc.nextLine();
        System.out.println("Chon thong tin can sua: ");
        
        for (NHANVIEN NhanVien : DanhSachNhanVien){
            if (NhanVien.manv.equals(MaNVSua)){
                found = true;
				int sua;
				System.out.println("Chon muc can sua: \n1.Ma nhan vien. \n2.Ten nhan vien. \n3.Ngay sinh nhan vien. \n4.SDT nhan vien. \n5.Dia chi. ");
				sua=sc.nextInt();
				while(sua < 1 || sua > 5) {
					sua=sc.nextInt();
				}
				if(sua==1) {
					NhanVien.manv=sc.nextLine();
				}
				else if(sua==2) {
					sc.nextLine();
					NhanVien.tennv=sc.nextLine();
				}
				else if(sua==3){
					sc.nextLine();
					NhanVien.ngaysinhnv=sc.nextLine();
				}
				else if(sua==4){
					sc.nextLine();
					NhanVien.diachinv=sc.nextLine();
				}
				System.out.println("Du lieu cua nhan vien sau khi sua: ");
				NhanVien.xuat();
			}
                break;
        }
        if (!found)
            System.out.println("Khong tim thay sach de sua !");
    }
    public void danhsach(){
        int i=1;
        System.out.println("Danh sach co "+DanhSachNhanVien.size()+" nhan vien:");
        for (NHANVIEN nv : DanhSachNhanVien) {
            System.out.print(i+"/ ");
            nv.xuat();
            System.out.println();
            i++;
        }
    }
    public void timkiem(){
        String MaNVTimKiem;
        boolean found=false;
        System.out.print("Nhap ma nhan vien can tim: "); MaNVTimKiem=sc.nextLine();
        for (NHANVIEN NhanVien : DanhSachNhanVien){
            if (NhanVien.manv.equals(MaNVTimKiem)){
                found = true;
                NhanVien.xuat();
                break;
            }
        }
        if (!found)
            System.out.println("Khong tim thay nhan vien !");
    }
}

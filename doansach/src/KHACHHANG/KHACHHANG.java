import java.util.Scanner;
import abstr_interf.*;
class KHACHHANG implements INhap,IXuat{
    protected String Id;
    protected String Name;
    protected String Address;
    protected String Phone;
    Scanner sc=new Scanner(System.in);
    public KHACHHANG() {//khởi tạo
        Id = ""; Name = "";
        Address = "";Phone = "";
    }

    public void nhap(){
        System.out.println("Nhap MA khach hang");
            Id=sc.nextLine();
        System.out.println("Nhap TEN khach hang ");
            Name=sc.nextLine();
        System.out.println("Nhap DIA CHI khach hang ");
            Address=sc.nextLine();
        System.out.println("Nhap SO DIEN THOAI khach hang ");
            Phone=sc.nextLine();
    }
    public void xuat(){
        System.out.printf("\n");
        System.out.println("Thong tin khach hang:");
        System.out.println("ID: " + Id);
        System.out.println("TEN: " + Name);
        System.out.println("DIACHI: " + Address);
        System.out.println("SO DIEN THOAI: " + Phone);
    }
}

package SACH;

import java.util.ArrayList;
import java.util.Scanner;


 public class DSSach extends MENU{
    Scanner sc = new Scanner(System.in); 
    
    public ArrayList <SACH> DanhSachSach;
    
    public DSSach(){
        DanhSachSach = new ArrayList<SACH>(0);
    }

    public void them(){
        SACH sachmoi = new SACH();
        sachmoi.nhap();
        DanhSachSach.add(sachmoi);
        SACH.updateKhoSach(sachmoi.SoLuong);
    }
    public void xoa(){
        String MaSachXoa;
        boolean found=false;
        System.out.print("Nhap ma sach muon xoa: "); MaSachXoa=sc.nextLine();
        for (SACH sach : DanhSachSach)
            if (sach.MaSach.equals(MaSachXoa)){
                found = true;
                SACH.updateKhoSach(-sach.SoLuong);
                DanhSachSach.remove(sach);
                System.out.println("Da xoa !");
                break;
            }
        if (!found)
            System.out.println("Khong tim thay sach de xoa");
    }
    public void sua(){
        String MaSachSua;
        boolean found=false;
        System.out.print("Nhap ma sach muon sua: "); MaSachSua=sc.nextLine();

        for (SACH sach : DanhSachSach){
            if (sach.MaSach.equals(MaSachSua)){
                found = true;
                sach.xuat(); System.out.println();
                System.out.println("Chon thong tin can sua: ");
                System.out.print(" 1)Ma sach\n 2)Ten sach\n 3)NXB\n 4)Tac gia\n 5)So trang\n 6)So Luong\n 7)Gia tien\n");
                int lua_chon=sc.nextInt(); sc.nextLine();
                switch (lua_chon) {
                    case 1:
                        System.out.print("Nhap ma sach moi: ");
                        sach.MaSach=sc.nextLine();
                        break;
                    case 2:
                        System.out.print("Nhap ten sach moi: ");
                        sach.TenSach=sc.nextLine();
                        break;
                    case 3:
                        System.out.print("Nhap NXB moi: ");
                        sach.NXB=sc.nextLine();
                        break;
                    case 4:
                        System.out.print("Nhap tac gia moi: ");
                        sach.TacGia=sc.nextLine();
                        break;
                    case 5:
                        System.out.print("Nhap so trang moi: ");
                        sach.SoTrang=sc.nextInt();
                        break;
                    case 6:
                        int SoLuongCu=sach.SoLuong;
                        System.out.print("Nhap so luong moi: ");
                        sach.SoLuong=sc.nextInt();
                        if(SoLuongCu < sach.SoLuong)
                            SACH.updateKhoSach(sach.SoLuong-SoLuongCu);
                        else if(SoLuongCu > sach.SoLuong)
                            SACH.updateKhoSach(-(SoLuongCu-sach.SoLuong));
                        break;
                    case 7:
                        System.out.print("Nhap gia tien moi: ");
                        sach.GiaTien=sc.nextInt();
                        break;
                }
                System.out.println("Da sua !");
                break;
            }
        }
        if (!found)
            System.out.println("Khong tim thay ma sach !");
    }
    public void xuat(){
        int i=1;
        System.out.println("Danh sach co "+DanhSachSach.size()+" sach:");
        for (SACH sach : DanhSachSach) {
            System.out.print(i+"/ ");
            sach.xuat();
            System.out.println();
            i++;
        }
    }
    public void timkiem(){
        String MaSachTimKiem;
        boolean found=false;
        System.out.print("Nhap ma sach can tim: "); MaSachTimKiem=sc.nextLine();
        for (SACH sach : DanhSachSach){
            if (sach.MaSach.equals(MaSachTimKiem)){
                found = true;
                sach.xuat();
                break;
            }
        }
        if (!found)
            System.out.println("Khong tim thay sach !");
    }
}

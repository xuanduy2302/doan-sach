package HOADON;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import NHANVIEN.*;
import SACH.*;

public class DSHoaDon {
    public static ArrayList <HOADON> DanhSachHoaDon;

    public DSHoaDon (){
        DanhSachHoaDon = new ArrayList<HOADON>(0);
    }

    public void them(){
        boolean nhaplai=false;
        HOADON HoaDonMoi = new HOADON();
        do{
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap ma hoa don: ");
            HoaDonMoi.MaHoaDon=sc.nextLine();
            while (HoaDonMoi.ChiTietHoaDon.TenNV.isEmpty()){
                System.out.print("Nhap ma nhan vien: ");
                HoaDonMoi.ChiTietHoaDon.MaNV=sc.nextLine();
                for (NHANVIEN nv : DSNhanVien.DanhSachNhanVien) {
                    if (nv.manv.equals(HoaDonMoi.ChiTietHoaDon.MaNV))
                        HoaDonMoi.ChiTietHoaDon.TenNV=nv.tennv;        
                } 
            }
            int i=1;
            String MaSP;
            int soluong;
            while(true){   
                System.out.print("Nhap ma san pham "+i+": "); MaSP=sc.nextLine();
                if (MaSP.isEmpty()) break;
                for (SACH sach : DSSach.DanhSachSach) {
                    if(sach.MaSach.equals(MaSP)){
                        HoaDonMoi.ChiTietHoaDon.DanhSachSanPham.add(sach.TenSach);
                        HoaDonMoi.ChiTietHoaDon.DanhSachMaSanPham.add(sach.MaSach);
                        System.out.print("Nhap so luong: "); soluong=sc.nextInt(); sc.nextLine();
                        HoaDonMoi.ChiTietHoaDon.SoLuongMoiSP.add(soluong);
                        sach.SoLuong-=soluong;
                        SACH.updateKhoSach(-soluong);
                        i++;
                    }
                }
            }
            //khai báo đối tượng current thuộc class LocalDateTime
            LocalDateTime current = LocalDateTime.now();
            //sử dụng class DateTimeFormatter để định dạng ngày giờ theo kiểu pattern
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            //sử dụng phương thức format() để định dạng ngày giờ hiện tại rồi gán cho chuỗi formatted
            HoaDonMoi.Date = current.format(formatter);
            boolean sua_lai=false;
            do{
                HoaDonMoi.xuat();
                System.out.print(" 1)Luu hoa don\n 2)Sua lai\n");
                System.out.print("Lua chon: ");
                int lua_chon=sc.nextInt();
                switch (lua_chon){
                    case 1:
                        sua_lai=false;
                        nhaplai=false;
                        break;
                    case 2:
                        sua_lai=true;
                        System.out.println("Chon thong tin muon sua:");
                        System.out.print(" 1)Ma hoa don\n 2)Ma nhan vien\n 3)San pham\n 4)Sua lai toan bo\n");
                        System.out.print("Lua chon: ");
                        lua_chon=sc.nextInt(); sc.nextLine();
                        switch (lua_chon) {
                            case 1:
                                System.out.print("Nhap ma hoa don: ");
                                HoaDonMoi.MaHoaDon=sc.nextLine();
                                break;
                            case 2:
                                HoaDonMoi.ChiTietHoaDon.MaNV="";
                                while (HoaDonMoi.ChiTietHoaDon.MaNV.isEmpty()){
                                    System.out.print("Nhap ma nhan vien: ");
                                    HoaDonMoi.ChiTietHoaDon.MaNV=sc.nextLine();
                                    for (NHANVIEN nv : DSNhanVien.DanhSachNhanVien) {
                                        if (nv.manv.equals(HoaDonMoi.ChiTietHoaDon.MaNV))
                                            HoaDonMoi.ChiTietHoaDon.TenNV=nv.tennv;
                                    }
                                }
                                break;
                            case 3:
                                i=0;
                                //Them lai so luong cho sach va kho sach, xoa san pham
                                for (; i<HoaDonMoi.ChiTietHoaDon.getSL(); i++)
                                    for (SACH sach : DSSach.DanhSachSach)
                                        if (sach.MaSach.equals(HoaDonMoi.ChiTietHoaDon.DanhSachMaSanPham.get(i))){
                                            sach.SoLuong+=HoaDonMoi.ChiTietHoaDon.SoLuongMoiSP.get(i);
                                            SACH.updateKhoSach(HoaDonMoi.ChiTietHoaDon.SoLuongMoiSP.get(i));
                                        }
                                HoaDonMoi.ChiTietHoaDon.DanhSachSanPham.removeAll(HoaDonMoi.ChiTietHoaDon.DanhSachSanPham);
                                HoaDonMoi.ChiTietHoaDon.DanhSachMaSanPham.removeAll(HoaDonMoi.ChiTietHoaDon.DanhSachMaSanPham);
                                HoaDonMoi.ChiTietHoaDon.SoLuongMoiSP.removeAll(HoaDonMoi.ChiTietHoaDon.SoLuongMoiSP);
                                i=1;
                                while (true){
                                    System.out.print("Nhap ma san pham "+i+": "); MaSP=sc.nextLine();
                                    if (MaSP.isEmpty()) break;
                                    for (SACH sach : DSSach.DanhSachSach) {
                                        if(sach.MaSach.equals(MaSP)){
                                            HoaDonMoi.ChiTietHoaDon.DanhSachSanPham.add(sach.TenSach);
                                            HoaDonMoi.ChiTietHoaDon.DanhSachMaSanPham.add(sach.MaSach);
                                            System.out.print("Nhap so luong: "); soluong=sc.nextInt(); sc.nextLine();
                                            HoaDonMoi.ChiTietHoaDon.SoLuongMoiSP.add(soluong);
                                            sach.SoLuong-=soluong;
                                            SACH.updateKhoSach(-soluong);
                                            i++;
                                        }
                                    }
                                }
                                break;
                            case 4:
                                i=0;
                                //Them lai so luong cho sach va kho sach, xoa san pham
                                for (;i<HoaDonMoi.ChiTietHoaDon.getSL();i++)
                                    for (SACH sach : DSSach.DanhSachSach)
                                        if (sach.MaSach.equals(HoaDonMoi.ChiTietHoaDon.DanhSachMaSanPham.get(i))) {
                                            sach.SoLuong+=HoaDonMoi.ChiTietHoaDon.SoLuongMoiSP.get(i);
                                            SACH.updateKhoSach(HoaDonMoi.ChiTietHoaDon.SoLuongMoiSP.get(i));
                                        }
                                HoaDonMoi.ChiTietHoaDon.DanhSachSanPham.removeAll(HoaDonMoi.ChiTietHoaDon.DanhSachSanPham);
                                HoaDonMoi.ChiTietHoaDon.DanhSachMaSanPham.removeAll(HoaDonMoi.ChiTietHoaDon.DanhSachMaSanPham);
                                HoaDonMoi.ChiTietHoaDon.SoLuongMoiSP.removeAll(HoaDonMoi.ChiTietHoaDon.SoLuongMoiSP);

                                nhaplai = true;
                                sua_lai=false;
                                break;
                        }
                }
            }while(sua_lai);
        }while(nhaplai);
        DanhSachHoaDon.add(HoaDonMoi);
    }
    public void xuat(){
        int tong=0;
        //System.out.println("Danh sach co "+DanhSachHoaDon.size()+" hoa don:");
        int i=1;
        for (HOADON hoadon : DanhSachHoaDon) {
            tong+=hoadon.TongTien();
            System.out.println("---Hoa don "+i+":");
            hoadon.xuat();
            i++;
        }
        System.out.println("\n***Danh sach co "+DanhSachHoaDon.size()+" hoa don");
        System.out.println("***Tong doanh thu: "+tong+"\n");
    }
    public void WriteFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("datahoadon.txt"))) {
            for (HOADON hoadon : DanhSachHoaDon) {
                writer.write(hoadon.MaHoaDon+",");
                writer.write(hoadon.ChiTietHoaDon.MaNV+",");
                writer.write(hoadon.ChiTietHoaDon.TenNV+",");
                writer.write(hoadon.ChiTietHoaDon.MaKH+",");
                writer.write(hoadon.ChiTietHoaDon.TenKH+",");
                writer.write(hoadon.Date+"\n");
                int i=1;
                for (String masach : hoadon.ChiTietHoaDon.DanhSachMaSanPham) {
                    if (hoadon.ChiTietHoaDon.getSL()!=i)
                        writer.write(hoadon.ChiTietHoaDon.DanhSachMaSanPham.get(i-1)+",");
                    else writer.write(hoadon.ChiTietHoaDon.DanhSachMaSanPham.get(i-1)+"\n"); 
                    i++;
                }
                i=1;
                for (String tensach : hoadon.ChiTietHoaDon.DanhSachMaSanPham) {
                    if (hoadon.ChiTietHoaDon.getSL()!=i)
                        writer.write(hoadon.ChiTietHoaDon.DanhSachSanPham.get(i-1)+",");
                    else writer.write(hoadon.ChiTietHoaDon.DanhSachSanPham.get(i-1)+"\n"); 
                    i++;
                }
                i=1;
                for (Integer soluong : hoadon.ChiTietHoaDon.SoLuongMoiSP) {
                    String num = soluong.toString();
                    if ((hoadon.ChiTietHoaDon.SoLuongMoiSP.size())!=i)
                        writer.write(num+",");
                    else writer.write(num+"\n");
                    i++;
                }
                if (!hoadon.ChiTietHoaDon.MaDonHang.isEmpty())
                    writer.write("Ma don hang: "+hoadon.ChiTietHoaDon.MaDonHang);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ReadFile(){
        try (BufferedReader reader = new BufferedReader(new FileReader("datahoadon.txt"))) {
            String buff;
            String line1[],line2[],line3[];
            while ((buff = reader.readLine()) != null){
                HOADON hoadon = new HOADON();

                line1 = buff.split(",");
                hoadon.MaHoaDon=line1[0];
                hoadon.ChiTietHoaDon.MaNV=line1[1];
                hoadon.ChiTietHoaDon.TenNV=line1[2];
                hoadon.ChiTietHoaDon.MaKH=line1[3];
                hoadon.ChiTietHoaDon.TenKH=line1[4];
                hoadon.Date=line1[5];

                buff = reader.readLine();
                line2 = buff.split(",");
                for (String masach : line2) {
                    hoadon.ChiTietHoaDon.DanhSachMaSanPham.add(masach);
                }
            

                buff = reader.readLine();
                line3 = buff.split(",");
                for (String soluong : line3){
                    int num = Integer.parseInt(soluong);
                    hoadon.SoLuongMoiSP.add(num);
                }

                DanhSachHoaDon.add(hoadon);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}

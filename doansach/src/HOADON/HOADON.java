package HOADON;
import java.util.ArrayList;

import SACH.*;
import abstr_interf.*;

public class HOADON implements IXuat{
    String Date;
    String MaHoaDon;
    CHITIETHOADON ChiTietHoaDon;

    public HOADON(){
        MaHoaDon=Date="";
        ChiTietHoaDon = new CHITIETHOADON();
    }
    public int TongTien(){
        int TongTien=0;
        for (int i=0; i<ChiTietHoaDon.getSL(); i++) {
            TongTien+=ChiTietHoaDon.DonGiaMoiSP.get(i)*ChiTietHoaDon.SoLuongMoiSP.get(i);
            i++;
        }
        return TongTien;
    }
    public void xuat(){
        if (!ChiTietHoaDon.MaDonHang.isEmpty())
            System.out.println("Ma don hang: "+ChiTietHoaDon.MaDonHang);
        System.out.println("Ma hoa don: "+MaHoaDon);
        System.out.println("Nhan vien: "+ChiTietHoaDon.MaNV+" - "+ChiTietHoaDon.TenNV);
        System.out.println("Khach hang: "+ChiTietHoaDon.MaKH+" - "+ChiTietHoaDon.TenKH);
        System.out.println("Date: "+Date);
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-20s%-20s%s\n","San pham","Don gia","So luong","So tien");
        System.out.println("-------------------------------------------------------------------------------------------------");
         
        for (int i=0; i<ChiTietHoaDon.DanhSachSanPham.size(); i++) {
            System.out.printf("%d %s\n",i+1,ChiTietHoaDon.DanhSachSanPham.get(i));
            System.out.printf("  %-18s%-20d%-20d%d\n",ChiTietHoaDon.DanhSachMaSanPham.get(i),ChiTietHoaDon.DonGiaMoiSP.get(i),ChiTietHoaDon.SoLuongMoiSP.get(i),ChiTietHoaDon.DonGiaMoiSP.get(i)*ChiTietHoaDon.SoLuongMoiSP.get(i));
            i++;
        }
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.printf("%35s %d\n","Tong tien:",TongTien());
    }
}

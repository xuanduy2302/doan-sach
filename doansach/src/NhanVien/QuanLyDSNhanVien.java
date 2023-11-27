package NhanVien;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


class QuanLyDSNhanVien {
    public DSNhanVien dsNhanVien;
    public QuanLyDSNhanVien(){
    	dsNhanVien = new DSNhanVien();
    }
    void Menu(){
        int lua_chon;
       	boolean flag=true;
        while(flag){
            System.out.println(" 1/Them nhan vien.\n 2/Xoa nhan vien.\n 3/Sua nhan vien.\n 4/Xuat danh sach nhan vien.\n 5/Tim kiem nhan vien.\n 6.Thoat.");
            lua_chon=sc.nextInt();
            switch(lua_chon){
                case 1:
					dsNhanVien.them();
                    break;
                case 2:
                    dsNhanVien.xoa();
                    break;
                case 3:
                    dsNhanVien.sua();
                    break;
                case 4:
                    dsNhanVien.danhsach();
                    break;
                case 5:
                    dsNhanVien.timkiem();
                    break;
                case 6:
                    flag=false;
                    break;
           }
        }
    }
    Scanner sc=new Scanner(System.in);
    public void WriteFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("datanhanvien.txt"))) {
            for (NhanVien x : DSNhanVien.DSNhanVien) {
                writer.write(x.manv + ",");
                writer.write(x.tennv + ",");
                writer.write(x.ngaysinhnv + ",");
                writer.write(x.sdtnv + ",");
                writer.write(x.diachinv + ",");
                writer.write(x.luong + ",");
                if(x instanceof ThuNgan) {
                	writer.write("1,");
                	writer.write( ((ThuNgan)x).ngaybanhang + ",");
                }
                if(x instanceof Kho) {
                	writer.write("2,");
                	writer.write( ((Kho)x).ngaykiemkho + ",");
                }
                if(x instanceof BaoVe) {
                	writer.write("3,");
                	writer.write( ((BaoVe)x).catruc + ",");
                }
                writer.newLine(); // Xuống dòng cho mỗi nhân viên
                
            }
            System.out.println("Ghi file thanh cong!");
     
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ReadFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("datanhanvien.txt"))) {
        	String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String maNV = parts[0];
                String tenNV = parts[1];
                String ngaySinhNV = parts[2];
                String sdtNV = parts[3];
                String diaChiNV = parts[4];
                String luongNV = parts[5];
                String currentRole = parts[6];
                NhanVien nv ;
                if (currentRole.equals("1")) {
                	nv = new ThuNgan();
                    ((ThuNgan)nv).ngaybanhang = parts[7];
                    nv.manv = maNV;
                    nv.tennv = tenNV;
                    nv.ngaysinhnv = ngaySinhNV;
                    nv.sdtnv = sdtNV;
                    nv.diachinv = diaChiNV;
                    nv.luong = luongNV;
                   
                    DSNhanVien.DSNhanVien.add(nv);
                } else if (currentRole.equals("2")) {
                    nv = new Kho();
                    ((Kho)nv).ngaykiemkho = parts[7]; 
                    nv.manv = maNV;
                    nv.tennv = tenNV;
                    nv.ngaysinhnv = ngaySinhNV;
                    nv.sdtnv = sdtNV;
                    nv.diachinv = diaChiNV;
                    nv.luong = luongNV;
                   
                    DSNhanVien.DSNhanVien.add(nv);
                } else if (currentRole.equals("3")) {
                    nv = new BaoVe();
                    ((BaoVe)nv).catruc = parts[7];
                    nv.manv = maNV;
                    nv.tennv = tenNV;
                    nv.ngaysinhnv = ngaySinhNV;
                    nv.sdtnv = sdtNV;
                    nv.diachinv = diaChiNV;
                    nv.luong = luongNV;
                   
                    DSNhanVien.DSNhanVien.add(nv);
                }            
            }   
            System.out.println("Doc file thanh cong!");
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 
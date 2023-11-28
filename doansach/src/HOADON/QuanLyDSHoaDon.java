package HOADON;

import java.util.ArrayList;
import java.util.Scanner;

import SACH.*;
import NHANVIEN.*;

public class QuanLyDSHoaDon{
    public DSHoaDon dsHoaDon;

    public QuanLyDSHoaDon (){
        dsHoaDon = new DSHoaDon();
    }
    public void Menu(){
        int lua_chon=0;
        boolean flag = true;
        while(flag){
            Scanner sc =new Scanner(System.in);
            System.out.println(" 1)Them hoa don\n 2)Xuat danh sach hoa don\n 3)Quay lai\n 4)Thoat");
            System.out.print("Lua chon: "); 
            lua_chon=sc.nextInt();
            switch (lua_chon) {
                case 1:
                    dsHoaDon.them();
                    break;
                case 2:
                    dsHoaDon.xuat();
                    break;
                case 3:
                    flag = false;
                    dsHoaDon.WriteFile();
                    break;
                case 4:
                    dsHoaDon.WriteFile();
                    System.exit(0);
            }
        }
    }
}


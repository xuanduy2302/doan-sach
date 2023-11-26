import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

    class DSKHACHHANG {//implement interface
    private static ArrayList<KHACHHANG> DSKH;//danh sách mảng
    public DSKHACHHANG(){//khởi tạo
        DSKH= new ArrayList<KHACHHANG>();
    }
    Scanner sc=new Scanner(System.in);
   
    public void them(){//thêm khách hàng vào list
        int choose=0;
        boolean flag=true;//biến cờ để lặp lại cho đến khi nhận biến choose là kiểu int
        System.out.println("Vui long lua chon hinh thuc mua hang\n1:Mua truc tiep=>Khach hang thuong xuyen\n2:Mua Online=>Khach hang online");
        
        while(flag){
            if(sc.hasNextInt()){//dòng tiếp theo nhập vào là 1 số nguyên
               choose=sc.nextInt();
               if(choose==1 || choose==2)
                    flag=false;
                else{
                    System.out.println("nhap sai thong tin");
                    System.out.println("Vui long lua chon hinh thuc mua hang\n1:Mua truc tiep=>Khach hang thuong xuyen\n2:Mua Online=>Khach hang online");
                }
            }
            else{
                System.out.println("vui long nhap so nguyen");
                sc.next();//không phải số nguyên nên đẩy đi tiếp vòng while luôn,loại dữ liệu nhập vào ra khỏi scanner
            }
        }
        sc.nextLine();
        if(choose==1){
            KHACHHANG x= new KHACHHANGTX();
            x.nhap();
            DSKH.add(x);
        }
        else if(choose==2){
            KHACHHANG x= new KHACHHANGONLINE();
            x.nhap();
            DSKH.add(x);
        }
    }

    public void chinhsua(){//chỉnh sửa theo thong tin
        int choose=0;//chú ý khởi tạo trước khi sử dụng để check ở dưới
        String S_MA;
        System.out.println("\nNhap Ma Khach Hang can sua");
        S_MA=sc.nextLine();
        String s;
        boolean flag=true;
        for(KHACHHANG x :DSKH){

            if(x.Id.equals(S_MA)){
                if(x instanceof KHACHHANGTX){//x là khách hàng thường xuyên
                    System.out.print("\nChon muc can sua thong tin: \n1:Ma Khach Hang\n2:Ho ten\n3:Dia chi\n4:So dien thoai\n5:Diem tich luy\n");

                while(flag){
                    if(sc.hasNextInt()){
                        choose=sc.nextInt();
                    if(choose<=5 && choose>0)
                            flag=false;
                    else{
                        System.out.println("nhap sai thong tin");
                        System.out.print("\nChon muc can sua thong tin: \n1:Ma Khach Hang\n2:Ho ten\n3:Dia chi\n4:So dien thoai\n5:Diem tich luy\n");
                    }
                        }
                    else{
                        System.out.println("vui long nhap so nguyen");
                        sc.next();
                    }
                }
                sc.nextLine();

                    if(choose==1){
                        System.out.println("Nhap MA KH cap nhat");
                        s=sc.nextLine();
                        x.Id=s;
                    }
                    else if(choose==2){
                        System.out.println("Nhap HO TEN cap nhat");
                        s=sc.nextLine();
                        x.Name=s;
                    }
                    else if(choose==3){
                        System.out.println("Nhap DIA CHI cap nhat");
                        s=sc.nextLine();
                        x.Address=s;
                    }
                    else if(choose==4){
                        System.out.println("Nhap SO DIEN THOAI cap nhat");
                        s=sc.nextLine();
                        x.Phone=s;
                    }
                    else if(choose==5){
                        System.out.println("Nhap DIEM TICH LUY cap nhat");
                        int k=0;
                        while(flag){
                            if(sc.hasNextInt()){
                                k=sc.nextInt();
                               if(k>0)
                                    flag=false;
                                else
                                    System.out.println("vui long nhap diem tich luy > 0");
                                }
                            else{
                                System.out.println("vui long nhap so nguyen");
                                sc.next();
                            }
                        }
                        sc.nextLine();
                        ((KHACHHANGTX)x).setDiemtichluy(k);
                    }
                }
                else if(x instanceof KHACHHANGONLINE){//x là khách hàng online
                    System.out.print("\nChon muc can sua thong tin: \n1:Ma Khach Hang\n2:Ho ten\n3:Dia chi\n4:So dien thoai\n5:Ma don hang\n6: Gmail\n");
                    choose=sc.nextInt();

                    while(flag){
                        if(sc.hasNextInt()){
                            choose=sc.nextInt();
                                if(choose<=6 && choose>0)
                                    flag=false;
                                else{
                                    System.out.println("nhap sai thong tin");
                                    System.out.print("\nChon muc can sua thong tin: \n1:Ma Khach Hang\n2:Ho ten\n3:Dia chi\n4:So dien thoai\n5:Ma don hang\n6: Gmail\n");
                                }
                        }
                        else{
                            System.out.println("vui long nhap so nguyen");
                            sc.next();
                        }
                    }

                    sc.nextLine();
                    if(choose==1){
                        System.out.println("Nhap MA KH cap nhat");
                        s=sc.nextLine();
                        x.Id=s;
                    }
                    else if(choose==2){
                        System.out.println("Nhap HO TEN cap nhat");
                        s=sc.nextLine();
                        x.Name=s;
                    }
                    else if(choose==3){
                        System.out.println("Nhap DIA CHI cap nhat");
                        s=sc.nextLine();
                        x.Address=s;
                    }
                    else if(choose==4){
                        System.out.println("Nhap SO DIEN THOAI cap nhat");
                        s=sc.nextLine();
                        x.Phone=s;
                    }
                    else if(choose==5){
                        System.out.println("Nhap MA DON HANG cap nhat");
                        ((KHACHHANGONLINE)x).setMadonhang(sc.nextLine());
                    }
                    else if(choose==6){
                        System.out.println("Nhap GMAIL cap nhat");
                        ((KHACHHANGONLINE)x).setGmail(sc.nextLine());
                    }
                }
            }
            
        }
    }

    public void xoa(){//xóa theo id khách hàng
        System.out.println("Nhap ID KHACH HANG can xoa");
        String S_MA=sc.nextLine();
        for(KHACHHANG x:DSKH){
            if(S_MA.equals(x.Id)){
                DSKH.remove(x);
                break;
            }
        }
    }

    public void timkiem(){//tìm kiếm theo ten khach hang
        System.out.println("Nhap TEN KHACH HANG muon tim");
            String S_NAME=sc.nextLine();
            boolean flag=false;
            for(KHACHHANG x:DSKH){
                 if(S_NAME.equals(x.Name)==true){
                    x.xuat();
                    flag=true;
                    break;
                }    
            }  
            if(flag)
                System.out.println("CO tim thay!!");
            else    
               System.out.println("KHONG tim thay!!");
    }

    public void xuat() {//xuất danh sách lưu trong list
        for(KHACHHANG x : DSKH){
            x.xuat();
        }
    }

    public static void luu() {//chia truong hop viet vao
        try {
            FileWriter fw = new FileWriter("DS-KH.txt");
            for (KHACHHANG x : DSKH) {
                if(x instanceof KHACHHANGTX)//READ AGAIN
                    fw.write(x.Id +"|"+x.Name+"|"+x.Address+"|"+x.Phone+"|"+((KHACHHANGTX)x).getDiemtichluy()+"\n");
                else if(x instanceof KHACHHANGONLINE)
                    fw.write(x.Id +"|"+x.Name+"|"+x.Address+"|"+x.Phone+"|"+((KHACHHANGONLINE)x).getMadonhang()+"|"+((KHACHHANGONLINE)x).getGmail()+"\n");
            }
            fw.close();
            System.out.println("Data saved to file.");
            }
             catch (Exception e) {
                System.out.println(e);
            }
    }

    public static void doc() {
            DSKH.clear();
        try (BufferedReader input = new BufferedReader(new FileReader("DS-KH.txt"))) {
            String line = input.readLine();
            while (line != null) {
                String[] parts = line.split("\\|");
                KHACHHANG y=new KHACHHANG();

                if (parts.length == 5) {
                    y = new KHACHHANGTX();
                    ((KHACHHANGTX) y).setDiemtichluy(Integer.parseInt(parts[4]));
                }
                else if(parts.length==6){
                   y =new KHACHHANGONLINE();
                    ((KHACHHANGONLINE) y).setMadonhang(parts[4]);
                    ((KHACHHANGONLINE) y).setGmail(parts[5]);  
                }
                y.Id=parts[0];
                y.Name=parts[1];
                y.Address=parts[2];
                y.Phone=parts[3];
                DSKH.add(y);

                line = input.readLine();
            }
            System.out.println("Data loaded from file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


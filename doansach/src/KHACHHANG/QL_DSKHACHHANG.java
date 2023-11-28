import java.util.Scanner;

class QL_DSKHACHHANG {
    Scanner sc=new Scanner(System.in);
    public void menu(){
        int choose=0;
        boolean flag1=true;
        DSKHACHHANG x=new DSKHACHHANG();
            DSKHACHHANG.doc();//đọc file mỗi khi chạy hàm select 1 lần
            while(flag1){//menu
                boolean flag2=true;//lưu ý flag2 ở trong này mới đúng chứ ở ngoài khai báo với flag1 là bị loop ở x.them();
                System.out.println("\nCHON THAO TAC:\n1 Them moi\n2 Sua thong tin\n3 Tim kiem\n4 Xoa\n5 Hien thi danh sach\n6 Thoat");    
                while(flag2){
                    if(sc.hasNextInt()){
                        choose=sc.nextInt();
                    if(choose<=6 && choose>0)
                            flag2=false;
                        else{
                            System.out.println("nhap sai thong tin");
                            System.out.println("\nCHON THAO TAC:\n1 Them moi\n2 Sua thong tin\n3 Tim kiem\n4 Xoa\n5 Hien thi danh sach\n6 Thoat");
                        }     
                    }
                    else{
                        System.out.println("vui long nhap so nguyen");
                        sc.next();
                    }
                }
                sc.nextLine();
        
                switch (choose) {
                    case 1:
                        x.them();
                        break;
                    case 2:
                        x.sua();
                        break;
                    case 3:
                        x.timkiem();
                        break;
                    case 4:
                        x.xoa();
                        break;
                    case 5:
                        x.danhsach();
                        break;
                    case 6:
                        flag1=false;
                        //static nên gọi class và tên hàm khi thực hiện
                        DSKHACHHANG.luu();//lưu file sau khi thoát chương trình
                        break; 
                }       
            }
    }
}
import java.util.Scanner;
public class tetsss {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    boolean flag=true;
    while(flag){
        if(sc.hasNextInt()){//dòng tiếp theo nhập vào là 1 số nguyên
            int n=sc.nextInt();
            System.out.println("so vua nhap la"+n);
            flag=false;
        }
        else{
            System.out.println("vui long nhap so nguyen");
            sc.next();//không phải số nguyên nên đẩy đi tiếp vòng while luôn,loại dữ liệu nhập vào ra khỏi scanner
        }
    }
    sc.close();
    }
}

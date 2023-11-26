import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class KHACHHANGONLINE extends KHACHHANG{//kế thừa
    private String Madonhang;
    private String Gmail;
    Scanner sc=new Scanner(System.in);
    public KHACHHANGONLINE(){//khởi tạo
        super();
        Madonhang ="";
        Gmail="";
    }
    @Override
    public void nhap(){ 
            super.nhap();
            System.out.println("Nhap MA DON DAT HANG cua khach hang ");
                String m=sc.nextLine();
                setMadonhang(m);
            while(true){
                System.out.println("Nhap GMAIL cua khach hang");
                String k=sc.nextLine();
                if(checkmail(k)){
                     setGmail(k);
                    break;
                }
            }
        }
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("MA DON HANG : " + getMadonhang());
        System.out.println("GMAIL : " + getGmail());
        System.out.println("-----------------------------------------------------------------");
    }
    public void setMadonhang(String Madonhang){
        this.Madonhang=Madonhang;
    }
    public void setGmail(String Gmail){
        this.Gmail=Gmail;
    }
    public String getMadonhang(){
        return Madonhang;
    }
    public String getGmail(){
        return Gmail;
    }
    public boolean checkmail(String gmail){//Regular Expressions
        //String regex="^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]$";
        String regex="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        //[A-Za-z0-9+_.-] là a->z A->Z 0->9 dấu + - _ . đều hợp lệ
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(gmail);
        return matcher.find();
    }
}

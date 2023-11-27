package NhanVien;
public class App {
    public static void main(String[] args){
        QuanLyDSNhanVien qlnv = new QuanLyDSNhanVien();
        qlnv.ReadFile();
        qlnv.Menu();
        qlnv.WriteFile();
       
    }
}
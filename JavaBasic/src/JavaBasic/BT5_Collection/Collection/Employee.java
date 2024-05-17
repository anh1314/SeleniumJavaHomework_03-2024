package JavaBasic.BT5_Collection.Collection;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    public static void addNhanvien(List<NhanVien> nhanvien, String ten, int tuoi, double luong){
        NhanVien NV = new NhanVien(ten, tuoi, luong);
        nhanvien.add(NV);
    }
    public static void main(String[] args) {
        List<NhanVien> nhanvien = new ArrayList<>();
        addNhanvien(nhanvien, "Thu Nhi", 25, 1000000);
        addNhanvien(nhanvien, "Phong Vu", 26, 1200000);
        for ( int i = 0; i < nhanvien.size(); i++ ){
            System.out.println(nhanvien.get(i));
        }
    }
}

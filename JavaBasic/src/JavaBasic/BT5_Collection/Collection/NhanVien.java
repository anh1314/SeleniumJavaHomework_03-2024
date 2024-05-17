package JavaBasic.BT5_Collection.Collection;

class NhanVien { //class cha
    String ten; int tuoi; double luong;
    // Phương thức trong class con phải cùng cùng tên, cùng tham số
    public NhanVien(String ten, int tuoi, double luong) {  //class con
        this.ten = ten;
        this.tuoi = tuoi;
        this.luong = luong;
    }
    // Phương thức toString() được sử dụng để chuyển đổi đối tượng thành 1 chuỗi đại diện của nó
    //  Phương thức toString() được ghi đè (@Override) trong class NhanVien
    //  và trả về chuỗi chứa thông tin của đối tượng NhanVien
    @Override //ghi đè phương thức từ class cha trong class con
    public String toString() {
        return "Tên: " + ten + ", Tuổi: " + tuoi + ", Lương: " + luong;
    }
}

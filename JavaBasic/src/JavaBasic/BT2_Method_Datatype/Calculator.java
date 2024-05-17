package JavaBasic.BT2_Method_Datatype;

public class Calculator {
    public static int tongSoNguyen( int a, int b){
        return a + b;
    }
    public static double tongSoThuc( double c, double d ){
        return c + d;
    }
    public static void main(String[] args) {

        System.out.println("tong 2 so nguyen:" +tongSoNguyen(10,20));
        System.out.println("tong 2 so thuc:" +tongSoThuc(10.5, 15.76));

    }
}

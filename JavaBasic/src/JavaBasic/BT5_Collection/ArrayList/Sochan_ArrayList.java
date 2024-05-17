package JavaBasic.BT5_Collection.ArrayList;
import java.util.ArrayList;

public class Sochan_ArrayList {
    public static void main(String[] args) {

       ArrayList<Integer> arrayList = new ArrayList<>();
        for ( int i = 0; i <= 50; i++ ){
            if (i % 2 ==0 ){
                arrayList.add(i);
            }
        }
        System.out.println("Mảng số chẵn:" +arrayList);
    }
}

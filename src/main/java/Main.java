import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String... args) {
//        try {
            HashMap<Material, ArrayList<DetailItem>> data = Parser.parse("бахалдсп.xlsx");
            for (DetailItem i:data.get(Material.LDSP)){
                System.out.println(i);
            }
            DataWriter q = new DataWriter(data.get(Material.LDSP), "баха2лдсп.txt");
            q.print();
//        } catch ( NullPointerException e){
//            System.out.println(e.getMessage());
//        }



    }

}

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String... args) {
//        try {
        StringBuilder file = new StringBuilder("зеленый остров");
            HashMap<Material, ArrayList<DetailItem>> data = Parser.parse(file + ".xlsx");
//            for (DetailItem i:data.get(Material.LDSP)){
//                System.out.println(i);
//            }
            DataWriter ldsp = new DataWriter(data.get(Material.LDSP), file+"_лдсп.txt");
            if (data.get(Material.STEKLO).size()!=0) {
                DataWriter steklo = new DataWriter(data.get(Material.STEKLO), file+"_стекло.txt");
            }
            if (data.get(Material.DVPO).size()!=0) {
                DataWriter dvpo = new DataWriter(data.get(Material.DVPO), file+"_двпо.txt");
            }


//            ldsp.print();
//        } catch ( NullPointerException e){
//            System.out.println(e.getMessage());
//        }



    }

}

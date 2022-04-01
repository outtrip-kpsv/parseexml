import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String... args) throws IOException {
        HashMap<Material, ArrayList<DetailItem>> data = Parser.parse("5.xlsx");

        for (DetailItem i:data.get(Material.LDSP)){
            System.out.println(i);
        }
        DataWriter q = new DataWriter(data.get(Material.LDSP));
        q.print();
    }

}

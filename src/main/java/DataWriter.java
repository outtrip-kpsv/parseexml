import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class DataWriter {
    private final StringBuilder data = new StringBuilder();


    public DataWriter(ArrayList<DetailItem> detailItems) {
        for (DetailItem i : detailItems) {
            data.append(i.getName())
                    .append("\t")
                    .append(i.getHeight())
                    .append("\t")
                    .append(i.getK1())
                    .append(i.getK2())
                    .append("\t")
                    .append(i.getWidth())
                    .append("\t")
                    .append(i.getK3())
                    .append(i.getK4())
                    .append("\t")
                    .append("")
                    .append("\t")
                    .append(i.getQuantity())
                    .append("\t")
                    .append("\t")
                    .append("\t")
                    .append("\t")
                    .append("\n");
        }
        try (PrintWriter writer = new PrintWriter("notes.txt", "Cp1251")) {

            String encode = new String(data);
            writer.write(String.valueOf(data));
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void print() {
        System.out.println(data);
    }
}

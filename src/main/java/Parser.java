import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Parser {

    public static HashMap<Material, ArrayList<DetailItem>> parse(String name) {

        HashMap<Material, ArrayList<DetailItem>> data = new HashMap<>();
        data.put(Material.LDSP, new ArrayList<>());
        data.put(Material.DVPO, new ArrayList<>());
        data.put(Material.STEKLO, new ArrayList<>());
        data.put(Material.OTHER, new ArrayList<>());
        InputStream in;
        XSSFWorkbook wb = null;
        try {
            in = new FileInputStream(name);
            wb = new XSSFWorkbook(in);

        } catch (IOException e) {
            e.printStackTrace();
        }

        assert wb != null;
        Sheet sheet = wb.getSheetAt(0);
        for (Row row : sheet) {
            System.out.println(row.getCell(1).getStringCellValue());

                switch (row.getCell(10).getStringCellValue()) {
                    case "ЛДСП" -> data.get(Material.LDSP).add(new DetailItem(row));
                    case "ДВПО" -> data.get(Material.DVPO).add(new DetailItem(row));
                    case "Стекло" -> data.get(Material.STEKLO).add(new DetailItem(row));
                    default -> data.get(Material.OTHER).add(new DetailItem(row));
                }

        }

        return data;
    }

}
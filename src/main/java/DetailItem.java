import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class DetailItem {
    private final String name;
    private final int height;
    private final int width;
    private final int depth;
    private final Border k1;
    private final Border k2;
    private final Border k3;
    private final Border k4;
    private final int quantity;
    private final int texture;

    public DetailItem(Row row){
        this.name = row.getCell(1).getStringCellValue();

        this.height = (int) row.getCell(2).getNumericCellValue();
        this.width = (int) row.getCell(5).getNumericCellValue();
        this.depth = (int) row.getCell(8).getNumericCellValue();
        this.k1 = borderGet(row.getCell(3));
        this.k2 = borderGet(row.getCell(4));
        this.k3 = borderGet(row.getCell(6));
        this.k4 = borderGet(row.getCell(7));
        this.quantity = (int) row.getCell(9).getNumericCellValue();
        this.texture = (int) row.getCell(12).getNumericCellValue();
//        this.laminate = row.getCell(11).getStringCellValue();
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

//    public int getDepth() {
//        return depth;
//    }


    public int getTexture() {
        return texture;
    }

    public String getK1() {
        return borderChar(k1);
    }

    public String getK2() {
        return borderChar(k2);
    }

    public String getK3() {
        return borderChar(k3);
    }

    public String getK4() {
        return borderChar(k4);
    }

    public int getQuantity() {
        return quantity;
    }

    private String borderChar(Border k){
        return switch (k) {
            case K04 -> "/";
            case K20 -> "\\";
            case K0 -> "";
        };
    }

    @Override
    public String toString() {
        return "DetailItem{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                ", k1=" + k1 +
                ", k2=" + k2 +
                ", k3=" + k3 +
                ", k4=" + k4 +
                ", quantity=" + quantity +

                '}';
    }

    private Border borderGet(Cell i){
        Double tmp;
        try {
            tmp = i.getNumericCellValue();
        } catch (IllegalStateException e){

            switch (i.getStringCellValue()){
                case "0,4" -> tmp = 0.4;
                case "2" -> tmp = 2.0;
                default -> tmp = 0.0;
            }
        }

        if (tmp.equals(0.4)){
            return Border.K04;
        }
        if(tmp.equals(2.0)){
            return Border.K20;
        }
        else{
            return Border.K0;
        }
    }
}

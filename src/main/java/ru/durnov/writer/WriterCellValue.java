package ru.durnov.writer;

import org.odftoolkit.odfdom.doc.table.OdfTableCell;

public class WriterCellValue {
    private final OdfTableCell odfTableCell;
    private final Object dataCell;

    public WriterCellValue(OdfTableCell odfTableCell, Object dataCell) {
        this.odfTableCell = odfTableCell;
        this.dataCell = dataCell;
    }

    public void setCellValue() {
        String value = new CellValue(dataCell).value();
        odfTableCell.setDisplayText(value, "P26");
    }
}

class CellValue {
    private final Object dataCell;

    public CellValue(Object dataCell) {
        this.dataCell = dataCell;

    }

    public String value() {
        if (dataCell instanceof Double){
            String result = String.valueOf(dataCell);
            if (result.endsWith(".0")){
                result = result.substring(0,result.length()-2);
            }
            return result.replace(".", ",");
        }
        return String.valueOf(dataCell);
    }
}

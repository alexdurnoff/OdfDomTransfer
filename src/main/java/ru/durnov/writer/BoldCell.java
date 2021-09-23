package ru.durnov.writer;

import org.odftoolkit.odfdom.doc.table.OdfTableRow;

public class BoldCell {
    private final OdfTableRow odfTableRow;
    private final Object[] dataRow;

    public BoldCell(OdfTableRow odfTableRow, Object[] dataRow) {
        this.odfTableRow = odfTableRow;
        this.dataRow = dataRow;
    }

    public void writePanelHeaderValue() {
        odfTableRow.getCellByIndex(1).setDisplayText(String.valueOf(dataRow[1]), "Заголовок_щита");
    }
}

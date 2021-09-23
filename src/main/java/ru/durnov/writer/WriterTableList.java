package ru.durnov.writer;

import org.odftoolkit.odfdom.doc.OdfDocument;
import org.odftoolkit.odfdom.doc.table.OdfTable;
import org.odftoolkit.odfdom.doc.table.OdfTableCell;
import org.odftoolkit.odfdom.doc.table.OdfTableRow;

import java.util.List;

public class WriterTableList {
    private final List<OdfTable> odfTableList;

    public WriterTableList(OdfDocument odfDocument) {
        this.odfTableList = odfDocument.getTableList();
    }

    public OdfTable getTableByName(String protocolName) {
        String rootstring = new TableName(protocolName).tableSearchString();
        for (OdfTable odfTable : odfTableList) {
            List<OdfTableRow> rowList = odfTable.getRowList();
            for (OdfTableRow odfTableRow : rowList) {
                int count = odfTableRow.getCellCount();
                for (int i = 0; i < count; i++){
                    OdfTableCell odfTableCell = odfTableRow.getCellByIndex(i);
                    if (odfTableCell.getStringValue().equals(rootstring)){
                        return odfTable;
                    }
                }
            }
        }
        throw new IllegalStateException("Не найдена таблица " + protocolName);
    }
}

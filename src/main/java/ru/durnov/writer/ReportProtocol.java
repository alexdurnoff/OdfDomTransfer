package ru.durnov.writer;

import org.odftoolkit.odfdom.doc.OdfDocument;
import org.odftoolkit.odfdom.doc.table.OdfTable;
import org.odftoolkit.odfdom.doc.table.OdfTableCell;
import org.odftoolkit.odfdom.doc.table.OdfTableRow;


public class ReportProtocol implements Protocol{
    private final OdfTable odfTable;

    public ReportProtocol(OdfTable odfTable) {
        this.odfTable = odfTable;
    }

    public ReportProtocol(OdfDocument odfDocument, String protocolName) {
        this.odfTable = new WriterTableList(odfDocument).getTableByName(protocolName);
    }


    @Override
    public void copyData(Object[][] data) {
        for (Object[] dataRow : data) {
            OdfTableRow odfTableRow = odfTable.appendRow();
            HeaderPanel headerPanel = new HeaderPanel(dataRow);
            if (headerPanel.isHeader()){
                new BoldCell(odfTableRow, dataRow).writePanelHeaderValue();
            } else {
                for (int i = 0; i < dataRow.length; i++){
                    OdfTableCell odfTableCell = odfTableRow.getCellByIndex(i);
                    new WriterCellValue(odfTableCell, dataRow[i]).setCellValue();
                }
            }
        }
    }
}

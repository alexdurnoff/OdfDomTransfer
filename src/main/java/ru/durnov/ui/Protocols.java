package ru.durnov.ui;

import com.sun.star.comp.helper.BootstrapException;
import com.sun.star.uno.Exception;
import org.odftoolkit.odfdom.doc.OdfDocument;
import ru.durnov.spreadsheet.ReportTemplate;
import ru.durnov.writer.ReportProtocol;


public class Protocols {
    private final String[] args;
    private final OdfDocument odfDocument;


    public Protocols(OdfDocument odfDocument, String[] args) {
        this.odfDocument = odfDocument;
        this.args = args;
    }

    public void copyData() throws BootstrapException, Exception {
        for (String str : args) {
            System.out.println(str);
            new ReportProtocol(odfDocument, str).copyData(
                    new ReportTemplate(str).data()
            );
        }
    }
}

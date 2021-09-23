import org.junit.jupiter.api.Test;
import org.odftoolkit.odfdom.doc.OdfDocument;

import java.io.File;

public class TestOdfDocument {

    @Test
    public void testOpenDocument() throws Exception {
        OdfDocument odfDocument = OdfDocument.loadDocument(new File("/home/alexej/Yandex.Disk/Работа/Ордынка/Отчет 1-й этаж/Отчет 1-й этаж копия (копия).odt"));
        odfDocument.getTableList().forEach(odfTable -> {
            System.out.println(odfTable.getTableName());
        });
    }
}

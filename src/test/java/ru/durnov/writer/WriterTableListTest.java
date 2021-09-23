package ru.durnov.writer;

import org.junit.jupiter.api.*;
import org.odftoolkit.odfdom.doc.OdfDocument;
import org.odftoolkit.odfdom.doc.table.OdfTable;

import java.io.File;

class WriterTableListTest {
    private final File file = new File("TestFiles/Отчет ИП Палагин.odt");
    private static OdfDocument odfDocument;

    @BeforeEach
    void setUpDocument() throws Exception {
        this.odfDocument = OdfDocument.loadDocument(file);
    }

    @AfterEach
    void closeDocument(){
        this.odfDocument.close();
    }

    @Test
    void testIsolationTableMustBeFound() {
        WriterTableList writerTableList = new WriterTableList(odfDocument);
        OdfTable table = writerTableList.getTableByName("Изоляция");
        String tableName = table.getTableName();
        Assertions.assertEquals(tableName, "Таблица8");
    }

    @Test
    void testLoopTableMustBeFound() {
        WriterTableList writerTableList = new WriterTableList(odfDocument);
        OdfTable table = writerTableList.getTableByName("Петля");
        String tableName = table.getTableName();
        Assertions.assertEquals(tableName, "Таблица6");
    }

    @Test
    void testUZOTableMustBeFound() {
        WriterTableList writerTableList = new WriterTableList(odfDocument);
        OdfTable table = writerTableList.getTableByName("УЗО");
        String tableName = table.getTableName();
        Assertions.assertEquals(tableName, "Таблица10");
    }

    @Test
    void testBreakerTableMustBeFound() {
        WriterTableList writerTableList = new WriterTableList(odfDocument);
        OdfTable table = writerTableList.getTableByName("Автомат");
        String tableName = table.getTableName();
        Assertions.assertEquals(tableName, "Таблица12");
    }

    @Test
    void testBindTableMustBeFound() {
        WriterTableList writerTableList = new WriterTableList(odfDocument);
        OdfTable table = writerTableList.getTableByName("Связь");
        String tableName = table.getTableName();
        Assertions.assertEquals(tableName, "Таблица2");
    }

}
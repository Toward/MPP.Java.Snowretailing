package shlackAndCo.snowretailing.core.documentGenerators;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.documents.IDocumentGenerator;
import shlackAndCo.snowretailing.core.contracts.models.ICredentialModel;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentModel;
import shlackAndCo.snowretailing.core.contracts.models.IRentReadModel;

import java.io.OutputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("XLSgenerator")
public class XLSgenerator implements IDocumentGenerator {
    short borderColor = IndexedColors.BLACK.getIndex();

    private final static DateTimeFormatter DTF_FOR_DATE = org.joda.time.format.DateTimeFormat.forPattern("dd.MM.YYYY");
    private final static DateTimeFormatter DTF_FOR_TIMESTAMP = org.joda.time.format.DateTimeFormat.forPattern("HH:mm dd.MM.YYYY");


    @Override
    public OutputStream generateEquipmentsListDocument(OutputStream os, Collection<IEquipmentModel> equipments) {
        List<IEquipmentModel> equipmentsList = new ArrayList<>(equipments);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Полный список горнолыжного оборудования");
        int rowNum = 0;


        Row headerRow = sheet.createRow(rowNum++);
        headerRow.setHeightInPoints(40);
        Cell cell = headerRow.createCell(0);
        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$H$1"));

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 20);
        CellStyle style = workbook.createCellStyle();

        style.setFont(headerFont);
        setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
        cell.setCellValue("Полный список горнолыжного оборудования");
        cell.setCellStyle(style);
        rowNum++;

        style = workbook.createCellStyle();
        setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
        setBordersToCellStyle(true,true,true,true,style,borderColor);
        Row listRow = sheet.createRow(rowNum);
        createCellWithValue(listRow, " ", 0,style);
        createCellWithValue(listRow, "Бренд", 1,style);
        createCellWithValue(listRow, "Модель", 2,style);
        createCellWithValue(listRow, "Тип", 3,style);
        createCellWithValue(listRow, "Всего", 4,style);
        createCellWithValue(listRow, "Доступно", 5,style);

        style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setWrapText(true);
        rowNum++;
        for(int i =0; i < equipmentsList.size(); i++){
            Row row = sheet.createRow(rowNum++);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,equipmentsList.size()-1,style);
            createCellWithValue(row, String.valueOf(i+1),0,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,equipmentsList.size()-1,style);
            createCellWithValue(row, equipmentsList.get(i).getBrandName(), 1,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,equipmentsList.size()-1,style);
            createCellWithValue(row, equipmentsList.get(i).getModel(),2,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,equipmentsList.size()-1,style);
            createCellWithValue(row,equipmentsList.get(i).getName().getValue() ,3,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,equipmentsList.size()-1,style);
            createCellWithValue(row, String.valueOf(equipmentsList.get(i).getEquipmentItemCount()),4,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,equipmentsList.size()-1,style);
            createCellWithValue(row, String.valueOf(equipmentsList.get(i).getQuantity()),5,style);
        }

        sheet.setColumnWidth(0, 256*15);
        sheet.setColumnWidth(1, 256*15);
        sheet.setColumnWidth(2, 256*15);
        sheet.setColumnWidth(3, 256*15);
        sheet.setColumnWidth(4, 256*15);
        sheet.setColumnWidth(5, 256*15);

        output(os,workbook);
        return os;
    }

    @Override
    public OutputStream generateClientsListDocument(OutputStream os, Collection<ICredentialModel> credentials) {
        List<ICredentialModel> credentialsList = new ArrayList<>(credentials);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Полный список клиентов");
        int rowNum = 0;


        Row headerRow = sheet.createRow(rowNum++);
        headerRow.setHeightInPoints(40);
        Cell cell = headerRow.createCell(0);
        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$H$1"));

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 20);
        CellStyle style = workbook.createCellStyle();

        style.setFont(headerFont);
        setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
        cell.setCellValue("Полный список клиентов");
        cell.setCellStyle(style);
        rowNum++;

        style = workbook.createCellStyle();
        setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
        setBordersToCellStyle(true,true,true,true,style,borderColor);
        Row listRow = sheet.createRow(rowNum);
        createCellWithValue(listRow, " ", 0,style);
        createCellWithValue(listRow, "ФИО", 1,style);
        createCellWithValue(listRow, "День рождения", 2,style);
        createCellWithValue(listRow, "Тип", 3,style);
        createCellWithValue(listRow, "Серия и Номер", 4,style);
        createCellWithValue(listRow, "Личный номер", 5,style);
        createCellWithValue(listRow, "Дата выдачи", 6,style);
        createCellWithValue(listRow, "Агенство", 7,style);

        style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setWrapText(true);
        rowNum++;
        for(int i =0; i < credentialsList.size(); i++){
            Row row = sheet.createRow(rowNum++);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,credentialsList.size()-1,style);
            createCellWithValue(row, String.valueOf(i+1),0,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.LEFT,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,credentialsList.size()-1,style);
            createCellWithValue(row,  credentialsList.get(i).getSurname() + " " + credentialsList.get(i).getName() +" "+ credentialsList.get(i).getPatronymyc(), 1,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,credentialsList.size()-1,style);
            createCellWithValue(row, formatDate(credentialsList.get(i).getBirthday()),2,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,credentialsList.size()-1,style);
            createCellWithValue(row, credentialsList.get(i).getType(),3,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,credentialsList.size()-1,style);
            createCellWithValue(row, credentialsList.get(i).getSeries() + " " + credentialsList.get(i).getNumber(),4,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,credentialsList.size()-1,style);
            createCellWithValue(row, credentialsList.get(i).getIdentifier(),5,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,credentialsList.size()-1,style);
            createCellWithValue(row, formatDate(credentialsList.get(i).getDate(), DTF_FOR_DATE),6,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,credentialsList.size()-1,style);
            createCellWithValue(row,credentialsList.get(i).getAgency()  ,7,style);
        }

        sheet.setColumnWidth(0, 256*15);
        sheet.setColumnWidth(1, 256*15);
        sheet.setColumnWidth(2, 256*15);
        sheet.setColumnWidth(3, 256*15);
        sheet.setColumnWidth(4, 256*15);
        sheet.setColumnWidth(5, 256*15);
        sheet.setColumnWidth(6, 256*15);
        sheet.setColumnWidth(7, 256*15);

        output(os,workbook);
        return os;
    }

    @Override
    public OutputStream generateEquipmentsCostsDocument(OutputStream os, Collection<IEquipmentModel> equipments) {
        List<IEquipmentModel> equipmentsList = new ArrayList<>(equipments);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Наименования горнолыжного оборудования с расценками");
        int rowNum = 0;


        Row headerRow = sheet.createRow(rowNum++);
        headerRow.setHeightInPoints(40);
        Cell cell = headerRow.createCell(0);
        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$H$1"));

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 20);
        CellStyle style = workbook.createCellStyle();

        style.setFont(headerFont);
        setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
        cell.setCellValue("Наименования горнолыжного оборудования с расценками");
        cell.setCellStyle(style);
        rowNum++;

        style = workbook.createCellStyle();
        setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
        setBordersToCellStyle(true,true,true,true,style,borderColor);
        Row listRow = sheet.createRow(rowNum);
        createCellWithValue(listRow, " ", 0,style);
        createCellWithValue(listRow, "Бренд", 1,style);
        createCellWithValue(listRow, "Модель", 2,style);
        createCellWithValue(listRow, "Тип", 3,style);
        createCellWithValue(listRow, "Цена", 4,style);

        style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setWrapText(true);
        rowNum++;
        for(int i =0; i < equipmentsList.size(); i++){
            Row row = sheet.createRow(rowNum++);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,equipmentsList.size()-1,style);
            createCellWithValue(row, String.valueOf(i+1),0,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,equipmentsList.size()-1,style);
            createCellWithValue(row, equipmentsList.get(i).getBrandName(), 1,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,equipmentsList.size()-1,style);
            createCellWithValue(row, equipmentsList.get(i).getModel() ,2,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,equipmentsList.size()-1,style);
            createCellWithValue(row, equipmentsList.get(i).getName().getValue(),3,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,equipmentsList.size()-1,style);
            createCellWithValue(row, String.valueOf(equipmentsList.get(i).getCost()),4,style);
        }

        sheet.setColumnWidth(0, 256*15);
        sheet.setColumnWidth(1, 256*15);
        sheet.setColumnWidth(2, 256*15);
        sheet.setColumnWidth(3, 256*15);
        sheet.setColumnWidth(4, 256*15);

        output(os,workbook);
        return os;
    }

    @Override
    public OutputStream generateEquipmentsItemHistoryDocument(OutputStream os, Collection<IRentReadModel> rents) {
        List<IRentReadModel> rentsList = new ArrayList<>(rents);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("История оборудования");
        int rowNum = 0;


        Row headerRow = sheet.createRow(rowNum++);
        headerRow.setHeightInPoints(40);
        Cell cell = headerRow.createCell(0);
        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$H$1"));

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 20);
        CellStyle style = workbook.createCellStyle();

        style.setFont(headerFont);
        setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
        cell.setCellValue("История оборудования");
        cell.setCellStyle(style);
        rowNum++;

        style = workbook.createCellStyle();
        setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
        setBordersToCellStyle(true,true,true,true,style,borderColor);
        Row listRow = sheet.createRow(rowNum);
        createCellWithValue(listRow, " ", 0,style);
        createCellWithValue(listRow, "Клиент", 1,style);
        createCellWithValue(listRow, "Дата выдачи", 2,style);
        createCellWithValue(listRow, "Дата возврата", 3,style);


        style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setWrapText(true);
        rowNum++;
        for(int i =0; i < rentsList.size(); i++){
            Row row = sheet.createRow(rowNum++);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,rentsList.size()-1,style);
            createCellWithValue(row, String.valueOf(i+1),0,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.LEFT,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,rentsList.size()-1,style);
            createCellWithValue(row, rentsList.get(i).getCredential().getSurname() + " " + rentsList.get(i).getCredential().getName() + " " + rentsList.get(i).getCredential().getPatronymyc() , 1,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,rentsList.size()-1,style);
            createCellWithValue(row, formatDate(rentsList.get(i).getDateGet(), DTF_FOR_TIMESTAMP),2,style);

            style = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
            setLastTableCellBorder(i,rentsList.size()-1,style);
            createCellWithValue(row, formatDate(rentsList.get(i).getDateFactReturn(), DTF_FOR_TIMESTAMP),3,style);
        }

        sheet.setColumnWidth(0, 256*15);
        sheet.setColumnWidth(1, 256*15);
        sheet.setColumnWidth(2, 256*15);
        sheet.setColumnWidth(3, 256*15);

        output(os,workbook);
        return os;
    }

    @Override
    public OutputStream generateRentDocument(OutputStream os, IRentReadModel rent) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Договор");
        int rowNum = 0;


        Row headerRow = sheet.createRow(rowNum++);
        headerRow.setHeightInPoints(40);
        Cell cell = headerRow.createCell(0);
        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$H$1"));

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 20);
        CellStyle style = workbook.createCellStyle();

        style.setFont(headerFont);
        setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
        cell.setCellValue("Договор");
        cell.setCellStyle(style);
        rowNum++;

        style = workbook.createCellStyle();
        setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
        setBordersToCellStyle(true,true,true,true,style,borderColor);
        Row listRow = sheet.createRow(rowNum);
        createCellWithValue(listRow, " ", 0,style);
        createCellWithValue(listRow, "ФИО", 1,style);
        createCellWithValue(listRow, "Тип документа", 2,style);
        createCellWithValue(listRow, "Серия и номер", 3,style);
        createCellWithValue(listRow, "Инвентарный номер оборудования", 4,style);
        createCellWithValue(listRow, "Дата выдачи", 5,style);
        createCellWithValue(listRow, "Дата предполагаемого возврата", 6,style);

        style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setWrapText(true);
        rowNum++;

        Row row = sheet.createRow(rowNum++);

        style = workbook.createCellStyle();
        setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
        setLastTableCellBorder(0,0,style);
        createCellWithValue(row, String.valueOf(1),0,style);



        style = workbook.createCellStyle();
        setAligmentToCellStyle(HorizontalAlignment.LEFT,VerticalAlignment.CENTER,style);
        setLastTableCellBorder(0,0,style);
        createCellWithValue(row, rent.getCredential().getSurname() + " " + rent.getCredential().getName() + " " + rent.getCredential().getPatronymyc() , 1,style);

        style = workbook.createCellStyle();
        setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
        setLastTableCellBorder(0,0,style);
        createCellWithValue(row, rent.getCredential().getType(),2,style);

        style = workbook.createCellStyle();
        setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
        setLastTableCellBorder(0,0,style);
        createCellWithValue(row, rent.getCredential().getSeries() + " " + rent.getCredential().getNumber(),3,style);


        style = workbook.createCellStyle();
        setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
        setLastTableCellBorder(0,0,style);
        createCellWithValue(row, rent.getEquipmentItem().getInventory_number() ,4,style);

        style = workbook.createCellStyle();
        setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
        setLastTableCellBorder(0,0,style);
        createCellWithValue(row,formatDate(rent.getDateGet(), DTF_FOR_TIMESTAMP) ,5,style);

        style = workbook.createCellStyle();
        setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,style);
        setLastTableCellBorder(0, 0,style);
        createCellWithValue(row,formatDate(rent.getDateExpectedReturn(), DTF_FOR_TIMESTAMP),6,style);

        sheet.setColumnWidth(0, 256*15);
        sheet.setColumnWidth(1, 256*15);
        sheet.setColumnWidth(2, 256*15);
        sheet.setColumnWidth(3, 256*15);
        sheet.setColumnWidth(4, 256*15);
        sheet.setColumnWidth(5, 256*15);
        sheet.setColumnWidth(6, 256*15);

        output(os,workbook);
        return os;
    }

    private String formatDate(Date date) {
        return DTF_FOR_DATE.print(date.getTime());
    }

    private String formatDate(Timestamp date, DateTimeFormatter dtf) {
        return dtf.print(date.getTime());
    }


    private void fillTableWithEmptyValue(XSSFWorkbook workbook, int tableSize, Row row){
        for (int j = 0; j < tableSize; j++){
            CellStyle emptyStyle = workbook.createCellStyle();
            setAligmentToCellStyle(HorizontalAlignment.CENTER,VerticalAlignment.CENTER,emptyStyle);
            setBordersToCellStyle(true,true,true,true,emptyStyle,borderColor);
            createCellWithValue(row,"",j + 1,emptyStyle);
        }
    }
    private void setLastTableCellBorder(int i, int size,CellStyle style){
        if(i != size){
            setBordersToCellStyle(false,false,true,true,style,borderColor);
        }else {
            setBordersToCellStyle(false,true,true,true,style,borderColor);
        }
    }

    private void setBordersToCellStyle(boolean top,boolean bottom, boolean left,boolean right, CellStyle style,short borderColor){
        if(top){
            style.setBorderTop(BorderStyle.THIN);
            style.setTopBorderColor(borderColor);
        }
        if(bottom){
            style.setBorderBottom(BorderStyle.THIN);
            style.setBottomBorderColor(borderColor);
        }
        if(left){
            style.setBorderLeft(BorderStyle.THIN);
            style.setLeftBorderColor(borderColor);
        }
        if(right){
            style.setBorderRight(BorderStyle.THIN);
            style.setRightBorderColor(borderColor);
        }
    }

    private void setAligmentToCellStyle(HorizontalAlignment horizontalAlignment,VerticalAlignment verticalAlignment, CellStyle style){
        style.setAlignment(horizontalAlignment);
        style.setVerticalAlignment(verticalAlignment);
    }

    private void createCellWithValue(Row row, String title, int cellNum, CellStyle style){
        Cell cell = row.createCell(cellNum);
        cell.setCellValue(title);
        cell.setCellStyle(style);
    }

    private void output(OutputStream os,XSSFWorkbook workbook){
        try {
            workbook.write(os);
            workbook.close();
        }
        catch (Exception e){

        }
    }
}

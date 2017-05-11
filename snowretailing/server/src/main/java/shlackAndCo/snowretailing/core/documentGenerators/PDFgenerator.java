package shlackAndCo.snowretailing.core.documentGenerators;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.documents.IDocumentGenerator;
import shlackAndCo.snowretailing.core.contracts.models.ICredentialModel;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentModel;
import shlackAndCo.snowretailing.core.contracts.models.IRentReadModel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Collection;

@Service("PDFGenerator")
public class PDFGenerator implements IDocumentGenerator {

    @Override
    public OutputStream generateEquipmentsListDocument(OutputStream os, Collection<IEquipmentModel> equipments) throws DocumentException {
        return null;
    }

    @Override
    public OutputStream generateClientsListDocument(OutputStream os, Collection<ICredentialModel> equipments) {
        return null;
    }

    @Override
    public OutputStream generateEquipmentsCostsDocument(OutputStream os, Collection<IEquipmentModel> equipments)
            throws Exception {
        Document document = createDocument(os);
        document.open();
        document.add(new Paragraph("Прейскурант", createFont()));
        addItemsInPriceList(document,equipments);
        document.close();
        return os;
    }

    @Override
    public OutputStream generateEquipmentsItemHistoryDocument(OutputStream os, Collection<IRentReadModel> rents) {
        return null;
    }

    @Override
    public OutputStream generateRentDocument(OutputStream os, IRentReadModel rent) throws DocumentException {
//        Document document = createDocument(os);
//        document.open();
//        document.add(new Paragraph(MessageFormat.format("Договор",font)));
//        document.close();
//        return os;
        return null;
    }

    private Font createFont ()
            throws Exception {
        BaseFont baseFont = BaseFont.createFont("c:/Windows/Fonts/arial.ttf", "CP1251", BaseFont.EMBEDDED);
        Font font = new Font(baseFont, 10, Font.NORMAL);
        return font;
    }

    private Document createDocument(OutputStream os) throws DocumentException {
        Document doc = new Document();
        PdfWriter writer = PdfWriter.getInstance(doc, os);
        writer.setPageEvent(new Watermark());
        writer.setEncryption("".getBytes(), "".getBytes(), PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
        return doc;
    }

    private void addWatermarkToDocument(Document doc) throws DocumentException {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            InputStream is = classLoader.getResourceAsStream("images/watermark.png");
            byte[] data = new byte[is.available()];
            is.read(data);
            Image img = Image.getInstance(data);
            img.setAbsolutePosition(0, 0);
            doc.add(img);
        } catch (IOException exc) {}
    }

    public class Watermark extends PdfPageEventHelper {
        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            try {
                addWatermarkToDocument(document);
            } catch(DocumentException exc) {}
        }
    }

    private void addItemsInPriceList(Document doc, Collection<IEquipmentModel> equipmentModels)
            throws Exception {
        PdfPTable table = new PdfPTable(4);
        table.setSpacingBefore(4f);
        for(IEquipmentModel equipmentModel: equipmentModels){
            PdfPCell brandCell = new PdfPCell();
            PdfPCell typeCell = new PdfPCell();
            PdfPCell modelCell = new PdfPCell();
            PdfPCell costCell = new PdfPCell();

            brandCell.addElement(new Paragraph(MessageFormat.format("Бренд: {0}",equipmentModel.getBrandName()),createFont()));
            typeCell.addElement(new Paragraph(MessageFormat.format("Тип: {0}",equipmentModel.getName()),createFont()));
            modelCell.addElement(new Paragraph(MessageFormat.format("Модель: {0}",equipmentModel.getModel()),createFont()));
            costCell.addElement(new Paragraph(MessageFormat.format("Цена: {0}",equipmentModel.getCost()),createFont()));

            table.addCell(brandCell);
            table.addCell(typeCell);
            table.addCell(modelCell);
            table.addCell(costCell);
        }
        doc.add(table);
    }
}

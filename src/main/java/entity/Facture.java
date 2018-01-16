package entity;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Facture {
	
	private Commande cmd;
	private VenteProduit pdt;
	

	public Facture(Commande cmd, VenteProduit pdt) {
		super();
		this.cmd = cmd;
		this.pdt = pdt;
	}

	public Commande getCmd() {
		return cmd;
	}

	public void setCmd(Commande cmd) {
		this.cmd = cmd;
	}

	public VenteProduit getPdt() {
		return pdt;
	}

	public void setPdt(VenteProduit pdt) {
		this.pdt = pdt;
	}
	
	public void generate() {
		Document document = new Document(PageSize.A4);
		BaseColor monVert = new BaseColor(63, 209, 187); 
		Font helveticaBOLD = new Font(FontFamily.HELVETICA, 52, Font.BOLD, monVert);
		try {
			PdfWriter.getInstance(document, new FileOutputStream("/factures/test.pdf"));
			document.open();
			
			Paragraph p = new Paragraph("FACTURE", helveticaBOLD);
			
			document.add(p);
			
			document.add(Chunk.NEWLINE);document.add(Chunk.NEWLINE);
			
			document.add(new Paragraph("Commande N° "+cmd.getCodeCmd()));
			
			document.add(Chunk.NEWLINE);
			
			document.add(new Paragraph("Facturer à "+cmd.getClient()));
			
			document.add(Chunk.NEWLINE);
			
			document.add(new Paragraph("Le "+cmd.getDateCmd().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
			
			document.add(Chunk.NEWLINE);document.add(Chunk.NEWLINE);
			
			PdfPTable table = new PdfPTable(5);
			table.addCell("Code produit");
            table.addCell("Nom");
            table.addCell("Prix unitaire");
            table.addCell("Quantité");
            table.addCell("Montant");
			
            table.addCell(""+pdt.getCodePdt());
            table.addCell(pdt.getNomPdt());
            table.addCell(pdt.getPrixPdt()+" DH");
            table.addCell(""+cmd.getQteCmd());
            table.addCell(cmd.getQteCmd()*pdt.getPrixPdt()+" DH");
            
            document.add(table);
			//opening the PDF
	        File pdfFile = new File("/factures/test.pdf");
	        
	        try {
	            Desktop.getDesktop().open(pdfFile);
	        } catch (IOException ex) {
	            Logger.getLogger(Facture.class.getName()).log(Level.SEVERE, null, ex);
	        }
			
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		document.close(); 
	}
}

package com.nova.dataservice.serviceImpl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.nova.dataservice.entity.BarCodeGenerateForLabEntity;
import com.nova.dataservice.service.BarCodeGenerateForLabService;


@Service

public class BarCodeGenerateForLabServiceImpl implements BarCodeGenerateForLabService {


	    private  BitMatrix generateQRCodeMatrix(String data) {
	        Map<EncodeHintType, Object> hints = new HashMap<>();
	        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
	        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
	        try {
	            return qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 300, 300, hints);
	        } catch (WriterException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Error generating QR code", e);
	        }
	    }

	    private  byte[] toByteArray(BufferedImage image) throws IOException {
	        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
	            ImageIO.write(image, "png", baos);
	            return baos.toByteArray();
	        }
	    }

//	    public void main(String[] args) {
//	        BarCodeGenerateForLabEntity data = new BarCodeGenerateForLabEntity();
//	        data.setId(11L);
//	        BarCodeGenerateForLab(data, "C:\\Users\\Admin\\Documents\\dumps\\example.pdf");
//	        System.out.println("Success");
//	    }

		@Override
		public void BarCodeGenerateForLab(BarCodeGenerateForLabEntity labEntity, String outputPath) {
	        String data = "http://localhost:8082/dataservice/getShopAvaibilityByShopId/1";
	        BitMatrix bitMatrix = generateQRCodeMatrix(data);
	        BufferedImage qrCodeImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
	        try (FileOutputStream pdfOutputStream = new FileOutputStream(outputPath);
	             PdfWriter pdfWriter = new PdfWriter(pdfOutputStream);
	             PdfDocument pdfDocument = new PdfDocument(pdfWriter);
	             Document document = new Document(pdfDocument)) {
	            Image img = new Image(ImageDataFactory.create(toByteArray(qrCodeImage)));
	            document.add(img);
	            System.out.println("PDF with QR code generated successfully at: " + outputPath);
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Error generating PDF with QR code", e);
	        }
	    }

		
		
	
	}

 

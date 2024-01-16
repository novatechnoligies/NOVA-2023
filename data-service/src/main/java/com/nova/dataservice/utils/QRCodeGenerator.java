package com.nova.dataservice.utils;

import com.itextpdf.barcodes.BarcodeQRCode;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Image;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class QRCodeGenerator {

    public static Image generateQRCodeImage(String text, int width, int height, Color foregroundColor, Color backgroundColor)
            throws IOException {
        // Create a BarcodeQRCode instance
		BarcodeQRCode qrCode = new BarcodeQRCode(text);

		// Set error correction level if needed
		//qrCode.setErrorLevel(0);  // 0: L, 1: M, 2: Q, 3: H

		// Create an ImageData instance representing the background color
		DeviceRgb backgroundColorRgb = new DeviceRgb(backgroundColor.getColorValue()[0],
		        backgroundColor.getColorValue()[1], backgroundColor.getColorValue()[2]);

		// Create a ByteArrayOutputStream to capture the PDF content
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfWriter pdfWriter = new PdfWriter(baos);
		PdfDocument pdfDoc = new PdfDocument(pdfWriter);

		// Create a PdfCanvas and draw the QR code onto it
		PdfCanvas pdfCanvas = new PdfCanvas(pdfDoc.addNewPage());
		qrCode.placeBarcode(pdfCanvas, foregroundColor, 0);
		// Close the PdfDocument
		pdfDoc.close();

		// Create an Image from the byte array
		Image qrCodeImage = new Image(ImageDataFactory.create(baos.toByteArray()));

		// Set width and height
		qrCodeImage.setWidth(width).setHeight(height);

		return qrCodeImage;
    }
}



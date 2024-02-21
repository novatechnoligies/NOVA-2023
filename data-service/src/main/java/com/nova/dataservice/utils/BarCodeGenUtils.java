package com.nova.dataservice.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
public class BarCodeGenUtils {

	public static BufferedImage BarCodeGenerateForLab(String data) {
        //String data = "http://localhost:8082/dataservice/getShopAvaibilityByShopId/1";
        BitMatrix bitMatrix = generateQRCodeMatrix(data);
        BufferedImage qrCodeImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        return qrCodeImage;
    }
	
	 private static  BitMatrix generateQRCodeMatrix(String data) {
	        Map<EncodeHintType, Object> hints = new HashMap<>();
	        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
	        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
	        try {
	            return qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 10, 10, hints);
	        } catch (WriterException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Error generating QR code", e);
	        }
	    }

	    public static  byte[] toByteArray(BufferedImage image) throws IOException {
	        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
	            ImageIO.write(image, "png", baos);
	            return baos.toByteArray();
	        }
	    }

}

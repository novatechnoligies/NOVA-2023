package com.awsS3.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3ObjectSummary;

@Service
public class FileUploadService {

	
	private Logger logger = LoggerFactory.getLogger(FileUploadService.class);

    @Autowired
    private AmazonS3 amazonS3;

    @Value("novafiles")
    private String bucketName;

    
     // Upload file into AWS S3
    public String uploadFile(String keyName, MultipartFile file) {
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            amazonS3.putObject(bucketName, keyName, file.getInputStream(), metadata);
            return "File uploaded: " + keyName;
        } catch (IOException ioe) {
            logger.error("IOException: " + ioe.getMessage());
        } catch (AmazonServiceException serviceException) {
            logger.info("AmazonServiceException: "+ serviceException.getMessage());
            throw serviceException;
        } catch (AmazonClientException clientException) {
            logger.info("AmazonClientException Message: " + clientException.getMessage());
            throw clientException;
        }
        return "File not uploaded: " + keyName;
    }
	/*
	 * public List<String> uploadFiles(List<MultipartFile> files) { List<String>
	 * uploadedFiles = new ArrayList<>();
	 * 
	 * for (MultipartFile file : files) { String fileName =
	 * file.getOriginalFilename();
	 * 
	 * try { ObjectMetadata metadata = new ObjectMetadata();
	 * metadata.setContentLength(file.getSize()); amazonS3.putObject(bucketName,
	 * fileName, file.getInputStream(), metadata);
	 * uploadedFiles.add("File uploaded: " + fileName); } catch (IOException ioe) {
	 * logger.error("IOException while uploading " + fileName + ": " +
	 * ioe.getMessage()); uploadedFiles.add("File not uploaded: " + fileName); }
	 * catch (AmazonServiceException serviceException) {
	 * logger.info("AmazonServiceException while uploading " + fileName + ": " +
	 * serviceException.getMessage()); uploadedFiles.add("File not uploaded: " +
	 * fileName); } catch (AmazonClientException clientException) {
	 * logger.info("AmazonClientException while uploading " + fileName + ": " +
	 * clientException.getMessage()); uploadedFiles.add("File not uploaded: " +
	 * fileName); } } return uploadedFiles; }
	 */
    
    //Get all files from S3 bucket
    
    public List<String> listFiles() {
        ListObjectsRequest listObjectsRequest =
                new ListObjectsRequest()
                        .withBucketName(bucketName);
        List<String> keys = new ArrayList<>();
        ObjectListing objects = amazonS3.listObjects(listObjectsRequest);
        while (true) {
            List<S3ObjectSummary> objectSummaries = objects.getObjectSummaries();
            if (objectSummaries.size() < 1) {
                break;
            }
            for (S3ObjectSummary item : objectSummaries) {
                if (!item.getKey().endsWith("/"))
                    keys.add(item.getKey());
            }
            objects = amazonS3.listNextBatchOfObjects(objects);
        }
        return keys;
    }
    
    //download file from s3
    
    public ByteArrayOutputStream downloadFile(String keyName) {
        try {
            com.amazonaws.services.s3.model.S3Object s3object = amazonS3.getObject(new GetObjectRequest(bucketName, keyName));

            InputStream is = s3object.getObjectContent();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[4096];
            while ((len = is.read(buffer, 0, buffer.length)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            return outputStream;
        } catch (IOException ioException) {
            logger.error("IOException: " + ioException.getMessage());
        } catch (AmazonServiceException serviceException) {
            logger.info("AmazonServiceException Message:    " + serviceException.getMessage());
            throw serviceException;
        } catch (AmazonClientException clientException) {
            logger.info("AmazonClientException Message: " + clientException.getMessage());
            throw clientException;
        }
        return null;
    }
    
    //delete file from s3
    public String deleteFile(final String fileName) {
    	amazonS3.deleteObject(bucketName, fileName);
        return "Deleted File: " + fileName;
    }
}

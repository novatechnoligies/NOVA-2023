package com.awsS3.controller;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.awsS3.service.FileUploadService;


@RestController
public class FileUploadController {
	
	@Autowired
	FileUploadService service;

	//upload files to s3 bucket
	@PostMapping("/file/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("fileName") String fileName,
                                             @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(service.uploadFile(fileName, file), org.springframework.http.HttpStatus.OK);
    }
	
	/*
	 * @PostMapping("/file/upload") public ResponseEntity<List<String>>
	 * uploadFile(@RequestPart("files") List<MultipartFile> files){ List<String>
	 * uploadResults = service.uploadFile(files); return new
	 * ResponseEntity<>(uploadResults,org.springframework.http.HttpStatus.OK); }
	 */
	
	//get all files from s3 bucket
	@GetMapping("/list/files")
    public ResponseEntity<List<String>> getListOfFiles() {
        return new ResponseEntity<>(service.listFiles(), org.springframework.http.HttpStatus.OK);
    }
	
	//download files from s3
	@GetMapping(value = "/download/{filename}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String filename) {
        ByteArrayOutputStream downloadInputStream = service.downloadFile(filename);

        return ResponseEntity.ok()
                .contentType(contentType(filename))
                .header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .body(downloadInputStream.toByteArray());
    }


    private MediaType contentType(String filename) {
        String[] fileArrSplit = filename.split("\\.");
        String fileExtension = fileArrSplit[fileArrSplit.length - 1];
        switch (fileExtension) {
            case "txt":
                return MediaType.TEXT_PLAIN;
            case "png":
                return MediaType.IMAGE_PNG;
            case "jpg":
                return MediaType.IMAGE_JPEG;
            default:
                return MediaType.APPLICATION_OCTET_STREAM;
        }
    }
    
    //delete file from s3
    @GetMapping(value = "/delete/{filename}")
    public ResponseEntity<String> deleteFile(@PathVariable("filename") String filename) {
        return new ResponseEntity<>(service.deleteFile(filename), org.springframework.http.HttpStatus.OK);
    }
    
}

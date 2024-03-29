package com.nova.dataservice.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.entity.UserDetails;
import com.nova.dataservice.repository.UserDetailsRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
public class ProfileUploadController {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	private static final String UPLOAD_DIR = "C:\\Downloads";
	
	private static final String UPLOAD_DIRV = "C:\\Downloads";
	
	private static final List<String> ALLOWED_FILE_TYPES = Arrays.asList("pdf", "png", "jpg");


    @PostMapping(value = "uploadProfile")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file, Long userId) {
        try {
            createUploadsDirectory();
            String fileName = file.getOriginalFilename();
            String fileExtension = getFileExtension(fileName);
            Path filePath = Paths.get(UPLOAD_DIR, fileName);
            Files.copy(file.getInputStream(), filePath);
            
            if (!ALLOWED_FILE_TYPES.contains(fileExtension.toLowerCase())) {
                return ResponseEntity.status(400).body("Invalid file format. Allowed Only: PDF, PNG, JPG");
            }

           Optional<UserDetails> userData = userDetailsRepository.findById(userId);
           userData.get().setOwnerPhoto(UPLOAD_DIR+"\\"+fileName);
           userDetailsRepository.save(userData.get());
            return ResponseEntity.ok("File uploaded successfully: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to upload file");
        }
    }

    private String getFileExtension(String fileName) {
    	int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex == -1) {
            return "";  // No extension found
        }
        return fileName.substring(lastDotIndex + 1);
	}

	private void createUploadsDirectory() throws IOException {
        // Create the uploads directory if it doesn't exist
        Path directory = Paths.get(UPLOAD_DIR);
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }
    }
    @PostMapping(value = "uploadAdharPhoto")
    public ResponseEntity<String> uploadAdharPhoto(@RequestParam("file") MultipartFile file, Long userId) {
    	 try {
             createUploadsDirectory();
             String fileName = file.getOriginalFilename();
             String fileExtension = getFileExtension(fileName);
             Path filePath = Paths.get(UPLOAD_DIR, fileName);
             Files.copy(file.getInputStream(), filePath);
             
             if (!ALLOWED_FILE_TYPES.contains(fileExtension.toLowerCase())) {
                 return ResponseEntity.status(400).body("Invalid file format. Allowed Only PDF, PNG, JPG");
             }

            Optional<UserDetails> userData = userDetailsRepository.findById(userId);
            userData.get().setOwnerPhoto(UPLOAD_DIR+"\\"+fileName);
            userDetailsRepository.save(userData.get());
             return ResponseEntity.ok("File uploaded successfully: " + fileName);
         } catch (IOException e) {
             e.printStackTrace();
             return ResponseEntity.status(500).body("Failed to upload file");
         }
     }
    private void uploadAdharPhoto() throws IOException {
        // Create the uploads directory if it doesn't exist
        Path directory = Paths.get(UPLOAD_DIRV);
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }
    }

}

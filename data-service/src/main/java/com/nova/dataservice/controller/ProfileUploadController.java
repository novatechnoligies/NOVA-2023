package com.nova.dataservice.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
	
	private static final String UPLOAD_DIR = "D:\\profilePhoto";

    @PostMapping(value = "uploadProfile")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file, Long userId) {
        try {
            createUploadsDirectory();
            String fileName = file.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR, fileName);
            Files.copy(file.getInputStream(), filePath);

           Optional<UserDetails> userData = userDetailsRepository.findById(userId);
           userData.get().setOwnerPhoto(UPLOAD_DIR+"\\"+fileName);
           userDetailsRepository.save(userData.get());
            return ResponseEntity.ok("File uploaded successfully: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to upload file");
        }
    }

    private void createUploadsDirectory() throws IOException {
        // Create the uploads directory if it doesn't exist
        Path directory = Paths.get(UPLOAD_DIR);
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }
    }

}

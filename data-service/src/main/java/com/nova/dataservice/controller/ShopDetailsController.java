package com.nova.dataservice.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nova.dataservice.DTO.ShopDetailsDTO;
import com.nova.dataservice.entity.ShopDetails;
import com.nova.dataservice.entity.UserDetails;
import com.nova.dataservice.repository.ShopDetailsRepository;
import com.nova.dataservice.service.ShopDetailsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
public class ShopDetailsController {
	@Autowired
	ShopDetailsService detailsService;
	
	@Autowired
	ShopDetailsRepository detailsRepository;
	
	private static final String UPLOAD_DIR = "D:\\uploadLogo";

	@PostMapping(value = "saveShopDetails")
	public ResponseEntity<Object> saveShopDetails(@RequestBody ShopDetails details) {
		try {
			ShopDetails data = detailsService.saveShopDetails(details);
			if (data != null) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("ShopDetails Not Found", HttpStatus.OK);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}

	}
	@GetMapping("findAllShopDetails")
	public ResponseEntity<Object> findAllShopDetails() {
		try {
			List<ShopDetailsDTO> data = detailsService.findAllShopDetails();
			if (data != null && !data.isEmpty()) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("shopDetails Not Found", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
		}
	}

	@GetMapping(value = "/findByIdShopDetails/{prId}")
	public ResponseEntity<Object> findByIdShopDetails(@PathVariable("prId") Long id) {
		try {
			Optional<ShopDetailsDTO> data = detailsService.findByIdShopDetails(id);
			if (data.isPresent()) {
				return new ResponseEntity<Object>(data.get(), HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("incorrect Id", HttpStatus.OK);

			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
		}
	}
	@GetMapping(value = "searchLabByName")
	public ResponseEntity<Object> searchLabByNameAndOwner(String labName, Long ownerId) {
    
		try {
			List<ShopDetailsDTO> data = detailsService.searchLabByNameAndOwner(labName, ownerId);
			if (data.isEmpty()) {
				return new ResponseEntity<Object>("no data found", HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		return new ResponseEntity<Object>("Something went wrong",HttpStatus.OK);
	}
		
	}
	@GetMapping(value = "getAllLabListByOwnerId")
	public ResponseEntity<Object> getAllLabListByOwnerId( Long ownerId) {

		try {
			List<ShopDetailsDTO> data = detailsService.getAllLabListByOwnerId( ownerId);
			if (data.isEmpty()) {
				return new ResponseEntity<Object>(new ArrayList<>(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "getAllLabListForTabletByOwnerId")
	public ResponseEntity<Object> getAllLabListForTabletByOwnerId( Long ownerId) {

		try {
			List<ShopDetailsDTO> data = detailsService.getAllLabListForTabletByOwnerId( ownerId);
			if (data.isEmpty()) {
				return new ResponseEntity<Object>("no data found", HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}
	}

	@PutMapping(value = "deleteShopDetails")
	public ResponseEntity<Object> deleteShopDetails(Long shopId) {
		try {
			ShopDetails data = detailsService.deleteShopDetails(shopId);
			if (data != null) {
				HashMap<String, String> map = new HashMap<>();
				map.put("200", "success");
				map.put("message", "deleted");
				return new ResponseEntity<Object>(map, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("ShopDetails Not Found", HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}
	}
	

	@PostMapping(value = "uploadLogo")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file, Long shopId) {
        try {
            createUploadsDirectory();
            String fileName = file.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR, fileName);
            Files.copy(file.getInputStream(), filePath);

           Optional<ShopDetails> shopData = detailsRepository.findById(shopId);
           shopData.get().setLogo(UPLOAD_DIR+"\\"+fileName);
           detailsRepository.save(shopData.get());
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



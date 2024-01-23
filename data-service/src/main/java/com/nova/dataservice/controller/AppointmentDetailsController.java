package com.nova.dataservice.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.DTO.AppoinmenCounttDTO;
import com.nova.dataservice.DTO.AppoinmentDTO;
import com.nova.dataservice.DTO.AppoinmentDetailDTO;
import com.nova.dataservice.DTO.ShopDetailsDTO;
import com.nova.dataservice.entity.AppontmentDetails;
import com.nova.dataservice.service.AppointmentDetailservice;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
public class AppointmentDetailsController {
	
	@Autowired
	AppointmentDetailservice appService;
	
	@PostMapping(value = "saveAppointment")
	public ResponseEntity<Object> saveAppointment(@RequestBody AppontmentDetails rl) {
		try {
			AppontmentDetails data = appService.saveAppointment(rl);
			if (data!=null) {
				return new ResponseEntity<>(data, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("fail to save data", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("somthing went wrong fail to save data , due to MYSQL is down", HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/getAllAppointment")
	public ResponseEntity<Object> getAllAppontments() {
		try {
			List<AppontmentDetails> appList =	appService.findAllAppointment();
			if (appList!=null && !appList.isEmpty()) {
				return new ResponseEntity<>(appList, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("fail to get data", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("somthing went wrong fail to get data , due to MYSQL is down", HttpStatus.OK);
		}
	
	}
	
	@GetMapping(value = "/getAllAppointment/{appId}")
	public ResponseEntity<Object> getAllAppontments(@PathVariable("appId") Long id) {
		try {
			Optional<AppontmentDetails> app =	appService.findAppointmentById(id);
			if (app!=null && !app.isPresent()) {
				return new ResponseEntity<>(app, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("fail to get data", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("somthing went wrong fail to get data , due to MYSQL is down", HttpStatus.OK);
		}
	
	}

	@GetMapping(value = "getTodaysAppointemtsByLabId")
	public ResponseEntity<Object> getTodaysAppointemtsByLabId(LocalDate date, Long labId, LocalDate fromDate,
			LocalDate toDate) {

		try {
			List<AppoinmentDTO> data = appService.getTodaysAppointemtsByLabId(date, labId, fromDate, toDate);
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
	@GetMapping(value = "getAllServicesByAppointmentIdAndPatientId")
	public ResponseEntity<Object> getAllServicesByAppointmentIdAndPatientId(Long appointmentId, Long patientId) {

		try {
			List<AppoinmentDetailDTO> data = appService.getAllServicesByAppointmentIdAndPatientId(appointmentId, patientId);
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
	
	@GetMapping(value = "getTodaysAppointemtsCountByLabId")
	public ResponseEntity<Object> getTodaysAppointemtsCountByLabId(LocalDate date, Long labId, LocalDate fromDate,
			LocalDate toDate) {

		try {
			AppoinmenCounttDTO data = appService.getTodaysAppointemtsCountByLabId(date, labId, fromDate, toDate);

			if (data == null) {
				return new ResponseEntity<Object>("no data found", HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}
	}
	@GetMapping(value = "getTotalsAppointemtsCountByLabId")
	public ResponseEntity<Object> getTotalAppointemtsCountByLabId( Long labId, LocalDate fromDate,
			LocalDate toDate) {

		try {
			AppoinmenCounttDTO data = appService.getTotalAppointemtsCountByLabId( labId, fromDate, toDate);

			if (data== null) {
				return new ResponseEntity<Object>("no data found", HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}
	}
		@GetMapping(value = "getTodayAppoinmentsEarningsByLabId")
		public ResponseEntity<Object> getTodayAppoinmentsEarningsByLabId( Long labId, LocalDate fromDate,
				LocalDate toDate) {

			try {
				AppoinmenCounttDTO data = appService.getTodayAppoinmentsEarningsByLabId( labId, fromDate, toDate);

				if (data== null) {
					return new ResponseEntity<Object>("no data found", HttpStatus.OK);
				} else {
					return new ResponseEntity<Object>(data, HttpStatus.OK);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
			}
		}
			@GetMapping(value = "getTotalAppoinmentsEarningsByLabId")
			public ResponseEntity<Object> getTotalAppoinmentsEarningsByLabId( Long labId, LocalDate fromDate,
					LocalDate toDate) {

				try {
					AppoinmenCounttDTO data = appService.getTotalAppoinmentsEarningsByLabId( labId, fromDate, toDate);

					if (data== null) {
						return new ResponseEntity<Object>("no data found", HttpStatus.OK);
					} else {
						return new ResponseEntity<Object>(data, HttpStatus.OK);
					}
				} catch (Exception e) {
					e.printStackTrace();
					return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
				}
			}		
	         @GetMapping(value = "getTodaysCompleatedReportCountByLabId")
				public ResponseEntity<Object> getTodaysCompleatedReportCountByLabId(LocalDate date, Long labId,
						LocalDate fromDate, LocalDate toDate, String status) {

					try {
						AppoinmenCounttDTO data = appService.getTodaysCompleatedReportCountByLabId(date, labId,
								fromDate, toDate, status);

						if (data == null) {
							return new ResponseEntity<Object>("no data found", HttpStatus.OK);
						} else {
							return new ResponseEntity<Object>(data, HttpStatus.OK);
						}
					} catch (Exception e) {
						e.printStackTrace();
						return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
					}
				}
	
}

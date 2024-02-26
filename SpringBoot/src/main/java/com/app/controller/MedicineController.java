package com.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.app.dto.MedicineDto;
import com.app.exception.ResourseNotFound;

import com.app.service.MedicineService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/medicine")
public class MedicineController {
	
	@Autowired
	private MedicineService medServ;
	
	@GetMapping
	ResponseEntity<?> getAll(){
		return ResponseEntity.ok(medServ.getAllMedicines());
	}
	
	@PostMapping("/addMedicine")
	ResponseEntity<?> addMedicine(@RequestBody MedicineDto medDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(medServ.addMedicine(medDto));
	}
	
	@GetMapping("/{id}")
	ResponseEntity<?> getMedById(@PathVariable Long id) throws ResourseNotFound{
		return ResponseEntity.ok(medServ.getMedicineById(id));
	}

	@DeleteMapping("/{id}")
	ResponseEntity<?> deleteMedicine(@PathVariable Long id){
		return ResponseEntity.ok(medServ.deleteMedicineById(id));
	}
	
	@PutMapping("/updateMedicine")
	ResponseEntity<?> updateMedicine(@RequestBody MedicineDto medDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(medServ.updateMedicine(medDto));
	}
}

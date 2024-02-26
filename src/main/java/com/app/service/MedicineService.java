package com.app.service;
import java.util.List;

import com.app.dto.ApiResponseDto;
import com.app.dto.MedicineDto;
import com.app.exception.ResourseNotFound;
public interface MedicineService {
	
	List<MedicineDto> getAllMedicines();
	
	MedicineDto getMedicineById(Long id) throws ResourseNotFound;
	
	MedicineDto addMedicine(MedicineDto med);
	
	ApiResponseDto deleteMedicineById(Long id);
	
	MedicineDto updateMedicine(MedicineDto med);
	
}

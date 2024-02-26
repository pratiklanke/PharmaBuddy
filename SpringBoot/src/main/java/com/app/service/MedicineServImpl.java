package com.app.service;

import java.util.List;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponseDto;
import com.app.dto.MedicineDto;
import com.app.exception.ResourseNotFound;
import com.app.pojos.Medicine;
import com.app.repository.MedicineDAO;

@Service
@Transactional
public class MedicineServImpl implements MedicineService {
	
	@Autowired
	private MedicineDAO medDao;

	@Autowired
	private ModelMapper mapper;
		
	@Override
	public List<MedicineDto> getAllMedicines() {
		List<Medicine> meds = medDao.findAll();
		return meds.stream().map(medicine -> mapper.map(medicine, MedicineDto.class)).collect(Collectors.toList());
		
	}

	@Override
	public MedicineDto getMedicineById(Long id) throws ResourseNotFound{
		Medicine med = medDao.findById(id).orElseThrow(()->new ResourseNotFound("Medicine Id not Found..!"));
		return mapper.map(med, MedicineDto.class);
	}
	
	@Override
	public MedicineDto addMedicine(MedicineDto medDto) {
		Medicine medi = mapper.map(medDto, Medicine.class);
		Medicine savedMed = medDao.save(medi);
		return mapper.map(savedMed, MedicineDto.class);
	}

	@Override
	public ApiResponseDto deleteMedicineById(Long id) {
		if(medDao.existsById(id)) {
			medDao.deleteById(id);
			return new ApiResponseDto("Deleted..!");
		}		
		return new ApiResponseDto("Not Deleted..!");
	}

	@Override
	public MedicineDto updateMedicine(MedicineDto med) {
		Medicine medi = mapper.map(med, Medicine.class);
		Medicine savedMed = medDao.save(medi);
		return mapper.map(savedMed, MedicineDto.class);
	}

}

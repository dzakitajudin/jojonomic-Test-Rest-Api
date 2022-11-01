package com.jojonomic.Emas.controllers;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jojonomic.Emas.dtos.EmasDTO;
import com.jojonomic.Emas.models.Emas;
import com.jojonomic.Emas.repositories.EmasRepository;

@RestController
@RequestMapping("/api")
public class EmasController {
	
	@Autowired
	private EmasRepository emasRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	private Emas convertEmasToEntity (EmasDTO emasDto) {
		return modelMapper.map(emasDto, Emas.class);
	}
	
	private EmasDTO convertEmasToDTO (Emas emas) {
		return modelMapper.map(emas, EmasDTO.class);
	}
	
	// API INPUT HARGA
	@PostMapping("/input-harga")
	public Map<String, Object> createEmas(@RequestBody EmasDTO emasDTO) {
		Map<String, Object> mapResult = new HashMap<>();
		
		Emas emas = convertEmasToEntity(emasDTO);
		emas.setAdminId(emasDTO.getAdminId());
		emas.setHargaTopupEmas(emasDTO.getHargaTopupEmas());
		
		mapResult.put("error", false);
		mapResult.put("reff_id", null);
		emasRepository.save(emas);
		
		return mapResult;
	}
	
}

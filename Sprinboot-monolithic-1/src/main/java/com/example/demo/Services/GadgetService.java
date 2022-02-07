package com.example.demo.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.gadgetDto;

@Service
public interface GadgetService {

	ResponseEntity<?> addGadget(gadgetDto gadgetDto);

	ResponseEntity<?> getGadget();

	ResponseEntity<?> updateGadget(gadgetDto gadgetDto);

	ResponseEntity<?> deleteGadget(String id);

}

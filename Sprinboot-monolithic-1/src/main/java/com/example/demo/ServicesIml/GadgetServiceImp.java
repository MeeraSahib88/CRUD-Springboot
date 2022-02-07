package com.example.demo.ServicesIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.MessageResponse;
import com.example.demo.Dto.gadgetDto;
import com.example.demo.Model.Gadget;
import com.example.demo.Repository.GadgetRepo;
import com.example.demo.Services.GadgetService;

@Service
public class GadgetServiceImp implements GadgetService {
	@Autowired
	GadgetRepo gadgetRepo;

	@Autowired
	Environment env;

	@Override
	public ResponseEntity<?> addGadget(gadgetDto gadgetDto) {
		try {
			Gadget gadget = Gadget.builder().brand(gadgetDto.getBrand()).description(gadgetDto.getDescription())
					.price(gadgetDto.getPrice()).name(gadgetDto.getName()).build();
			gadget = gadgetRepo.save(gadget);
			return ResponseEntity
					.ok(new MessageResponse(HttpStatus.OK.value(), env.getProperty("success.store"), gadget));
		} catch (Exception e) {
			return ResponseEntity
					.ok(new MessageResponse(HttpStatus.BAD_REQUEST.value(), env.getProperty("failed.store")));
		}
	}

	@Override
	public ResponseEntity<?> getGadget() {
		List<Gadget> gadget;
		gadget = gadgetRepo.findAll();
		if (!gadget.isEmpty()) {
			return ResponseEntity
					.ok(new MessageResponse(HttpStatus.BAD_REQUEST.value(), env.getProperty("failed.fetched")));
		}
		return ResponseEntity
				.ok(new MessageResponse(HttpStatus.OK.value(), env.getProperty("success.fetched"), gadget));
	}

	@Override
	public ResponseEntity<?> updateGadget(gadgetDto gadgetDto) {
		try {
			Gadget gadget = gadgetRepo.findById(gadgetDto.getId()).get();
			Gadget gadget2 = Gadget.builder().Id(gadget.getId()).brand(gadgetDto.getBrand())
					.description(gadgetDto.getDescription()).price(gadgetDto.getPrice()).name(gadgetDto.getName())
					.build();
			return ResponseEntity
					.ok(new MessageResponse(HttpStatus.OK.value(), env.getProperty("success.update"), gadget2));
		} catch (Exception e) {
			return ResponseEntity
					.ok(new MessageResponse(HttpStatus.BAD_REQUEST.value(), env.getProperty("failed.update")));
		}
	}

	@Override
	public ResponseEntity<?> deleteGadget(String id) {
		try {
			gadgetRepo.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity
					.ok(new MessageResponse(HttpStatus.BAD_REQUEST.value(), env.getProperty("failed.Delete")));
		}
		return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(), env.getProperty("success.Delete"), null));
	}

}

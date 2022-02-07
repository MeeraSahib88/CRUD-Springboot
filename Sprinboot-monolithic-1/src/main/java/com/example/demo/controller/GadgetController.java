package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.gadgetDto;
import com.example.demo.Services.GadgetService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/gadget")
public class GadgetController {
	@Autowired
	public GadgetService gadgetService;
	
	@PostMapping("/save")
	public ResponseEntity<?>addGadget(@RequestBody  gadgetDto gadgetDto){
			return gadgetService.addGadget(gadgetDto);
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getGadget(){
		return gadgetService.getGadget();
		
	}
	@PutMapping("/update") 
	public ResponseEntity<?>updateGadget(@RequestBody gadgetDto gadgetDto){
		return  gadgetService.updateGadget(gadgetDto);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>deleteGadget(@PathVariable(name = "id") String id){
		return gadgetService.deleteGadget(id);
	}

}

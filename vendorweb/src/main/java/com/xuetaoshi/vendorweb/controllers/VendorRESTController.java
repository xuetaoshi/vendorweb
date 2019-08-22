package com.xuetaoshi.vendorweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuetaoshi.vendorweb.entities.Vendor;
import com.xuetaoshi.vendorweb.repos.VendorRepository;

@RestController
@CrossOrigin
public class VendorRESTController {
	
	@Autowired
	VendorRepository vendorRepository;
	
	@RequestMapping("/vendors/{id}")
	public Vendor findVendor(@PathVariable("id") int id) {
		return vendorRepository.findById(id).get();
	}
	
	@RequestMapping("/vendors")
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		Vendor foundVendor = vendorRepository.findById(vendor.getId()).get();
		foundVendor.setAddress(vendor.getAddress());
		foundVendor.setCode(vendor.getCode());
		foundVendor.setEmail(vendor.getEmail());
		foundVendor.setName(vendor.getName());
		foundVendor.setType(vendor.getType());
		return vendorRepository.save(foundVendor);
	}
}

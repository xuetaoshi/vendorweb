package com.xuetaoshi.vendorweb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xuetaoshi.vendorweb.entities.Vendor;
import com.xuetaoshi.vendorweb.service.VendorService;

@Controller
public class VendorController {
	
	@Autowired
	VendorService service;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createVendor";
	}
	
	@RequestMapping("/saveV")
	public String saveVendor(@ModelAttribute("vendor") Vendor vendor, ModelMap modelMap) {
		Vendor savedVendor = service.saveVendor(vendor);
		String msg = "Vendor saved with id: "+savedVendor.getId();
		modelMap.addAttribute("msg", msg);
		return "createVendor";
	}
	
	@RequestMapping("/displayVendors")
	public String displayVendors(ModelMap modelMap) {
		List<Vendor> allVendors = service.getAllVendors();
		modelMap.addAttribute("vendors", allVendors);
		return "displayVendors";
	}
	
	@RequestMapping("deleteVendor")
	public String deleteVendor(@RequestParam("id") int id, ModelMap modelapMap) {
		Vendor vendor = new Vendor();
		vendor.setId(id);
		service.deleteVendor(vendor);
		List<Vendor> allVendors = service.getAllVendors();
		modelapMap.addAttribute("vendors", allVendors);
		return "displayVendors";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelapMap) {
		Vendor vendor = service.getVendorById(id);
		modelapMap.addAttribute("vendor", vendor);
		return "updateVendor";
	}
	
	@RequestMapping("/updateV")
	public String updateVendor(@ModelAttribute("vendor") Vendor vendor, ModelMap modelMap) {
		service.updateVendor(vendor);
		List<Vendor> allVendors = service.getAllVendors();
		modelMap.addAttribute("vendors", allVendors);
		return "displayVendors";
	}
}

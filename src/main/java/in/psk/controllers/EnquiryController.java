package in.psk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.psk.entities.Enquiry;
import in.psk.services.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {
	@Autowired
	private EnquiryService enquiryService;

	// add enquiry
	@GetMapping("/enquiry")
	public String addEnquiry(Model model) {
		model.addAttribute("enquiry", new Enquiry());
		return "enquiryform";

	}

	// save enq
	@PostMapping("/saveEnquiry")
	public String handleEnquiry(Enquiry enquiry, HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		// we have to make session as false then only it will not create another session
		// object it will give existing session object.
		// if we make true then it will create another ession object.
		Integer cId = (Integer) session.getAttribute("cId");
		boolean status = enquiryService.addEnquiry(enquiry, cId);
		if (status) {
			model.addAttribute("msg", "Enquiry Saved");
			
		} else {
			model.addAttribute("emsg", "Not Saved");
		
		}
		return "enquiryform";
	}

	// view enq
	@GetMapping("/getEnquirys")
	public String getAllEnquirys(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		Integer cId = (Integer) session.getAttribute("cId");
		List<Enquiry> listall = enquiryService.getEnquiries(new Enquiry(), cId);
		model.addAttribute("allenquirys", listall);
		//why we add this below line means to add filters to this binding object by passing new Enquiry() empty object
		model.addAttribute("enquiry", new Enquiry());
		return "viewEnquirysForm";
	}

	// filter enq
	@PostMapping("/filterEnq")
	public String filterEnquirys(Enquiry enquiry, HttpServletRequest req, Model model) {

		HttpSession session = req.getSession(false);
		Integer cId = (Integer) session.getAttribute("cId");
		List<Enquiry> totalEnq = enquiryService.getEnquiries(enquiry, cId);
		model.addAttribute("allenquirys", totalEnq);
		model.addAttribute("enquiry", new Enquiry());
		return "viewEnquirysForm";
	}

	// edit and update
	@GetMapping("/updateEnquiry")
	public String updateEnquiry(@RequestParam("eId") Integer eId, Model model) {
		Enquiry enquiry = enquiryService.getEnquiry(eId);
			model.addAttribute("enquiry",enquiry);
			return "enquiryform";
		
	}
}

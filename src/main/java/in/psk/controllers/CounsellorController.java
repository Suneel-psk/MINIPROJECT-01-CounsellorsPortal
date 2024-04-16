package in.psk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.psk.dashboard.Dashboard;
import in.psk.entities.Counsellors;
import in.psk.entities.Enquiry;
import in.psk.services.CounsellorsService;
import in.psk.services.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellorController {

	@Autowired
	private CounsellorsService counsellorService;

	@Autowired
	private EnquiryService enqService;

	@GetMapping("/logout")
	public String logout(HttpServletRequest req,Model model)
	{
		HttpSession session=req.getSession(false);
		session.invalidate();//this line it is used to remove the data from session Object when i click on logout
		return "redirect:/login";//this line is redirecting to loginpage
	}
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("counsellor", new Counsellors());
		return "registerform";

	}

	@PostMapping("/register")
	public String handleRegister(Counsellors counsellor, Model model) {
		boolean status = counsellorService.saveCounsellorData(counsellor);
		if (status) {
			model.addAttribute("smsg", "Counsellor Registered Successfully");
		

		} else {
			model.addAttribute("emsg", "Enter Valid Email");
			
		}
		model.addAttribute("counsellor", new Counsellors());
		return "registerform";
	}

	@GetMapping("/login")
	public String login(Model model) {

		model.addAttribute("counsellor", new Counsellors());
		return "loginform";
	}

	@PostMapping("/checklogin")
	public String handleLogin(Counsellors counsellor, HttpServletRequest req, Model model) {
		Counsellors c = counsellorService.getCounsellor(counsellor.getEmail(), counsellor.getPassword());
		if (c == null) {
			model.addAttribute("emsg", "Invalid Credintials");
			model.addAttribute("counsellor", new Counsellors());
			return "loginform";
		} else {
			/*
			 * this below two lines responsible to know the counsellorid for to addenquiry
			 * and displayenquirys if we specify the counsellorId in session Object we can
			 * use this session onject anywhere in the application. if we dont specify this
			 * session obj we cant access addenquiry and display enquiries based on
			 * counsellorId. Why we use this sesssion means to know which counsellorloggedin
			 * user is loggined based on this logined user we will save the enquiry and
			 * display the enquiry
			 */
			HttpSession session = req.getSession(true);
			session.setAttribute("cId", c.getCounsellorId());
			// to display dashboard Info
			Dashboard dashboardInfo = enqService.getDashBoardInfo(c.getCounsellorId());
			model.addAttribute("dashboard", dashboardInfo);
			return "dashboard";
		}
	}
	@GetMapping("/getDashboard")
	public String buildDashboard(HttpServletRequest req,Model model)
	{
		HttpSession session = req.getSession(false);
		Integer cId = (Integer) session.getAttribute("cId");
		Dashboard dashboardInfo = enqService.getDashBoardInfo(cId);
		model.addAttribute("dashboard", dashboardInfo);
		return "dashboard";
	}

}

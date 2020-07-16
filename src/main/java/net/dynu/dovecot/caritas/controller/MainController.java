package net.dynu.dovecot.caritas.controller;

import net.dynu.dovecot.caritas.domain.Utils;
import net.dynu.dovecot.caritas.model.DayBehavior;
import net.dynu.dovecot.caritas.repository.DayBehaviorRepository;
import net.dynu.dovecot.caritas.service.DayBehaviorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/caritas")
public class MainController {
	@Autowired
	private DayBehaviorRepository dayBehaviorRepository;

	@Autowired
	private DayBehaviorService dayBehaviorService;

	@GetMapping("")
	public String showHome(Model model) {
		String currentDate = Utils.getCurrentDate();
		Optional<DayBehavior> lastWeekDays = dayBehaviorService.getLastXDays(Utils.WEEK);
		lastWeekDays.ifPresent(dayBehavior -> model.addAttribute("lastWeek", dayBehavior));
		model.addAttribute("date", currentDate);
		return "caritas/home";
	}
	
	@RequestMapping(value = "/selectFace", method = RequestMethod.POST)
	public String selectFace(@RequestParam("face") String face) {
		System.out.println(face);
		return "caritas/home";
	}
}

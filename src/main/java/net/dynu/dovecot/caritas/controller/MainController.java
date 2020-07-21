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

import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Controller
@RequestMapping("/caritas")
public class MainController {
	@Autowired
	private DayBehaviorRepository dayBehaviorRepository;

	@Autowired
	private DayBehaviorService dayBehaviorService;

	@GetMapping("")
	public String showHome(Model model) {
		String currentDate = null;
		try {
			currentDate = Utils.getCurrentDate();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<DayBehavior> lastWeekDays = dayBehaviorService.getLastXDays(Utils.WEEK);
		Collections.reverse(lastWeekDays);
		model.addAttribute("lastWeek", lastWeekDays);
		try {
			model.addAttribute("lastWeekText", Utils.getDateTextFormat(lastWeekDays));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		model.addAttribute("date", currentDate);
		Optional<DayBehavior> todayBehaviorOptional = dayBehaviorService.getDay(Utils.getCurrentDateIdFormat());
		todayBehaviorOptional.ifPresent(todayBehavior -> model.addAttribute("today", todayBehavior));

		Optional<DayBehavior> yesterdayBehaviorOptional = dayBehaviorRepository.findById(Utils.getYesterdayDateIdFormat());
		yesterdayBehaviorOptional.ifPresent(yesterdayBehavior -> model.addAttribute("yesterday", yesterdayBehavior));

		return "caritas/home";
	}
	
	@RequestMapping(value = "/selectFaceToday", method = RequestMethod.POST)
	public String selectFaceToday(Model model, @RequestParam("face") String face, @RequestParam("date") String date) {
		int dayId = Utils.getDateIdFormat(new Date(Long.parseLong(date)));
		Integer behavior = Utils.getBehaviorFromText(face);
		try {
			dayBehaviorService.saveDayBehavior(dayId, behavior);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		model.addAttribute("today", new DayBehavior(dayId, behavior, new Date()));
		return "caritas/fragment_today_behavior :: #today_behavior";
	}

	@RequestMapping(value = "/selectFaceYesterday", method = RequestMethod.POST)
	public String selectFaceYesterday(@RequestParam("face") String face, @RequestParam("date") String date) {
		int dayId = Utils.getDateIdFormat(new Date(Long.parseLong(date)));
		Integer behavior = Utils.getBehaviorFromText(face);
		try {
			dayBehaviorService.saveDayBehavior(dayId, behavior);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "caritas/home";
	}
}

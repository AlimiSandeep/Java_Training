package com.pramati.bot.config;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pramati.bot.service.DateService;
import com.pramati.bot.service.EventInsertionService;

@RestController
public class InputController {

	@Autowired
	EventInsertionService eventService;

	@Autowired
	DateService ds;

	@RequestMapping(value = "/parseDate", method = RequestMethod.POST)
	public ModelAndView getDate(@RequestParam("userInput") String message) throws ParseException, IOException {

		String startDate = ds.getStartDate(message);
		String endDate = ds.getEndDate(startDate);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");

		boolean flag = false;
		flag = eventService.createEvent(startDate, endDate);
		List<String> availableSlots = eventService.suggestEvents();

		mv.addObject("flag", flag);
		mv.addObject("list", availableSlots);

		return mv;
	}

}

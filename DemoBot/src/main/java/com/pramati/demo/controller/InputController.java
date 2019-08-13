package com.pramati.demo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pramati.demo.service.DateService;
import com.pramati.demo.service.EventInsertionService;

@RestController
public class InputController {

	@Autowired
	DateService ds;

	@Autowired
	EventInsertionService eventService;

	@RequestMapping(value = "/parseDate", method = RequestMethod.POST)
	public String getDate(@RequestParam("userInput") String message) throws ParseException, IOException {

		String startDate = ds.getStartDate(message);
		String endDate = ds.getEndDate(startDate);

//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result");

		boolean flag = false;
		flag = eventService.createEvent(startDate, endDate);
		List<String> availableSlots = eventService.suggestEvents();
		
		if(flag)
			return "Successfully created event";
		else
			return "Not success";

//		mv.addObject("flag", flag);
//		mv.addObject("list", availableSlots);
//
//		return mv;
	}

}

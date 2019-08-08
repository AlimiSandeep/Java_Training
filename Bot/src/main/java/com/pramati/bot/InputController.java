package com.pramati.bot;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pramati.service.DateService;
import com.pramati.service.EventInsertionService;

@Controller
public class InputController {

	@Autowired
	DateService ds;
	
	@Autowired
	EventInsertionService eventService;
	
	@RequestMapping("/parseDate")
	public ModelAndView getDate(@RequestParam("userInput") String message) throws ParseException, IOException {

		String startDate = ds.getStartDate(message);
		String endDate = ds.getEndDate(startDate);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		
		
		
		boolean flag=false;
		flag=eventService.createEvent(startDate, endDate);
		List<String> availableSlots=eventService.suggestEvents();
		
		mv.addObject("flag", flag);
		mv.addObject("list", availableSlots);

		return mv;
	}

}

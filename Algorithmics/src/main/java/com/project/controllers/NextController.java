package com.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/next")
public class NextController {

	/**
	 * This method handles /next GET Request.
	 * @param model
	 * @return The next move in JSON format
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String getVideosJSON(Model model) {

		return "jsonTemplate";
	}

}

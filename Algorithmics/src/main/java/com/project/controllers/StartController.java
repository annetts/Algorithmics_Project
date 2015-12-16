package com.project.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.configs.RESTAlgorForm;
import com.project.data.Game;

@Controller
@RequestMapping("/start")
public class StartController {

	/**
	 * this method starts the game
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> getPlayable(@ModelAttribute RESTAlgorForm form) {
		Game.addGame(form.getAlgor1(), form.getAlgor2());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

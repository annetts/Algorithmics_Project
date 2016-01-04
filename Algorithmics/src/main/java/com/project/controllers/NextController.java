package com.project.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.project.configs.RESTGameBoard;
import com.project.data.GameHelper;

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
		List<RESTGameBoard> list = new ArrayList<RESTGameBoard>();
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		String id = attr.getSessionId();
		
		RESTGameBoard board = new RESTGameBoard();
		board.setBoard(GameHelper.getNextTable(id));
		list.add(board);
		
		model.addAttribute("next", list);
		return "jsonTemplate";
	}

}

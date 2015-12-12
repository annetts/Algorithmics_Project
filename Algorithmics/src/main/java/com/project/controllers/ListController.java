package com.project.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.algorithms.Algorithm;
import com.videos.algorithms.AbstractAlgorithm;
import com.videos.algorithms.AlgorithmRegister;

@Controller
@RequestMapping("/list")
public class ListController {
	
	/**
	 * This method handles /list GET Request.
	 * @param model
	 * @return List of algorithms in JSON format
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String getAlgrithmListJSON(Model model) {
		AlgorithmRegister register = new AlgorithmRegister();

		List<Algorithm> list = new LinkedList<Algorithm>();
		
		for (AbstractAlgorithm reg : register.getList()) {
			Algorithm a = new Algorithm();
			a.setName(reg.getName());
			list.add(a);
		}

		model.addAttribute("algorithms", list);
		return "jsonTemplate";
	}

}
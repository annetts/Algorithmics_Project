package com.project.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.configs.RESTAlgorithm;
import com.project.data.AlgorithmRegister;
import com.project.data.algorithms.AbstractAlgorithm;

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

		List<RESTAlgorithm> list = new LinkedList<RESTAlgorithm>();
		
		for (AbstractAlgorithm reg : register.getList()) {
			RESTAlgorithm a = new RESTAlgorithm();
			a.setName(reg.getName());
			list.add(a);
		}

		model.addAttribute("algorithms", list);
		return "jsonTemplate";
	}

}
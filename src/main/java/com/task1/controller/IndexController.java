package com.task1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.task1.request.IndexRequest;
import com.task1.service.PrimeFactorizationService;

@Controller
public class IndexController {

	private PrimeFactorizationService service;
	
	public IndexController(PrimeFactorizationService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String index(@ModelAttribute("request") IndexRequest req, Model model) {
		//htmlファイルの名前を返却
		return "index";
	}
	
	@GetMapping("/judge")
	public String judge(@Validated @ModelAttribute("request") IndexRequest req,
			BindingResult validResult, Model model) {

		if(! validResult.hasErrors()) {
			int val = Integer.valueOf(req.getValue());
			
			List<Integer> result = service.primeFactorization(val);
			
			//Thymeleafに情報を渡す。htmlファイルに${message}が必要
			model.addAttribute("result", result);
		}
		return "index";
	}
}

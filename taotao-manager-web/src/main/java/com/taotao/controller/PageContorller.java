package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Administrator
 *
 */
@Controller
public class PageContorller {
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
}

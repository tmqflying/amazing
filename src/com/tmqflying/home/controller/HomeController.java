/**
 * <b>HomeController.java</b><br>
 *
 * @desc Describe here.
 * @author maoqitao
 * @date 2015年3月25日
 */
package com.tmqflying.home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <b>HomeController</b><br>
 *
 * @desc Describe here.
 * @author maoqitao
 * @date 2015年3月25日 下午8:40:18
 */
@Controller
public class HomeController {

	public HomeController() {
	}

	@RequestMapping(value = "/login/{user}", method = RequestMethod.GET)
	public ModelAndView myMethod(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("user") String user,
			ModelMap modelMap) throws Exception {
		modelMap.put("loginUser", user);
		return new ModelAndView("login/hello", modelMap);
	}

	@RequestMapping(value = "/welcome.html", method = RequestMethod.GET)
	public String welcome() {
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
}

package org.test.varargs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@RequestMapping("/")
	public ModelAndView showPage() {
		return new ModelAndView("index", new ModelMap("obj", new Variable()));
	}
}

/*
 *
 */
package io.swagger.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// TODO: Auto-generated Javadoc
/**
 * Home redirection to swagger api documentation.
 */
@Controller
public class HomeController {

	/**
	 * Index.
	 *
	 * @return the string
	 */
	@RequestMapping(value = "/")
	public String index() {
		System.out.println("/swagger-ui/index.html");
		return "redirect:/swagger-ui/";
	}
}

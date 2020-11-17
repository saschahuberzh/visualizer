package ch.bbw.Visualizer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteController {
	
	@GetMapping("/")
	public String slashController() {
		return "home";
	}

	@GetMapping("/home")
	public String homeController() {
		return "home";
	}
	
	@GetMapping("/about")
	public String aboutController() {
		return "about";
	}
	
	@GetMapping("/visualize")
	public String visualizeController() {
		return "visualize";
	}
	
	@GetMapping("/costumeVisualize")
	public String costumeVisualizeController() {
		return "costumeVisualize";
	}
}

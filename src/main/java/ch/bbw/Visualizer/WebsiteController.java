package ch.bbw.Visualizer;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebsiteController {
	
	ElementHistory elementHistory;
	
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
	public String costumeVisualizeControllerGet(Model model) {
		elementHistory = new ElementHistory();
		model.addAttribute("element", new Element());
		return "costumeVisualize";
	}
	
	@PostMapping("/costumeVisualize")
	public String costumVisualizeCntrollerPost(Model model, @ModelAttribute("element")Element element) {

		elementHistory.addElement(element.getElement());
		model.addAttribute("element", new Element());
		model.addAttribute("elementHistory", elementHistory.getList());
		
		model.addAttribute("testList", overList());
		
		
		return "costumeVisualize";
	}
	
	public ArrayList<String> overList() {
		ArrayList<String> testList = new ArrayList<>();
		
		for(String momentElement : elementHistory.getList()) {
			if(momentElement.equals("class")) {
				//If it has no children
				testList.add("public class classname {}");
				//It it has children
				
			}
			if(momentElement.equals("method")) {
				//If it has no children
				testList.add("private type methodname() {}");
			}
			if(momentElement.equals("attribute")) {
				//System.out.println("here is a atribut");
				testList.add("private type;");
			}
		}
		
		return testList;
	}
}

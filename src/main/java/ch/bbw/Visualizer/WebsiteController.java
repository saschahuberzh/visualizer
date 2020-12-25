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
		model.addAttribute("elementDto", new ElementDto());
		return "costumeVisualize";
	}
	
	@PostMapping("/costumeVisualize")
	public String costumVisualizeControllerPost(Model model, @ModelAttribute("elementDto")ElementDto elementDto) {

		Element element = new Element();
		element.setElementString(elementDto.getElement());
		
		
		int idOfNewElement = elementHistory.getList().size();
		
		if(elementDto.getElementId()==null) {
			//set id if no parent exist
			System.out.println("no parent exist");
			element.setValueForOrder(idOfNewElement + "");
			elementHistory.addElement(element);
		}else {
			//set id if parent exist
			System.out.println("parent exist");
			int idOfChoosen = Integer.parseInt(elementDto.getElementId());
			int idOfChild = elementHistory.getList().get(idOfChoosen).getChildrenElementList().size();
			
			element.setValueForOrder(idOfChoosen + "/" + idOfChild);	
			elementHistory.addElementWith1Parent(idOfChoosen, element);
		}
		
		System.out.println(elementHistory.toString());
		
		
		
		
		model.addAttribute("elementDto", new ElementDto());
		model.addAttribute("elementHistory", elementHistory.getList());
		
		model.addAttribute("testList", overList());
		
		
		return "costumeVisualize";
	}
	
	public ArrayList<String> overList() {
		ArrayList<String> testList = new ArrayList<>();
		
		for(Element momentElement : elementHistory.getList()) {
			if(momentElement.getElementString().equals("class")) {
				
				//If it has no children
				testList.add("public class classname {}");
				//It it has children
				
			}
			if(momentElement.getElementString().equals("method")) {
				//If it has no children
				testList.add("private type methodname() {}");
				//It it has children
				
			}
			if(momentElement.getElementString().equals("attribute")) {
				//System.out.println("here is a atribut");
				testList.add("private type;");
			}
		}
		
		return testList;
	}
}

package landing.CFG2;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {
	@Autowired
	MyJourneysRepository repo;
	
	@GetMapping("/")
	public String hello(Model model) {
		Journey j = new Journey();
		j.setDate(new Date());
		j.setName("name");
		repo.save(j);
		
		//model.addAttribute(
		
		return "index";
	}
	
}

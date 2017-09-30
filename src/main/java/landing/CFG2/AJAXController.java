package landing.CFG2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AJAXController {
	@Autowired
	MyJourneysRepository mRepo;
	@Autowired
	UsersRepository uRepo;
	@Autowired
	JourneysRepository jRepo;
	private User u;
	private static boolean loggedIn = false;
	
	
	@GetMapping("/journey/{id}")
	public @ResponseBody MyJourney index(Model model, @PathVariable("id") Long id) {
		return mRepo.findOne(id);
	}

	
	
}

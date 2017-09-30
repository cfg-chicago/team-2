package landing.CFG2;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {
	@Autowired
	MyJourneysRepository mRepo;
	@Autowired
	UsersRepository uRepo;
	@Autowired
	JourneysRepository jRepo;
	private User u;
	
	@GetMapping("/")
	public String hello(Model model) {
		Journey j = new Journey();
		j.setDate(new Date());
		j.setName("name");
//		repo.save(j);
		
		model.addAttribute("journeys", mRepo.findByUser(u));
		
		return "index";
	}
	
	@PostConstruct
	public void dummy() {
		u = new User();
		u.setName("Jim");
		
		Journey j = new Journey();
		j.setName("climbing");
		
		MyJourney m = new MyJourney();
		m.setDate(new Date(123434));
		m.setJourney(j);
		m.setUser(u);
		m.setName("climbing2");
		
		MyJourney m2 = new MyJourney();
		m2.setName("running");
		m2.setDate(new Date(43563456));
		m2.setUser(u);

		uRepo.save(u);
		jRepo.save(j);
		mRepo.save(m);
		mRepo.save(m2);
		

		
	}
	
}

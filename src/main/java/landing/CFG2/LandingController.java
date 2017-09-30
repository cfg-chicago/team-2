package landing.CFG2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String index(Model model) {
		model.addAttribute("journeys", mRepo.findByUser(u));
		return "index";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("journeys", jRepo.findAll());
		return "add";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@GetMapping("/feed")
	public String feed(Model model) {
		model.addAttribute("journeys", jRepo.findAll());
		return ("feed");
	}
	
	@PostMapping("/addJourney")
	public String journeyPost(@RequestParam("journey")Long journey,@RequestParam("date")String date, 
			@RequestParam("reflect")String reflection, 
			@RequestParam("react")String emoji) throws ParseException {
		MyJourney m = new MyJourney();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		m.setDate(df.parse(date));
		Journey j =jRepo.findOne(journey);
		m.setJourney(j);
		m.setReflection(reflection);
		m.setReaction(emoji);
		j.incrementReaction(emoji);
		m.setName(j.getName());
		m.setUser(u);
		mRepo.save(m);
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String loginPost(@RequestParam("username")String name, @RequestParam("password")String password) {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		uRepo.save(user);
		return "redirect:/";
	}
	
	@PostConstruct
	public void dummy() {
		u = new User();
		u.setName("Jim");
		
		Journey j = new Journey();
		j.setName("climbing");
		
		Journey j2 = new Journey();
		j.setName("running");
		
		
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
		jRepo.save(j2);
		mRepo.save(m);
		mRepo.save(m2); 
	}
	
	
	
	
	
}

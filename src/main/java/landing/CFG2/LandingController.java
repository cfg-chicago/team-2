package landing.CFG2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
	private static boolean loggedIn = false;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("journeys", mRepo.findByUser(u));
		if (loggedIn == false) {
			loggedIn = true;
			return "login";
		}
		return "index";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("journeys", jRepo.findAll());
		return "add";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		loggedIn = true;
		return "login";
	}
	
	@GetMapping("/feed")
	public String feed(Model model) {
		model.addAttribute("journeys", jRepo.findAll());
		return ("feed");
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		loggedIn = false;
		return ("logout");
	}
	
	@GetMapping("/teacher_land")
	public String instructor(Model model) {
		return ("teacher_land");
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
		List<User> list = uRepo.findAll();
		int firstLogin = 1;
		Iterator<User> itr = list.iterator();
		while (itr.hasNext()) {
			User next = itr.next();
			if (next.getName().equals(name)) {
				u = next;
				firstLogin = 0;
				break;
			}
		}
		if (firstLogin == 1) {
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			uRepo.save(user);
			u = user;
		}
		if(u.getName().equals("instructor")) return "redirect:/teacher_land";
		return "redirect:/";
	}
	
	@PostConstruct
	public void dummy() {		
		Journey j = new Journey();
		j.setName("climbing");
		
		Journey j2 = new Journey();
		j2.setName("running");

		jRepo.save(j);
		jRepo.save(j2);
	}
	
	
	
	
	
}

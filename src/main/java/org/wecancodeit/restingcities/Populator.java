package org.wecancodeit.restingcities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class Populator implements CommandLineRunner {
	
	@Autowired
	StateRepository stateRepo;
	
	@Autowired
	CityRepository cityRepo;

	@Override
	public void run(String... args) throws Exception {
		Fish walleye = new Fish("Walleye", "Sander vitreus", "https://upload.wikimedia.org/wikipedia/commons/4/4f/Walleye_painting.jpg");
		
		State ohio = stateRepo.save(new State("Ohio", "oh", "Birthplace of Aviation", "/api/states/oh/cities", walleye));
		
		City columbus = cityRepo.save(new City("Columbus", 860090, ohio));
		City cleveland = cityRepo.save(new City("Cleveland", 385809, ohio));
		City sandusky = cityRepo.save(new City("Sandusky", (25006 - 2), ohio));
	}

}

package org.wecancodeit.restingcities;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	StateRepository stateRepo;

	@RequestMapping("/states")
	public Collection<State> getStates() {
		return (Collection<State>)stateRepo.findAll();
	}

	@RequestMapping("/states/{abbreviation}/cities")
	public Collection<City> getStatesCities(@PathVariable(name = "abbreviation") String abbreviation) {
		return (Collection<City>)stateRepo.findByAbbreviation(abbreviation).getCities();
	}
}

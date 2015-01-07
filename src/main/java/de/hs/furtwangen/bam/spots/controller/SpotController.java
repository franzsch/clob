package de.hs.furtwangen.bam.spots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.hs.furtwangen.bam.spots.model.Spot;
import de.hs.furtwangen.bam.spots.service.SpotService;

@RestController
@RequestMapping(value = "/spot")
public class SpotController {
	
	@Autowired
	private SpotService spotService;
	
	@RequestMapping(value = "/createSpot", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createSpot(@RequestBody Spot spot) {
		System.out.println("spot to be added: " + spot);
		spotService.createSpot(spot);
	}
	
	@RequestMapping(value = "/editSpot", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void editSpot(@RequestBody Spot spot) {
		System.out.println("spot to be changed: " + spot);
		
		spotService.save(spot);
	}
	
	@RequestMapping(value = "/spot/{spotId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	public Spot getSpotById(@PathVariable Integer spotId) {
		System.out.println("Get Spot By Id: " + spotId);
			
		Spot spot = spotService.findOne(spotId);
		spot.setUser(null);
		spot.setActivities(null);
		spot.setAdvertisements(null);
		
		return spot;
	}
	
	@RequestMapping(value = "/spots", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	public Iterable<Spot> getAllSpots(){
		
		return spotService.findAll();
	}
	

}

package de.eier.clueb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.eier.clueb.model.Location;
import de.eier.clueb.service.LocationService;

@RestController
@RequestMapping(value = "/location")
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = "/{zip}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	public Location getLocationByZip(@PathVariable int zip) {
		System.out.println("Get Location/Town by Zip: " + zip);
			
		Location location = locationService.findLocationByZip(zip);
		
		System.out.println("Location Ort: " + location.getOrt());
		
		return location;
	}
	
	@RequestMapping(value = "/locations", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	public Iterable<Location> getLocations(){

		return locationService.findAll();
	}
	
}

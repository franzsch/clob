package de.eier.clueb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.eier.clueb.model.Activity;
import de.eier.clueb.service.ActivityService;

@RestController
@RequestMapping(value = "/activity")
public class ActivityController {
	
	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(value = "/activities/{spotId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	public Iterable<Activity> getAllActivitiesForSpot(@PathVariable Integer spotId)
	{
		System.out.println("Activity Id "+spotId);
		
		return activityService.findBySpotId(spotId);
	}

}

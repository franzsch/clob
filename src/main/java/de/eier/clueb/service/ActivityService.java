package de.eier.clueb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.eier.clueb.model.Activity;
import de.eier.clueb.repository.ActivityRepository;

@Service
public class ActivityService {
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Transactional
	public Iterable<Activity> findBySpotId(Integer id){
		System.out.println("SpotId "+id);
		return activityRepository.findBySpotId(id);
	}

}

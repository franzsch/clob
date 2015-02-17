package de.eier.clueb.service;

import de.eier.clueb.model.Spot;

public interface SpotService {
	
	public Spot createSpot(Spot spot);
	
	public void save(Spot spot);
	
	public Spot findOne(Integer id);
	
	public Iterable<Spot> findAll();

}
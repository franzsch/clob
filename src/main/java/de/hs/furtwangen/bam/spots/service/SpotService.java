package de.hs.furtwangen.bam.spots.service;

import de.hs.furtwangen.bam.spots.model.Spot;

public interface SpotService {
	
	public Spot createSpot(Spot spot);
	
	public void save(Spot spot);

}
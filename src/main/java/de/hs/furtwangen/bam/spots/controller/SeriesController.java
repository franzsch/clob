package de.hs.furtwangen.bam.spots.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/series")
public class SeriesController {
	
	
	
	
	/**
	 * Returns all registered series
	 * @return
	 * @throws InterruptedException 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public Series[] getAllSeries() throws InterruptedException {
		return new Series[]{
				new Series(1, "The walking dead", "USA", "Thriller"), 
				new Series(2, "Homeland", "USA", "Drama")};
	}
}
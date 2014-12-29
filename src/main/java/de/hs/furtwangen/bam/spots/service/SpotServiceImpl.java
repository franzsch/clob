package de.hs.furtwangen.bam.spots.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.hs.furtwangen.bam.spots.model.Spot;
import de.hs.furtwangen.bam.spots.repository.SpotRepository;

@Service
public class SpotServiceImpl implements SpotService {

	@Autowired
	private SpotRepository spotRepository;

	@Transactional
	@Override
	public Spot createSpot(Spot spot) {
		return spotRepository.save(spot);
	}

	@Transactional
	@Override
	public void save(Spot spot) {
		spotRepository.save(spot);
	}
	
	@Transactional(readOnly=true)
	@Override
	public Spot findOne(Integer id){
		return spotRepository.findOne(id);
	}

	
	
}

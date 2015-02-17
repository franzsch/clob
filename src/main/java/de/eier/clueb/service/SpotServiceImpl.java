package de.eier.clueb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.eier.clueb.model.Spot;
import de.eier.clueb.repository.SpotRepository;

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
	
	@Transactional(readOnly=true)
	@Override
	public Iterable<Spot> findAll(){
		return spotRepository.findAll();
	}

	
	
}

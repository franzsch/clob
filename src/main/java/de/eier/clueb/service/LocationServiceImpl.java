package de.eier.clueb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.eier.clueb.model.Location;
import de.eier.clueb.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	@Transactional
	@Override
	public Location createLocation(Location location) {
		return locationRepository.save(location);
	}

	@Transactional
	@Override
	public void save(Location location) {
		locationRepository.save(location);
	}

	@Transactional(readOnly=true)
	@Override
	public Location findOne(Integer id) {
		return locationRepository.findOne(id);
	}

	@Transactional(readOnly=true)
	@Override
	public Iterable<Location> findAll() {
		return locationRepository.findAll();
	}
	
	@Transactional
	@Override
	public Location findLocationByZip(int zip) {
		return locationRepository.findByZip(zip);
	}

}

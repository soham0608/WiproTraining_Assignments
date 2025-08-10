package com.wipro.uber.service;

import com.wipro.uber.dto.Rider;
import com.wipro.uber.entity.Uber;

public interface UberService {
	
	void receiveRiderData(Rider rider);
	void save(Uber uber);

}

package com.wipro.rider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.rider.entity.Rider;
import com.wipro.rider.repo.RiderRepo;
import com.wipro.rider.service.RiderService;
import com.wipro.rider.util.AppConstant;

@Service
public class RiderServiceImpl implements RiderService{
	
	
	@Autowired
	RiderRepo riderRepo;
	
	@Autowired
	KafkaTemplate kafkaTemplate;

	@Override
	public void check(Rider rider) {
		// TODO Auto-generated method stub
		
		rider.setStatus(false);
		rider.setRiderAmount(0);
		rider.setBookingId("0");
		riderRepo.save(rider);
		kafkaTemplate.send(AppConstant.OUTGOING_TOPIC_NAME, rider);
		
	}
	
	
	

}

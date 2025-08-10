package com.wipro.rider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.wipro.rider.entity.Rider;
import com.wipro.rider.repo.RiderRepo;
import com.wipro.rider.util.AppConstant;

@Service
public class RiderListener {
	
	@Autowired
	RiderRepo riderRepo;
	
	@KafkaListener(topics=AppConstant.INCOMING_TOPIC_NAME,groupId="uber-rider")
	void processBankMessage(Rider rider)
	{
		
		System.out.println("--Message Received by rider ="+rider);
		Rider riderDb=riderRepo.findById(rider.getId()).get();
		riderDb.setStatus(rider.isStatus());
		riderDb.setBookingId(rider.getBookingId());
		riderDb.setRiderAmount(rider.getRiderAmount());
		riderRepo.save(riderDb);
		
	}

}

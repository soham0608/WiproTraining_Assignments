package com.wipro.learnproducer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.learnproducer.dto.Learn;
import com.wipro.learnproducer.service.LearnService;

@Service
public class LearnServiceImpl implements LearnService {
	
	@Autowired
	KafkaTemplate<String, Learn> kafkaTemplate;


	@Override
	public void sendData(Learn learn) {
		// TODO Auto-generated method stub
		kafkaTemplate.send("learn-subject", learn);		
	}


//	@Override
//	public void sendData(Learn learn) {
//		// TODO Auto-generated method stub
//		
//	}

}

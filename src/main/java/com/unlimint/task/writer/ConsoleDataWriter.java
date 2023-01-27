package com.unlimint.task.writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unlimint.task.models.OutputData;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ConsoleDataWriter implements DataWriter {
	@Autowired
	private ObjectMapper mapper;

	@Override
	@Async
	public void write(OutputData data) {
		try {
			log.info(mapper.writeValueAsString(data));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}

}

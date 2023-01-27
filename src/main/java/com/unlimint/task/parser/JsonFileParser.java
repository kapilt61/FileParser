package com.unlimint.task.parser;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unlimint.task.models.JsonData;
import com.unlimint.task.models.OutputData;
import com.unlimint.task.writer.DataWriter;

@Service
public class JsonFileParser {

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private DataWriter writer;

	@Async
	public void parse(String file) {
		try {
			List<JsonData> rows = Arrays.asList(mapper.readValue(Paths.get(file).toFile(), JsonData[].class));
			int line = 0;
			for (JsonData row : rows) {
				writeData(row, line, file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void writeData(JsonData row, int line, String file) {
		OutputData data = OutputData.builder().id(row.getOrderId()).orderId(row.getOrderId()).amount(row.getAmount())
				.comment(row.getAmount()).fileName(file).line(line + "").result("OK").build();

		writer.write(data);
	}
}

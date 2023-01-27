package com.unlimint.task.parser;

import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.unlimint.task.models.OutputData;
import com.unlimint.task.writer.DataWriter;

@Service
public class CsvFileParser {
	@Autowired
	private DataWriter writer;

	@Async
	public void parse(String file) {
		try (CSVReader reader = new CSVReader(new FileReader(file))) {
			List<String[]> rows = reader.readAll();
			int i = 0;
			for (String[] row : rows) {
				i++;
				writeData(row, i, file);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void writeData(String[] row, int line, String file) {
		OutputData data = OutputData.builder().id(row[0]).orderId(row[0]).amount(row[1]).comment(row[3]).fileName(file)
				.line(line + "").result("OK").build();

		writer.write(data);
	}

}

package com.unlimint.task.service;

import org.springframework.stereotype.Service;

import com.unlimint.task.parser.CsvFileParser;
import com.unlimint.task.parser.JsonFileParser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParseService {

	private final CsvFileParser csvFileParser;

	private final JsonFileParser jsonFileParser;

	public void parse(String[] args) {

		for (String arg : args) {
			int index = arg.lastIndexOf(".");
			if (index > -1) {
				if ("csv".equals(arg.substring(index+1))) {
					csvFileParser.parse(arg);
				} else if ("json".equals(arg.substring(index+1))) {
					jsonFileParser.parse(arg);
				}
			}

		}

	}

}

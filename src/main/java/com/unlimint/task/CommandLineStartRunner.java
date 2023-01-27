package com.unlimint.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.unlimint.task.service.ParseService;

@Component
public class CommandLineStartRunner implements CommandLineRunner {

	@Autowired
	private ParseService parseService;

    @Override
    public void run(String...args) throws Exception {
    	parseService.parse(args);
    }
}
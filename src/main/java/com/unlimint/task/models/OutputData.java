package com.unlimint.task.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OutputData {

	private String id;
	private String orderId;
	private String amount;
	private String comment;
	private String fileName;
	private String line;
	private String result;

}

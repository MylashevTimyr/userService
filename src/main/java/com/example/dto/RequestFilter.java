package com.example.dto;

import lombok.Data;

@Data
public class RequestFilter {

	private String userName;
	private SortBy sortBy;
	private Integer offset = 0;
	private Integer limit = 5;
}

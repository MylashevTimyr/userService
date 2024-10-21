package com.example.model;

public enum RequestStatus {
	DRAFT(0),
	SENT(1),
	ACCEPTED(2),
	REJECTED(3);

	private final Integer id;

	RequestStatus(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}
}

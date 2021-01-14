package com.demo.domain;

import java.util.UUID;

public class Generic {

	private String id;

	public void setID() {
		this.id = UUID.randomUUID().toString();
	}

}

package com.demo.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User extends Generic {

	private String name;
	private String password;
	private List<Request> requests;
	private List<RequestStage> stages;

	public User() {
		this.requests = new ArrayList<>();
		this.stages = new ArrayList<>();
		super.setID();
	}




}

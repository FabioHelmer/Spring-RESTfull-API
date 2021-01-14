package com.demo.domain;

import java.util.Date;

import com.demo.domain.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestStage extends Generic {

	private String description;
	private Date realizationDate;
	private RequestState state;
	private Request request;
	private User user; 

	public RequestStage() {
		super.setID();
	}
}

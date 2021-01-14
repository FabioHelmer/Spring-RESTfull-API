package com.demo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.demo.domain.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Request extends Generic {

	private String subject;
	private String description;
	private Date creationDate;
	private RequestState state;
	private User user;
	private List<RequestStage> stages;

	public Request() {
		this.stages = new ArrayList<>();
		super.setID();
	}


}

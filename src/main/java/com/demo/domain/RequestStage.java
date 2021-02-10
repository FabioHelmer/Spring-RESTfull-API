package com.demo.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.demo.domain.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "request_stage")
public class RequestStage {

	@Id
	@Column(name = "id", nullable = false, unique = true, length = 38)
	private String id;

	@Column(length = 200, nullable = true, columnDefinition = "text")
	private String description;

	@Column(name = "realization_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date realizationDate;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private RequestState state;

	@ManyToOne
	@JoinColumn(name = "id_request")
	private Request request;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user; 

	public RequestStage() {
		this.id = UUID.randomUUID().toString();
	}

}

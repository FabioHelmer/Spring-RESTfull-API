package com.demo.domain;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.demo.domain.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "request")
public class Request {

	@Id
	@Column(name = "id", nullable = false, unique = true, length = 38)
	private String id;

	@Column(length = 75, nullable = false)
	private String subject;

	@Column(length = 200, nullable = true, columnDefinition = "text")
	private String description;

	@Column(name = "creation_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private RequestState state;

	@ManyToOne
	@JoinColumn(name = "id_owner")
	private User owner;

	@OneToMany(mappedBy = "request")
	private List<RequestStage> requestStages;

	public Request() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public RequestState getState() {
		return state;
	}

	public void setState(RequestState state) {
		this.state = state;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<RequestStage> getRequestStages() {
		return requestStages;
	}

	public void setRequestStages(List<RequestStage> requestStages) {
		this.requestStages = requestStages;
	}

}

package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "user_request")
public class UserRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@JsonIgnore
	@ManyToOne(
			cascade = CascadeType.MERGE,
			fetch = FetchType.LAZY, optional = false
	)
	@JoinColumn(
			name = "user_id",
			referencedColumnName = "id",
			nullable = false
	)
	private User user;

	@Column(
			name = "message",
			columnDefinition = "TEXT",
			nullable = false
	)
	private String message;

	@Column(name = "status", nullable = false)
	@Enumerated(value = EnumType.ORDINAL)
	private RequestStatus status;

	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;
}

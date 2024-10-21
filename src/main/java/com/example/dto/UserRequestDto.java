package com.example.dto;

import com.example.model.RequestStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserRequestDto {

	private Long id;
	private String message;
	private RequestStatus status;
	private LocalDateTime createdDate;
}

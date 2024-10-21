package com.example.controller;

import com.example.dto.RequestFilter;
import com.example.dto.UserFilter;
import com.example.model.RequestStatus;
import com.example.model.User;
import com.example.model.UserRequest;
import com.example.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff/")
public class StaffController extends CommonController {

	@Autowired
	private StaffService staffService;

	@PreAuthorize("hasAuthority('OPERATOR')")
	@GetMapping("getRequests")
	public List<UserRequest> getRequests(RequestFilter filter) {
		return staffService.getRequests(filter);
	}

	@PreAuthorize("hasAuthority('OPERATOR')")
	@PostMapping("updateRequestStatus")
	public boolean updateRequestStatus(@RequestParam long requestId,
	                                   RequestStatus status) {
		return staffService.updateRequestStatus(requestId, status);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("getUsers")
	public List<User> getUsers(UserFilter filter) {
		return staffService.getUsers(filter);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("addRole")
	public boolean addRole(@RequestParam long userId) {
		return staffService.addRole(userId);
	}
}

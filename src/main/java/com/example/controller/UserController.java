package com.example.controller;

import com.example.dto.RequestFilter;
import com.example.dto.UserRequestDto;
import com.example.model.UserRequest;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
@PreAuthorize("hasAuthority('USER')")
public class UserController extends CommonController {

	@Autowired
	private UserService userService;

	@PostMapping("createOrUpdateRequest")
	public Long createOrUpdateRequest(@RequestParam long userId,
	                                  @RequestBody UserRequestDto request) {
		return userService.createOrUpdateRequest(userId, request);
	}

	@GetMapping("getRequests")
	public List<UserRequest> getRequests(@RequestParam long userId,
	                                     RequestFilter filter) {
		return userService.getRequests(userId, filter);
	}

	@GetMapping("getActiveRequest")
	public UserRequest getActiveRequest(@RequestParam long userId) {
		return userService.getActiveRequest(userId);
	}
}

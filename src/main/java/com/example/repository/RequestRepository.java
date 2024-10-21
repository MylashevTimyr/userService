package com.example.repository;

import com.example.model.RequestStatus;
import com.example.model.UserRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RequestRepository extends JpaRepository<UserRequest, Long> {

	@Query(
			value = "SELECT r FROM UserRequest r " +
					"WHERE r.user.id = :userId"
	)
	List<UserRequest> getRequestsByUser(long userId, Pageable pageable);

	@Query(
			value = "SELECT r FROM UserRequest r " +
					"WHERE r.status = :status"
	)
	List<UserRequest> getRequestsByStatus(
			RequestStatus status, Pageable pageable
	);

	@Query(
			value = "SELECT r FROM UserRequest r " +
					"WHERE r.status = :status AND r.user.name LIKE :userName"
	)
	List<UserRequest> getRequestsByStatus(
			RequestStatus status, String userName, Pageable pageable
	);

	@Query(
			value = "SELECT r FROM UserRequest r " +
					"WHERE r.user.id = :userId AND r.status = :status"
	)
	List<UserRequest> getActiveRequest(long userId, RequestStatus status, Pageable pageable);
}

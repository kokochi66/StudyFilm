package com.kokochi.tech.jenkins.service.user.repository;

import com.kokochi.tech.jenkins.domain.user.User;
import com.kokochi.tech.jenkins.domain.user.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {

    List<UserHistory> findAllByUser(User user);
}

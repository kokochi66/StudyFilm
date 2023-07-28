package com.github.kokochi.link.developers.sdk.login.repository;

import com.github.kokochi.link.developers.sdk.login.domain.LineUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LineUserRepository extends JpaRepository<LineUser, Long> {

    Optional<LineUser> findByName(String name);

}

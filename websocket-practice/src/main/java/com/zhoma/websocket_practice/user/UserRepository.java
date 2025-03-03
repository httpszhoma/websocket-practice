package com.zhoma.websocket_practice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, String> {



    Optional<User> findById(String nickname);

    List<User> findAllByStatus(Status status);

}

package com.zhoma.websocket_practice.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public void saveUser(User user) {
        user.setStatus(Status.ONLINE);
        repository.save(user);
    }

    @Transactional
    public void disconnect(User user) {
        User storedUser = repository.findById(user.getNickName())
                .orElseThrow(() -> new UserNotFoundException("User not found: " + user.getNickName()));

        storedUser.setStatus(Status.OFFLINE);
        repository.save(storedUser);
    }

    public List<User> findConnectedUsers() {
        return repository.findAllByStatus(Status.ONLINE);
    }
}

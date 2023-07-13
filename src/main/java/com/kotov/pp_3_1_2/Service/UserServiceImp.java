package com.kotov.pp_3_1_2.Service;

import com.kotov.pp_3_1_2.dao.UserRepository;
import com.kotov.pp_3_1_2.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> showAllUser() {
        return userRepository.getUsers();
    }

    @Transactional
    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUser(long id) {
        return userRepository.getUser(id);
    }

    @Transactional
    @Override
    public void update(User user, long id) {
        userRepository.update(user, id);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userRepository.deleteUser(id);
    }
}

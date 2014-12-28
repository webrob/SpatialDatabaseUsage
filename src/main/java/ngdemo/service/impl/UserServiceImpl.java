package ngdemo.service.impl;


import ngdemo.domain.User;
import ngdemo.repositories.contract.UserRepository;
import ngdemo.service.contract.UserService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class UserServiceImpl implements UserService
{
    @Inject
    private UserRepository userRepository;




    @Override
    public List getAllUsers() {
        return this.userRepository.getAll();
    }

    @Override
    public User getById(int id) {
        return this.userRepository.getById(id);
    }

    @Override
    public User createNewUser(User user) {
        User u = this.userRepository.create(user);
        return u;
    }

    @Override
    public User update(User user) {
        return this.userRepository.update(user);
    }

    @Override
    public void remove(int id) {
        this.userRepository.remove(id);
    }

    @Override
    public int getNumberOfUsers() {
        return this.userRepository.getNumberOfUsers();
    }
}

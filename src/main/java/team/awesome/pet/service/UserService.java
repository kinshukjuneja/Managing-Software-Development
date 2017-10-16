package team.awesome.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import team.awesome.pet.dao.UserDao;
import team.awesome.pet.entity.User;


import java.util.Collection;

@Service
public class UserService {

    @Autowired
    @Qualifier("mockUserDaoImp")
    private UserDao userDao;

    public Collection<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }

    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    public void insertUser(User user) {
        this.userDao.insertUserToDb(user);
    }
    public void removeUserById(int id) {
        this.userDao.removeUserById(id);
    }
}

package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService{
    @Autowired
    UserDao userDao;
    @Override
    public List<User> printAllUsers() {
        return userDao.findAll();
    }
    @Override
    public void addUser(User user) {
        userDao.save(user);
    }
    @Override
    public void deleteUser(Long id) {
        userDao.delete(id);
    }
    @Override
    public User getUserById(Long id) {return userDao.find(id);}
    @Override
    public void editUser(User user) {
        userDao.update(user);
    }
}

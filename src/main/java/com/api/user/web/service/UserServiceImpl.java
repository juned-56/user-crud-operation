package com.api.user.web.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.user.web.model.User;
import com.api.user.web.repository.UserDao;

@Service
public class UserServiceImpl {

	@Autowired
	private UserDao userDao;
	
	public User addNewUser(User usr) {
		return userDao.save(usr);
	}
	
//	public User updateUser(int userId) {
//		//return userDao.save(userId);
//		return userDao.save(userId);
//	}
	
			public User updateUserById(int userId) {
			Optional<User> optionalUser = userDao.findById(userId);
        	if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUserAddress(user.getUserAddress());
            user.setUserEmail(user.getUserEmail());
            user.setUserName(user.getUserName());
            return userDao.save(user);
        } else {
            return null;
        }
    }
	
	public List<User> getAllUsers(){
		return userDao.findAll();
	}
	
	public Optional<User> getUserById(int userId){
		return userDao.findById(userId);
	}
	
	public void deleteUserById(int userId) {
		userDao.deleteById(userId);
	}
}


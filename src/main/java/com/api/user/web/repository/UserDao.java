package com.api.user.web.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.user.web.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	User findByUserId(int userId);

}

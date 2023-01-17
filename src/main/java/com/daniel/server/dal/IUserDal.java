package com.daniel.server.dal;

import com.daniel.server.beans.User;
import com.daniel.server.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserDal extends CrudRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.userType= :ADMIN")
    boolean isUserAdmin(String username, String password);

    @Query("SELECT u FROM UserEntity u WHERE u.userName AND u.password")
    boolean isLoginComplete(String username, String password);

    @Query("SELECT u FROM UserEntity u")
    List<User> getAllUsers(int offset);

    @Query("SELECT u FROM UserEntity ORDER BY u.timeStamp ASC")
    List<User> getAllUsersByTimeStampAscending(int offset);

    @Query("SELECT u FROM UserEntity ORDER BY u.timeStamp DESC")
    List<User> getAllUsersByTimeStampDescending(int offset);
}

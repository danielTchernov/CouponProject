package com.daniel.server.logic;
import com.daniel.server.beans.User;
import com.daniel.server.constants.Constants;
import com.daniel.server.dal.IUserDal;
import com.daniel.server.entities.UserEntity;
import com.daniel.server.enums.ErrorType;
import com.daniel.server.exceptions.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserLogic {

    private IUserDal userDal;

    @Autowired
    public UserLogic(IUserDal userDal) {
        this.userDal = userDal;
    }



    public boolean isAdminLogin(String username, String password) throws ServerException {
        if(!userDal.isUserAdmin(username , password)){
            throw new ServerException(ErrorType.ACCESS_FORBIDEN , "Only admins can access that");
        }
        return true;
    }


    public boolean isLoginComplete(String username, String password) throws ServerException {
       if(!userDal.isLoginComplete(username, password)){
           throw new ServerException(ErrorType.BAD_USER_OR_PASSWORD , "Wrong username or password");
       }
       return true;
    }


    public void createUser(UserEntity user) throws Exception {
        userValidate(user);
        userDal.save(user);
    }

    public void removeUser(long id) throws Exception {
        userDal.deleteById(id);
    }

    public void updateUser (UserEntity user) throws Exception{
        userValidate(user);
        userDal.save(user);
    }

    public UserEntity getUser (long id) throws Exception{
        UserEntity user = userDal.findById(id).get();
        return user;
    }

    public static boolean isUserNameValid(UserEntity user) throws ServerException {
        if(user.getUserName().length() < 4 && user.getUserName().length() > 12){
        throw new ServerException(ErrorType.WRONG_LENGTH , "Wrong length, the username should be between 4-12 charecters.");
        }

        String regex = "^[_A-Za-z0-9-//+]+(\\.[_A-Za-z0-9-]+)"
                +"[_A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.getUserName());
        if(matcher.find() && matcher.group().equals(user.getUserName())) {
            return false;
        }
        return true;
    }

    public List<User> getAllUsers (int page) throws ServerException{
        List<User> users;
        int offset = (page - 1) * Constants.recordsPerPage;
        users = userDal.getAllUsers(offset);
        return users;
    }

    public List<User> getAllUsersByTimeStampAscending (int page) throws ServerException{
        List<User> users;
        int offset = (page - 1) * Constants.recordsPerPage;
        users = userDal.getAllUsersByTimeStampAscending(offset);
        return users;
    }

    public List<User> getAllUsersByTimeStampDescending (int page) throws ServerException{
        List<User> users;
        int offset = (page - 1) * Constants.recordsPerPage;
        users = userDal.getAllUsersByTimeStampDescending(offset);
        return users;
    }

    private static boolean isPasswordValid(UserEntity user) throws ServerException {
        if(user.getPassword().length() < 5){
            return false;
        }
        if (user.getPassword().length() > 15){
            return false;
        }
        return true;
    }

    private static void userValidate(UserEntity user) throws ServerException{
        if(!isUserNameValid(user)){
            throw new ServerException(ErrorType.BAD_USERNAME, "Not allowed charts in the username field!");
        }
        if(!isPasswordValid(user)){
            throw new ServerException(ErrorType.SIZE_BAD_PASSWORD, "Check password length");
        }
    }


}

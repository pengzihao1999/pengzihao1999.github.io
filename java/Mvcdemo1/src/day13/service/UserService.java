package day13.service;

import day13.DOB.UserDob;
import day13.domain.User;

public class UserService {
    public static User find()
    {
    	UserDob ub=new UserDob();
    	return ub.find();
    }
}

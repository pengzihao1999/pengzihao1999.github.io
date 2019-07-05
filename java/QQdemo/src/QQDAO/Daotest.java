package QQDAO;

import java.util.ArrayList;

import QQdomain.User;

public class Daotest {

	public static void main(String[] args) {
			QQDao dao = new QQDao();
			ArrayList<User> ul = dao.load("916811138");
			for(User user:ul){
				System.out.println(user);
			}
	}
}

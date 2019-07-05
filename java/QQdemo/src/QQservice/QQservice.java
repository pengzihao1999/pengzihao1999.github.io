package QQservice;

import java.util.ArrayList;

import QQDAO.QQDao;
import QQdomain.User;

public class QQservice {
	private QQDao qqdao = new QQDao();
	public ArrayList<User> load(String ID) {
		
		return QQDao.load(ID);
	}

}

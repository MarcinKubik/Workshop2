package pl.coderslab.entity;

import pl.coderslab.userdao.UserDao;

public class MainDao {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("Marcin");
        user.setEmail("marcin@gmail.com");
        user.setPassword("coderslab123");

        UserDao userDao = new UserDao();
        userDao.create(user);
    }
}

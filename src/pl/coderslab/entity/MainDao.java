package pl.coderslab.entity;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.userdao.UserDao;

public class MainDao {
    public static void main(String[] args) {

        UserDao userDao = new UserDao();

       /* User usertoUpdate = userDao.read(1);
        usertoUpdate.setEmail("marcin2@gmail.com");
        usertoUpdate.setUserName("Marcin2");
        usertoUpdate.setPassword("user111");*/



        /*User usertoUpdate = userDao.read(3);
        usertoUpdate.setUserName("user6");
        usertoUpdate.setEmail("user6@gmail.com");
        usertoUpdate.setPassword("user6Password");
        userDao.update(usertoUpdate);
        userDao.showAllUsers();
        userDao.delete(3);*/
        /*User newUser = userDao.read(1);
        newUser.setEmail("newUser@gmail.com");
        User user7 = userDao.create(newUser);*/

        User[] all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }

        User newUser2 = userDao.read(2);
        newUser2.setEmail("Mail9@gmail.com");
        newUser2.setPassword("newUserPassword");
        userDao.update(newUser2);


        all =userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }


    }
}

package pl.coderslab.userdao;

import  org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.entity.DbUtil;
import pl.coderslab.entity.User;

import java.sql.*;

public class UserDao {
    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";

    private static final String READ_USER_QUERY =
            "SELECT * FROM users WHERE id = ?";

    private static final String UPDATE_USER_QUERY =
            "UPDATE users SET email =?, username = ?, password = ? WHERE id =?";

    private static final String DELETE_USER_QUERY =
            "DELETE FROM users WHERE Id = ?";

    public String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public  User create(User user){
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()){
                user.setId(resultSet.getInt(1));
            }

            return user;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
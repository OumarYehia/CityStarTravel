package com.citystarstourseg.backend.Services;

import com.citystarstourseg.backend.DAOs.User;
import com.citystarstourseg.backend.Database.UserCRUD;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UserService {

    private Encryption encryption;
    private User user;
    private UserCRUD userCRUD;

    // constructor for user sign up
    public UserService(String userName, String fullName, String emailAddress,
                       String password, String mobileNumber, String roleID) throws NoSuchAlgorithmException {
        this.encryption = new Encryption("hard");
        String[] passwordAlterations = getPasswordAlterations(password); // [0]: salt, [1]: hash
        int roleIDint = Integer.parseInt(roleID);
        user = new User(userName,fullName,emailAddress,passwordAlterations[0], passwordAlterations[1],mobileNumber,roleIDint, LocalDateTime.now());
        userCRUD = new UserCRUD();
    }

    // constructor for sign in
    public UserService () {
        userCRUD = new UserCRUD();
    }

    /**
     *
     * @param password: Takes String input (password) and produces the corresponding salt and hash
     * @return String[] containing salt at [0] and hash at [1]
     * @throws NoSuchAlgorithmException if hashing algorithm could not be found
     */
    private String[] getPasswordAlterations(String password) throws NoSuchAlgorithmException {
        return encryption.encrypt(password, null);
    }

    public int createUser() throws SQLException {
        return userCRUD.createRecords(user);
    }

    public int signInCheck(String username, String password) throws SQLException, NoSuchAlgorithmException {
        String[] encryptedPassword = userCRUD.getUserPasswordHash(username); // get salt and hash from DB for comparison
        if(encryptedPassword[0].equals("-1") && encryptedPassword[1].equals("-1") ) { // username not found
            return -1;
        }
        else { // username found
            // TODO: Compare password entered (param: password) hashed with obtained salt(param: encryptedPassword[0]) with hash value obtained (param: encryptedPassword[1])
            String[] testedPasswordHash = encryption.encrypt(password, encryptedPassword[0].getBytes());
            if(encryptedPassword[1].equals(testedPasswordHash[1])){
                return 1;
            }
            return -1;
        }
    }
}

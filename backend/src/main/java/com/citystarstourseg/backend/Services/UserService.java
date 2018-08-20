package com.citystarstourseg.backend.Services;

import com.citystarstourseg.backend.DAOs.User;
import com.citystarstourseg.backend.Database.UserCRUD;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class UserService {

    private Encryption encryption;
    private User user;
    private UserCRUD userCRUD;

    // constructor for user sign up
    public UserService(String userName, String fullName, String emailAddress,
                       String password, String mobileNumber, String roleID) throws NoSuchAlgorithmException {
        this.encryption = new Encryption("hard");
        List<byte[]> passwordAlterations = getPasswordAlterations(password); // [0]: salt, [1]: hash
        int roleIDint = Integer.parseInt(roleID);

        //              str     ,str     ,str         ,bytes (salt)                     ,str(hash)              ,str         ,int
        this.user = new User(userName,fullName,emailAddress,passwordAlterations.get(0), new String(passwordAlterations.get(1)),mobileNumber,roleIDint, LocalDateTime.now());
        this.userCRUD = new UserCRUD();
    }

    public UserService(User user) {
        this.encryption = new Encryption("hard");
        this.user = user;
        this.userCRUD = new UserCRUD();
    }

    // constructor for sign in
    public UserService () {
        userCRUD = new UserCRUD();
        this.encryption = new Encryption("hard");

    }

    /**
     *
     * @param password: Takes String input (password) and produces the corresponding salt and hash
     * @return String[] containing salt at [0] and hash at [1]
     * @throws NoSuchAlgorithmException if hashing algorithm could not be found
     */
    private List<byte[]> getPasswordAlterations(String password) throws NoSuchAlgorithmException {
        return encryption.encrypt(password, null);
    }

    public int createUser() throws SQLException {

        return userCRUD.createRecords(user);
    }

    public int signIn(String username, String password) throws SQLException, NoSuchAlgorithmException {
        List<byte[]> encryptedPassword = userCRUD.getUserPasswordSaltAndHash(username); // get salt and hash from DB for comparison
        if(encryptedPassword.isEmpty()) // user not found
            return -1;
        byte[] passwordSalt = encryptedPassword.get(0), passwordHash = encryptedPassword.get(1);
        List<byte[]>  testedPasswordHash = encryption.encrypt(password, passwordSalt); // [0]: salt, [1]: hash password
        if(Arrays.equals(passwordHash,testedPasswordHash.get(1)))
            return 1;
        return -1;
    }
}

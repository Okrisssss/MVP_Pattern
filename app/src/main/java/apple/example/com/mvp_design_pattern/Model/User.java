package apple.example.com.mvp_design_pattern.Model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class User implements IUser {

    private String email;
    private String password;

    public User(String mail, String password) {
        this.email = mail;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {

        //0. Check email is empty
        //1. Check email is matches pattern
        //2. Check password length < 6


        if (TextUtils.isEmpty(getEmail()))
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        else if (getPassword().length() < 6)
            return 2;
        else
            return -1;
    }
}

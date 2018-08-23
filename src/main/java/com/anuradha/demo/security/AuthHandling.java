package com.anuradha.demo.security;


import com.anuradha.demo.exception.JerseyException;
import com.anuradha.demo.exception.PMException;
import com.anuradha.demo.filter.role.Role;
import com.anuradha.demo.model.Login;
import com.anuradha.demo.model.ResponseLogin;
import com.anuradha.demo.model.User;
import com.anuradha.demo.service.AuthenticationService;
import com.anuradha.demo.util.ResponseMessage;
import com.anuradha.demo.util.RestClient;
import com.anuradha.demo.util.Util;
import com.anuradha.demo.util.Validation;
import org.json.JSONObject;

import java.util.UUID;

public class AuthHandling {
    public ResponseLogin loginUser(Login login) {
        if (!new Validation().isValidEmail(login.getEmail())) {
            throw new PMException("Please enter valid email address");
        }
        AuthenticationService service = new AuthenticationService();
        User userByEmail = service.getUserByEmail(login.getEmail());
        if (userByEmail == null) {
            throw new PMException("Email does not exsits");
        }
        if (userByEmail.getPassword() != null) {
//            encrypt password here
//            login.getPassword() -> encrypt password
            if (!login.getPassword().equals(userByEmail.getPassword())) {
                throw new PMException("Incorrect password");
            }

        }
        ResponseLogin responseLogin = new ResponseLogin();
        responseLogin.setUserId(userByEmail.getUser_id());
        responseLogin.setSecretKey(UUID.randomUUID().toString().replaceAll("-", ""));
        String token = new Util().createJWT(Integer.toString(userByEmail.getUser_id()), responseLogin.getSecretKey(), Role.GUEST);
        responseLogin.setToken(token);
        return responseLogin;
    }

    public ResponseLogin createUser(User user) {

        AuthenticationService service = new AuthenticationService();

        if (user.getProvider() == 0) {
            /**
             *User login by creating own user account
             */
            if (!new Validation().isValidEmail(user.getEmail())) {
                throw new JerseyException(ResponseMessage.INVALID_EMAIL_ADDRESS.getMessage());
            }
            user.setSalt(new Util().getSalt(30));
            user.setEncPassword(new Util().getEncPassword(user.getPassword(), user.getSalt()));

        } else if (user.getProvider() == 1) {
            /**
             * User authenticate via facebook
             */
            String res = new RestClient("https://graph.facebook.com/v3.1/me?fields=id,name,gender,email", user.getToken()).getResponse();
            JSONObject jsonObject = new JSONObject(res);
            String names[] = jsonObject.getString("name").split(" ");

            user.setName(names[0]);
//            .replace("\\u0040", "@")
            user.setEmail(jsonObject.getString("email"));

            System.out.println("\n\n"+user.getEmail()+"\n\n");

        } else if (user.getProvider() == 2) {
            /**
             * User authenticate via google
             **/
//            https://www.googleapis.com/oauth2/v3/token
//            https://www.googleapis.com/oauth2/v1/userinfo?access_token=xxx
//            https://www.googleapis.com/drive/v3/about?fields=user
            String res = new RestClient("https://www.googleapis.com/oauth2/v1/userinfo?access_token=user", user.getToken()).getResponse();

            JSONObject jsonObject1 = new JSONObject(res);
//            JSONObject jsonObject = new JSONObject(res).getJSONObject("xxx");
            String names[] = jsonObject1.getString("name").split(" ");

            user.setName(names[0]);
            user.setImgUrl(jsonObject1.getString("picture"));
            user.setEmail(jsonObject1.getString("email"));
        }
        user.setToken(null);
        user.setAddedDate(new Util().getFullDate());
        /**
         * Add user to the repository via service
         */
        user = service.addUser(user);

        /**
         * create response login
         */
        ResponseLogin response = new ResponseLogin();
        response.setUserId(user.getUser_id());
        response.setSecretKey(UUID.randomUUID().toString().replaceAll("-", ""));
        response.setToken(new Util().createJWT(Integer.toString(user.getUser_id()), response.getSecretKey(), Role.GUEST));

        return response;
    }
}

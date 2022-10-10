/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author user
 */
public class AccountService {

    public User login(String username, String password) {
        if ((username.equals("abe") || username.equals("barb")) && password.equals("password")) {
            User user = new User(username, null);
            return user;
        } else {
            return null;
        }
    }

    public class User {

        private String username;
        private String password;

        public User() {
            username = "";
            password = "";
        }

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }

}

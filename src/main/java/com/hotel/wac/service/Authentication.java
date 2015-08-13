package com.hotel.wac.service;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 */
public interface Authentication {

    /**
     * register new user
     * @param email - user's email
     * @param password -  user's password
     */
    void register (String email, String password);

    /**
     * Log in user with unique token
     * @param email - user's email
     * @param password -  user's password
     * @return - session token
     */
    String login (String email, String password);

    /**
     * Log out user
     * @param token - user's session token
     * @return token to be logged out
     */
    String logout (String token);

    /**
     *
     * @param email - user's email
     * @param newPassword - user's new password
     */
    void recoverPassword(String email, String newPassword);

}

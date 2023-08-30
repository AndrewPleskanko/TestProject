package com.example.userList.dataDefinition;

public interface ErrorData {

    String ERROR_FIRST_NAME_DESCRIPTION = " Invalid firstName format. Name must be at least 3 characters long";
    String ERROR_LAST_NAME_DESCRIPTION = "Invalid lastName format. Surname must be at least 3 characters long";
    String ERROR_LOGIN_DESCRIPTION = "Please enter a valid Gmail address!";
    String ERROR_PASSWORD_DESCRIPTION = "Invalid password format. Password must be at least 3 characters long";
    String ERROR_USER_NOT_FOUND = "User not found. Try write something else";
    String ERROR_LOGIN_OR_PASS = "Incorrect login or password";
    String ERROR_CONNECTING_TO_DATABASE = "Error connecting to the database";
    String ERROR_LOADING_DATABASE_PROPERTIES = "Error loading database properties";
    String LOG_ERROR_CREATING_USER = "Error creating user";
    String LOG_ERROR_DELETING_USER = "Error deleting user";
    String LOG_ERROR_CHECKING_USER_EXISTENCE = "Error checking user existence";
    String LOG_ERROR_CHECKING_EMAIL_EXISTENCE = "Error checking email existence";
    String LOG_ERROR_UPDATING_USER = "Error updating user";
    String ERROR_NAME = "errorName";
    String ERROR_SURNAME = "errorSurname";
    String ERROR_LOGIN = "errorLogin";
    String ERROR_PASSWORD = "errorPassword";
    String ERROR_CONNECTION_DATABASE = "No connection to the database";

}

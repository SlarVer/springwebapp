package by.kasakovich.springwebapp.constants;

public class ApplicationStringConstants {
    public static final String PREFIX = "/WEB-INF/pages/";
    public static final String SUFFIX = ".jsp";
    public static final String BASE_PACKAGES = "by.kasakovich.springwebapp";

    public static final String HIBERNATE_PROPERTY_SOURCE = "classpath:db.properties";
    public static final String JDBC_PROPERTY_DRIVER_CLASSNAME = "jdbc.driverClassName";
    public static final String JDBC_PROPERTY_URL ="jdbc.url";
    public static final String JDBC_PROPERTY_USERNAME ="jdbc.username";
    public static final String JDBC_PROPERTY_PASSWORD="jdbc.password";

    public static final String USERS_TABLE_NAME = "users";
    public static final String USERS_COLUMN_ID = "id";
    public static final String USERS_COLUMN_USERNAME = "username";
    public static final String USERS_COLUMN_PASSWORD ="password";
    public static final String USERS_COLUMN_NAME = "name";
    public static final String USERS_COLUMN_EMAIL = "email";
    public static final String USERS_COLUMN_ROLE = "role";

    public static final String QUERY_TABLE_NAME = "query";
    public static final String QUERY_COLUMN_ID = "id";
    public static final String QUERY_COLUMN_QUERY = "query";
    public static final String QUERY_COLUMN_USER ="user";
    public static final String QUERY_COLUMN_RESULT ="result";

    public static final String SQL_PATH = "../../src/main/resources/sql/firstInitialization.sql";

    public static final String MODEL ="model";

}


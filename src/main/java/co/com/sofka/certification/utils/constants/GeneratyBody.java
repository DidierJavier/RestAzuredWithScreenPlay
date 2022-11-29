package co.com.sofka.certification.utils.constants;

public class GeneratyBody {

    public static final String USER_NAME = "admin";

    public static final String PASSWORD = "password123";

    public static String bodyGetToken(){
        return "{\"username\" :\"" + USER_NAME + "\",\"password\" : \"" + PASSWORD + "\"}";
    }

}

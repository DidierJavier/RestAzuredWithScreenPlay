package co.com.sofka.certification.utils.constants;

import co.com.sofka.certification.models.BookData;

public class GeneratyBody {

    public static final String USER_NAME = "admin";

    public static final String PASSWORD = "password123";

    public static String bodyGetToken(){
        return "{\"username\" :\"" + USER_NAME + "\",\"password\" : \"" + PASSWORD + "\"}";
    }

    public static String bodyUpdateBook(BookData data){
        return  "{\"firstname\" : \"" + data.getFirstname() + "\",\"lastname\" :\"" + data.getLastname() +
                "\",\"totalprice\" :\"" + data.getTotalprice() + "\",\"depositpaid\" :\"" + data.getDepositpaid() +
                "\",\"bookingdates\" : {\"checkin\" : \"" + data.getBookingdates().getCheckin() +
                "\",\"checkout\" :\"" + data.getBookingdates().getCheckout() +
                "\"},\"additionalneeds\" :\"" + data.getAdditionalneeds() +
                '}';
    }

}

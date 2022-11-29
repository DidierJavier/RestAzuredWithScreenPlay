package co.com.sofka.certification.questions;

import co.com.sofka.certification.models.BookData;
import co.com.sofka.certification.models.BookResponse;
import co.com.sofka.certification.utils.FieldsResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.certification.utils.constants.Constants.RESPONSE_GET_BOOK;
import static co.com.sofka.certification.utils.constants.Constants.RESPONSE_UPDATE_BOOK;

public class BookDataResponse implements Question<String> {

    private FieldsResponse field;

    private String nameSessionVble;

    public BookDataResponse(FieldsResponse field, String nameSessionVble) {
        this.field = field;
        this.nameSessionVble = nameSessionVble;
    }

    public static BookDataResponseBuilder extract(FieldsResponse field) {

        return new BookDataResponseBuilder(field);
    }

    @Override
    public String answeredBy(Actor actor) {

        BookData bookData = null;
        BookResponse bookResponse = null;

        switch (nameSessionVble){
            case RESPONSE_UPDATE_BOOK:
                bookData = actor.recall(nameSessionVble);
                break;
            case RESPONSE_GET_BOOK:
                bookResponse = actor.recall(nameSessionVble);
                break;
        }

        switch (field){
            case FIRST_NAME:
                return  bookData == null ? bookResponse.getFirstname() : bookData.getFirstname();
            case LAST_NAME:
                return  bookData == null ? bookResponse.getLastname() : bookData.getLastname();
            case TOTAL_PRICE:
                return  bookData == null ? Double.toString(bookResponse.getTotalprice()) : Double.toString(bookData.getTotalprice());
            case DEPOSIT_PAID:
                return  bookData == null ? Boolean.toString(bookResponse.getDepositpaid()) : Boolean.toString(bookData.getDepositpaid());
            case CHECKIN:
                return  bookData == null ? bookResponse.getBookingdates().getCheckin() : bookData.getBookingdates().getCheckin();
            case CHECKOUT:
                return  bookData == null ? bookResponse.getBookingdates().getCheckout() : bookData.getBookingdates().getCheckout();
            case ADDITIONALNEEDS:
                return  bookData == null ? bookResponse.getAdditionalneeds() : bookData.getAdditionalneeds();
            default:
                throw new RuntimeException();
        }
    }
}

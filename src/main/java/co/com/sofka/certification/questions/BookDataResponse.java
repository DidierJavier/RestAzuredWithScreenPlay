package co.com.sofka.certification.questions;

import co.com.sofka.certification.models.BookResponse;
import co.com.sofka.certification.utils.FieldsResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.certification.utils.constants.Constants.RESPONSE_GET_BOOK;

public class BookDataResponse implements Question<String> {

    private FieldsResponse field;

    public BookDataResponse(FieldsResponse field) {
        this.field = field;
    }

    public static BookDataResponse extract(FieldsResponse field) {
        return new BookDataResponse(field);
    }

    @Override
    public String answeredBy(Actor actor) {
        BookResponse resp = actor.recall(RESPONSE_GET_BOOK);

        switch (field){
            case FIRST_NAME:
                return  resp.getFirstname();
            case LAST_NAME:
                return  resp.getLastname();
            case TOTAL_PRICE:
                return Double.toString(resp.getTotalprice());
            case DEPOSIT_PAID:
                return Boolean.toString(resp.getDepositpaid());
            case CHECKIN:
                return  resp.getBookingdates().getCheckin();
            case CHECKOUT:
                return  resp.getBookingdates().getCheckout();
            case ADDITIONALNEDDS:
                return  resp.getAdditionalneeds();
            default:
                throw new RuntimeException();
        }
    }
}

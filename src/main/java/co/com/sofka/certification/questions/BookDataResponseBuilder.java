package co.com.sofka.certification.questions;

import co.com.sofka.certification.utils.FieldsResponse;

public class BookDataResponseBuilder {

    private FieldsResponse field;
    public BookDataResponseBuilder(FieldsResponse field) {
        this.field = field;
    }

    public BookDataResponse from(String nameSessionVble){
        return new BookDataResponse(this.field, nameSessionVble);
    }
}

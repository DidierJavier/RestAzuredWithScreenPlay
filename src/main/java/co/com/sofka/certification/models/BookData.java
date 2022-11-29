package co.com.sofka.certification.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class BookData {

    public String idBook;

    @SerializedName("firstname")
    @Expose
    public String firstname;
    @SerializedName("lastname")
    @Expose
    public String lastname;
    @SerializedName("totalprice")
    @Expose
    public Double totalprice;
    @SerializedName("depositpaid")
    @Expose
    public Boolean depositpaid;
    @SerializedName("bookingdates")
    @Expose
    public Bookingdates bookingdates;
    @SerializedName("additionalneeds")
    @Expose
    public String additionalneeds;

    public Bookingdates getBookingdates() {
        return bookingdates == null ? new Bookingdates() : bookingdates;
    }
}

package Pojos;

public class BookingResponsePojo {
    /* "bookingid": 13,
								    "booking": {
								        "firstname": "Eric",
								        "lastname": "Ericson",
								        "totalprice": 900,
								        "depositpaid": false,
								        "bookingdates": {
								            "checkin": "2021-01-07",
								            "checkout": "2021-01-25"
								        }
								     }
								  }

     */
    private int bookingid;
    private BookingPojo booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    public BookingResponsePojo() {
    }

    public BookingResponsePojo(int bookingid, BookingPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingResponsePojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}

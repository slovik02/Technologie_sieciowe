package ib.ts_2.controller;

import java.sql.Date;
import java.time.LocalDate;

public class LoanRequest {
    private long userId;
    private long bookId;
    private Date rentalDate;
    private Date endDate;
    private Date returnDate;

    // Getters and setters
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = Date.valueOf(rentalDate);
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = Date.valueOf(endDate);
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = Date.valueOf(returnDate);
    }
}

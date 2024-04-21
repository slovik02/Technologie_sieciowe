package ib.ts_2.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class Loan {
    /**
     * Represents a loan entity in the system
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer LoanId;

    private Date rentalDate;

    private Date endDate;

    private Date returnDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Integer getLoanId() {
        return LoanId;
    }

    public void setLoanId(Integer loanId) {
        LoanId = loanId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

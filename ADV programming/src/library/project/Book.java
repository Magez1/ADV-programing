/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.project;

import java.util.Date;

/**
 *
 * @author Hadahya salem
 */
class Book {
   private int id;
    private String name;
    private String category;
    private boolean borrowed;
    private int borrowingPeriod;
    private Date borrowingDate;

    public Book(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.borrowed = false;
        this.borrowingPeriod = 0;
        this.borrowingDate = null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public int getBorrowingPeriod() {
        return borrowingPeriod;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void setBorrowingPeriod(int borrowingPeriod) {
        this.borrowingPeriod = borrowingPeriod;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }
}
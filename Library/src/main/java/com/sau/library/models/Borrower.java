package com.sau.library.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "borrower")
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "checkoutDate")
    private Date checkout_date;
    @Column(name = "returnDate")
    private Date return_date;
    @Column(name = "isReturned")
    private boolean is_returned;
    @Column(name = "isDeleted")
    private boolean is_deleted;

    @ManyToOne
    //@JoinTable(name = "member")
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne
    //@JoinTable(name = "book")
    @JoinColumn(name = "book_id")
    private Book book;


}

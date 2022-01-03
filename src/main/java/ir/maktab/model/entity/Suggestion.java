package ir.maktab.model.entity;

import ir.maktab.model.entity.users.Expert;

import java.util.Date;

public class Suggestion {
    private Integer id;
    private Expert expert;
    private Date registrationDate;
    private Long proposedPrice;
    private int durationOfWork;
    private Date startTime;
}

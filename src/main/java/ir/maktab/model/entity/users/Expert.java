package ir.maktab.model.entity.users;

import ir.maktab.model.entity.services.SubService;

import java.util.Set;

public class Expert extends User {
    private byte[] photo;
    private double score;
    private Set<SubService> services;
}

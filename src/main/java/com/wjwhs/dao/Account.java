package com.wjwhs.dao;

import java.io.Serializable;

public class Account implements Serializable {
    private int id;
    private String type;
    private String status;
    private Double balance;
    private int personId;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", balance=" + balance +
                ", personId=" + personId +
                '}';
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }


}

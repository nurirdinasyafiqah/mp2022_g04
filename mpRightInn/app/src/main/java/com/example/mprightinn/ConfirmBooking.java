package com.example.mprightinn;

public class ConfirmBooking {
    public String name;
    public String phoneNo;
    public String totalGuest;
    public String roomType;
    public String date;
    public String totalPrice;
    public String duration;
    public String numberRoom;

    public ConfirmBooking(String name, String phoneNo, String totalGuest, String roomType, String date, String totalPrice, String duration, String numberRoom) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.totalGuest = totalGuest;
        this.roomType = roomType;
        this.date = date;
        this.totalPrice = totalPrice;
        this.duration = duration;
        this.numberRoom = numberRoom;
    }

    public ConfirmBooking() {
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getTotalGuest() {
        return totalGuest;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getDate() {
        return date;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public String getDuration() {
        return duration;
    }

    public String getNumberRoom() {
        return numberRoom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setTotalGuest(String totalGuest) {
        this.totalGuest = totalGuest;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setNumberRoom(String numberRoom) {
        this.numberRoom = numberRoom;
    }
}

package ru.aldi_service.courier;

import android.app.Activity;
import android.content.Context;


/**
 * Created by alx on 29.11.15.
 * New interface 06.12.15
 */
public class Waybill {
    private String waybill,address,addressee,contactPerson,geography,phone,acceptedBy,info,comment,deliveryDate;
    private int id,deliveryListId,nItems,urgency,status;
    private float weight,costOfDelivery,addresseePayment,additionalPayment;
    void setWaybill(String w) {
        waybill=w;
    }
    void setAddress(String a) {
        address=a;
    }
    void setAddressee(String ad) {
        addressee=ad;
    }
    void setContactPerson(String cp) {
        contactPerson=cp;
    }
    void setGeography(String g) {
        geography=g;
    }
    void setPhone(String ph) {
        phone=ph;
    }
    void setAcceptedBy(String ab) {
        acceptedBy=ab;
    }
    void setInfo(String i) {
        info=i;
    }
    void setUrgency(int u) {
        urgency=u;
    }
    void setComment(String c) {
        comment=c;
    }
    void setDeliveryDate(String dd) {
        deliveryDate=dd;
    }
    void setId(int i) {
        id=i;
    }
    void setDeliveryListId(int dli) {
        deliveryListId=dli;
    }
    void setnItems(int ni){
        nItems=ni;
    }
    void setStatus(int s){
        status=s;
    }
    void setWeight(float w){
        weight=w;
    }
    void setCostOfDelivery(float cod) {
        costOfDelivery=cod;
    }
    void setAddresseePayment(float ap) {
        addresseePayment=ap;
    }
    void setAdditionalPayment(float adp){
        additionalPayment=adp;
    }
    String getWaybill(){
        return waybill;
    }
    String getAddressee(){
        return addressee;
    }
    String getAddress(){
        return address;
    }
    int getId(){
        return id;
    }
    int getUrgency(){
        return urgency;
    }
    String getDeliveryDate(){
        return deliveryDate;
    }
    Context con;
    public Waybill( int i, String wn, String addrs, String addr, int urg, String dd) {
        waybill=wn;
        id=i;
        addressee=addrs;
        address=addr;
        urgency=urg;
        deliveryDate=dd;
    }
}

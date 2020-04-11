package ru.billing.stocklist;

import java.util.Date;
import java.util.Objects;

public class FoodItem extends GenericItem implements Cloneable {

    public Date getDateOfIncome() {
        return dateOfIncome;
    }

    public void setDateOfIncome(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    public short getExpires() {
        return expires;
    }

    public void setExpires(short expires) {
        this.expires = expires;
    }



    private Date dateOfIncome = new Date();
    private short expires;



    public FoodItem(String name, float price, short expires, FoodItem analogue, Date dateOfIncome) {
        this.setName(name);
        this.setPrice(price);
        this.dateOfIncome = dateOfIncome;
        this.setAnalogue(analogue);
        this.expires = expires;
    }

    public FoodItem(String name, float price, short expires) {
        this(name, price, expires, null, new Date());
    }

    public FoodItem() {}

    public FoodItem(String name) {
        this(name, 0.0f, (short) 0, null, new Date());
    }

    public FoodItem(int ID, String name, float price, GenericItem analogue, short expires) {
        super(ID, name, price, analogue);
        this.expires = expires;
    }

    @Override
    public void printAll() {
        System.out.println("ID: " + getID() + " , Name: " + getName() + " , Price: " + getPrice() + " , Analogue: " + getAnalogue() + " , Category: " + getCategory() + " , Date of income: " + dateOfIncome + " , Expires: " + expires);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FoodItem foodItem = (FoodItem) o;
        return expires == foodItem.expires &&
                Objects.equals(dateOfIncome, foodItem.dateOfIncome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dateOfIncome, expires);
    }

    @Override
    public Object clone() {
        FoodItem foodItem = new FoodItem();

        foodItem.setID(this.getID());
        foodItem.setName(this.getName());
        foodItem.setPrice(this.getPrice());
        foodItem.setAnalogue(this.getAnalogue());
        foodItem.setCategory(this.getCategory());
        foodItem.dateOfIncome = this.dateOfIncome;
        foodItem.expires = this.expires;

        return foodItem;
    }

    @Override
    public String toString() {
        return this.getID() + " - " + this.getName() + " - " + this.getPrice() + " - " + this.getAnalogue() + " - " + this.getCategory() + " - " + this.dateOfIncome + " - " + this.expires;
    }

}

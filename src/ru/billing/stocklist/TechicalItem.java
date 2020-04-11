package ru.billing.stocklist;

import java.util.Objects;

public class TechicalItem extends GenericItem implements Cloneable {

    public short getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(short warrantyTime) {
        this.warrantyTime = warrantyTime;
    }



    private short warrantyTime;



    public TechicalItem(int ID, String name, float price, GenericItem analogue, short warrantyTime) {
        super(ID, name, price, analogue);
        this.warrantyTime = warrantyTime;
    }

    public TechicalItem(){}

    @Override
    public void printAll() {
        System.out.println("ID: " + getID() + " , Name: " + getName() + " , Price: " + getPrice() + " , Analogue: " + getAnalogue() + " , Category: " + getCategory() + " , Warranty time: " + warrantyTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TechicalItem that = (TechicalItem) o;
        return warrantyTime == that.warrantyTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), warrantyTime);
    }

    @Override
    public Object clone() {
        TechicalItem techicalItem = new TechicalItem();

        techicalItem.setID(this.getID());
        techicalItem.setName(this.getName());
        techicalItem.setPrice(this.getPrice());
        techicalItem.setAnalogue(this.getAnalogue());
        techicalItem.setCategory(this.getCategory());
        techicalItem.warrantyTime = this.warrantyTime;

        return techicalItem;
    }

    @Override
    public String toString() {
        return this.getID() + " - " + this.getName() + " - " + this.getPrice() + " - " + this.getAnalogue() + " - " + this.getCategory() + " - " + this.warrantyTime;
    }
}

package ru.billing.stocklist;

import java.util.Objects;

public class GenericItem implements Cloneable {

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public GenericItem getAnalogue() {
        return analogue;
    }

    public void setAnalogue(GenericItem analogue) {
        this.analogue = analogue;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



    private int ID;
    private String name;
    private float price;
    private GenericItem analogue;
    private Category category = Category.GENERAL;

    static int currentID = 1;



    public GenericItem(String name, float price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;

        this.ID = GenericItem.currentID++;
    }

    public GenericItem(String name, float price, GenericItem analogue) {
        this();
        this.name = name;
        this.price = price;
        this.analogue = analogue;
    }

    public GenericItem() {
        this.ID = GenericItem.currentID++;
    }

    public GenericItem(int ID, String name, float price, GenericItem analogue) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.analogue = analogue;

        GenericItem.currentID++;
    }

    public void printAll() {
        System.out.println("ID: " + ID + " , Name: " + name + " , Price: " + price + " , Analogue: " + analogue + " , Category: " + category);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericItem that = (GenericItem) o;
        return ID == that.ID &&
                Float.compare(that.price, price) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(analogue, that.analogue) &&
                category == that.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, price, analogue, category);
    }

    public Object clone() {
        GenericItem genericItem = new GenericItem();

        genericItem.ID = this.ID;
        genericItem.name = this.name;
        genericItem.price = this.price;
        genericItem.analogue = this.analogue;
        genericItem.category = this.category;

        return genericItem;
    }

    @Override
    public String toString() {
        return this.ID + " - " + this.name + " - " + this.price + " - " + this.analogue + " - " + this.category;
    }
}

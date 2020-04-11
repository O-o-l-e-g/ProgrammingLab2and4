package ru.billing.client;

import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.ItemCatalog;
import ru.billing.stocklist.TechicalItem;
import ru.billing.stocklist.Category;

import java.util.Date;

class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        GenericItem firstItem = new GenericItem(001, "Toy1", 12.99f, null);
        firstItem.printAll();
        GenericItem secondItem = new GenericItem(002, "Toy2", 24.99f, firstItem);
        secondItem.printAll();
        GenericItem thirdItem = new GenericItem(003, "Toy3", 17.49f, null);
        thirdItem.printAll();

        System.out.println();

        FoodItem someItem1 = new FoodItem(004, "Toy4", 15.89f, firstItem, (short) 15);
        TechicalItem someItem2 = new TechicalItem(005, "Toy5", 8.99f, someItem1, (short) 365);

        GenericItem[] arrayOfObjects = new GenericItem[2];
        arrayOfObjects[0] = someItem1;
        arrayOfObjects[1] = someItem2;

        for(int i = 0; i < 2; i++){
            arrayOfObjects[i].printAll();
        }

        System.out.println();

        FoodItem newItem1 = new FoodItem("Toy10");
        FoodItem newItem2 = new FoodItem("Toy11");
        System.out.println(newItem1.equals(newItem2));

        FoodItem newItem3 = (FoodItem) newItem1.clone();
        System.out.println(newItem1.equals(newItem3));

        System.out.println();

        String line = "Конфеты ’Маска’;45;120";
        String[] item_fld = line.split(";");

        float price = Float. parseFloat(item_fld[1]);
        short expires = Short. parseShort(item_fld[2]);

        FoodItem newItem4 = new FoodItem(item_fld[0], price, expires);

        newItem4.printAll();

        System.out.println();

        ItemCatalog newCatalog1 = new ItemCatalog();

        GenericItem item1 = new GenericItem(20, "Toy20", 10.99f, null);
        GenericItem item2 = new GenericItem(21, "Toy21", 10.99f, null);
        GenericItem item3 = new GenericItem(22, "Toy22", 10.99f, null);
        GenericItem item4 = new GenericItem(23, "Toy23", 10.99f, null);
        GenericItem item5 = new GenericItem(24, "Toy24", 10.99f, null);
        GenericItem item6 = new GenericItem(25, "Toy25", 10.99f, null);
        GenericItem item7 = new GenericItem(26, "Toy26", 10.99f, null);
        GenericItem item8 = new GenericItem(27, "Toy27", 10.99f, null);
        GenericItem item9 = new GenericItem(28, "Toy28", 10.99f, null);
        GenericItem item10 = new GenericItem(29, "Toy29", 10.99f, null);

        newCatalog1.addItem(item1);
        newCatalog1.addItem(item2);
        newCatalog1.addItem(item3);
        newCatalog1.addItem(item4);
        newCatalog1.addItem(item5);
        newCatalog1.addItem(item6);
        newCatalog1.addItem(item7);
        newCatalog1.addItem(item8);
        newCatalog1.addItem(item9);
        newCatalog1.addItem(item10);

        long begin = new Date().getTime();
        for(int i = 0; i < 100000; i++) {
            newCatalog1.findItemByID(10);
        }
        long end = new Date().getTime();
        System.out.println("In HashMap: " + (end - begin));

        begin = new Date().getTime();
        for(int i = 0; i < 100000; i++) {
            newCatalog1.findItemByIDAL(10);
        }
        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));

        System.out.println();

        GenericItem item21 = new GenericItem("Sony TV", 23000, Category.GENERAL);
        FoodItem item22 = new FoodItem("Bread", 12, (short) 10, null, new Date());
        newCatalog1.addItem(item21);
        newCatalog1.addItem(item22);

        CatalogLoader loader = new CatalogStubLoader();
        loader.load(newCatalog1);

        newCatalog1.printItems();




    }
}
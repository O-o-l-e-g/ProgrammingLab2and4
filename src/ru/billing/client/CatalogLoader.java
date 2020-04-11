package ru.billing.client;

import ru.billing.stocklist.ItemCatalog;

public interface CatalogLoader {

    void load(ItemCatalog catalog);

}

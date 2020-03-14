package com.jacekkaczmarek;



import java.util.*;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public Map<String , Double> PriceList(){
        Map<String,Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item: list.entrySet()){
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public int modifyStock(StockItem item){
        if(item!=null) {
            StockItem instock = list.getOrDefault(item.getName(), item);
            if (instock != item){
                instock.setQuantity(instock.quantityInStock());
            }
            if(instock.quantityInStock()<0){
                instock.setQuantity(0);
            }
            list.put(item.getName(),item);
            return item.quantityInStock();
        }
        return 0;
    }


    public boolean contain(String name){
        for (Map.Entry<String,StockItem> entry : list.entrySet()){
            if(entry.getKey().equals(name))return true;
        }
        return false;
    }

    public int addToStock(StockItem item){
        if(item!=null) {
            StockItem instock = list.getOrDefault(item.getName(), item);
            if (instock != item){
                item.adjustStock(instock.quantityInStock());
            }
            if(instock.quantityInStock()<0){
                instock.setQuantity(0);
            }
            list.put(item.getName(),item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int removeFromStock(String item,int quantity){
        StockItem inStock = list.get(item);
        if((inStock != null) && (quantity > 0)) {
            list.get(item).setQuantity(list.get(item).quantityInStock()-quantity);
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get(key);
    }

    public Map<String ,StockItem> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s ="\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String , StockItem> item: list.entrySet()){
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            s = s + stockItem + ". There are " + stockItem.quantityInStock() + "in stock. Value of items ";
            s = s + itemValue + "\n";
            totalCost +=itemValue;
        }

        return s + "Total stock value " + totalCost;
    }
}

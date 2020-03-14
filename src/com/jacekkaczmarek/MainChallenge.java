package com.jacekkaczmarek;




import java.util.Map;

public class MainChallenge {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        ///////////////////////////////
        //MAGAZINE PART
        ////////////////////////////
        System.out.println("MAGAZINE PART");


        StockItem temp = new StockItem("Jeans", 80, 50);
        stockList.addToStock(temp);

        temp = new StockItem("T-Shirt", 20, 100);
        stockList.addToStock(temp);

        temp = new StockItem("Sockets", 10, -80);
        stockList.addToStock(temp);

        temp = new StockItem("Polos", 25, 70);
        stockList.addToStock(temp);
        temp = new StockItem("Sweaters", 40, 70);
        stockList.addToStock(temp);

        temp = new StockItem("Joggers", 50, 30);
        stockList.addToStock(temp);

        temp = new StockItem("Pants",50,800);
        stockList.addToStock(temp);


        System.out.println(stockList);
        System.out.println("\n\n\n");
        ///////////////////////////////////
        /////BASKET PART
        ////////////////////////////////
        Basket jackBasket = new Basket("Jack");

        StockItem item = new StockItem("Pants",10,4);
        if(canAdd(item,stockList)){
        jackBasket.addToBasket(item,item.getQuantity());}

        item = new StockItem("Pants",10,4);
        if(canAdd(item,stockList)){
            jackBasket.addToBasket(item,item.getQuantity());}

        item = new StockItem("Jeans",10,3);
        if(canAdd(item,stockList)){
            jackBasket.addToBasket(item,item.getQuantity());}

        item = new StockItem("T-Shirt",10,80);
        if(canAdd(item,stockList)){
            jackBasket.addToBasket(item,item.getQuantity());}


        item = new StockItem("Pants",10,80);
        if(canRemove(item,jackBasket)){
            jackBasket.deleteFromBasket(item,item.getQuantity());}
        item = new StockItem("T-Shirt",10,78);
        if(canRemove(item,jackBasket)){
            jackBasket.deleteFromBasket(item,item.getQuantity());}


        System.out.println(jackBasket);
        System.out.println("\n\n\n");
        //////////////////////////////////////////////////////////////
        ////CHECKOUT PART
        /////////////////////////////////////////////


        checkOut(jackBasket);
        jackBasket.clearBasket();

        Basket sceondBasket = new Basket("Second");
        item = new StockItem("Pants",10,4);
        if(canAdd(item,stockList)){
            sceondBasket.addToBasket(item,item.getQuantity());}

        System.out.println(sceondBasket);

        /////////////////////////////////////////
        ////////////////////////////////////////
        ////////////////////////////////////////
        /////////////MAGAZINE PART-CHANGES IN MAGAZIE
        /////////////////////////////////////
        /////////////////////////////////////
        System.out.println("\n\n\n");
        System.out.println("MAGAZIN LIST AT END\n" + stockList);
        System.out.println("\n\n\n");
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.items().entrySet()) {
            stockList.removeFromStock(item.getKey().getName(), item.getValue());
        }
    }




    public static boolean canAdd(StockItem item,StockList stockList){
        if(stockList.contain(item.getName())) {
            if (item.getQuantity() < stockList.get(item.getName()).getQuantity()) {
                return true;
            }
            else
                return false;
        }
        else return false;
    }

    public static boolean canRemove(StockItem item,Basket basket){
        if(basket.contain(item.getName())) {
            if (item.getQuantity() < basket.getQuantity(item.getName())) {
                return true;
            }
            else
                return false;
        }
        else return false;
    }

}

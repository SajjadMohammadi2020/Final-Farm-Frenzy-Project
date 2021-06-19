import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.*;

public class Manager {
    static int passedTurn = 0;
    final static int STORE_SIZE = 30;
    final static int STORE_CAPACITY_AT_FIRST = 0;
    static int storeCapacity = STORE_CAPACITY_AT_FIRST;
    ArrayList<WorkShops> workShops = new ArrayList<>();
    ArrayList<Goods> goods = new ArrayList<>();
    ArrayList<Goods> goodsOnGround = new ArrayList<>();
    ArrayList<Goods> truckItems = new ArrayList<>();
    ArrayList<Grass> grasses = new ArrayList<>();
    final static int COINS_AT_FIRST = 2000;
    static int coins = COINS_AT_FIRST;
    final static int MAX_TRUCK_CAPACITY = 15;
    static int truckSize = 0;
    static int truckOnWay = 0;
    boolean isTruckOnWay = false;
    final static int REQUIRED_TIME_FOR_TRUCK = 10;
    static int well = 0;
    static int wellPassedTime;
    static boolean wellProcess = false;
    final static int TIME_REQUIRED_FOR_WELL = 3;

    LogManager logManager = LogManager.getLogManager();
    Logger logg = logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public boolean isExisted(String name){
        for(WorkShops workShop : workShops){
            if(workShop.getWorkshopName().equals(name))
                return true;
        }
        return false;
    }

    public void makingGood(){
        goods.add(new Goods("egg"));
        goods.add(new Goods("milk"));
        goods.add(new Goods("feather"));
        goods.add(new Goods("fabric"));
        goods.add(new Goods("packedMilk"));
        goods.add(new Goods("flour"));
        goods.add(new Goods("cloth"));
        goods.add(new Goods("iceCream"));
        goods.add(new Goods("bread"));
        goods.add(new Goods("bear"));
        goods.add(new Goods("lion"));
        goods.add(new Goods("tiger"));
        for(Goods goods : goods)
            goods.setPrice(goods.getName());
    }

   public void buildMill(){
        if(coins >= 300) {
            if (!isExisted("mill")) {
                workShops.add(new WorkShops("mill", 150, 4, "egg", "flour"));
                coins -= 300;
                System.out.println("Mill built successfully!");
                try {
                    FileHandler fh = new FileHandler("logfile.txt", true);
                    SimpleFormatter sf = new SimpleFormatter();
                    fh.setFormatter(sf);
                    logg.addHandler(fh);
                    logg.setUseParentHandlers(false);
                    logg.log(Level.INFO,workShops.get(workShops.size() - 1).getWorkshopName()+" made successfully!");
                } catch (Exception e){

                    System.out.println("error!!!");
                }
            } else
                System.out.println("This workshop was made!");
        }
        else
            System.out.println("Not enough coin!");
    }

    public void buildFabricWeaving(){
        if(coins >= 300) {
            if (!isExisted("fabricweaving")) {
                workShops.add(new WorkShops("fabricweaving", 250, 5, "feather", "fabric"));
                System.out.println("Fabric weaving workshop built successfully");
                try {
                    FileHandler fh = new FileHandler("logfile.txt", true);
                    SimpleFormatter sf = new SimpleFormatter();
                    fh.setFormatter(sf);
                    logg.addHandler(fh);
                    logg.setUseParentHandlers(false);
                    logg.log(Level.INFO,workShops.get(workShops.size() - 1).getWorkshopName()+" made successfully!");
                } catch (Exception e){

                    System.out.println("error!!!");
                }
            } else
                System.out.println("This workshop was made!");
            coins -= 300;
        }
        else
            System.out.println("Not enough coin!");
    }

    public void buildMilkPacking(){
        if(coins >= 300) {
            if (!isExisted("milkpacking")) {
                workShops.add(new WorkShops("milkpacking", 400, 6, "milk", "packedMilk"));
                System.out.println("Milk packing workshop built successfully");
                try {
                    FileHandler fh = new FileHandler("logfile.txt", true);
                    SimpleFormatter sf = new SimpleFormatter();
                    fh.setFormatter(sf);
                    logg.addHandler(fh);
                    logg.setUseParentHandlers(false);
                    logg.log(Level.INFO,workShops.get(workShops.size() - 1).getWorkshopName()+" made successfully!");
                } catch (Exception e){

                    System.out.println("error!!!");
                }
            } else
                System.out.println("This workshop was made!");
        }
        else
            System.out.println("Not enough coin!");
        coins -= 300;
    }

    public void buildBakery(){
        if(coins >= 400) {
            if (!isExisted("bakery")) {
                workShops.add(new WorkShops("bakery", 250, 5, "flour", "bread"));
                System.out.println("Bakery built successfully");
                try {
                    FileHandler fh = new FileHandler("logfile.txt", true);
                    SimpleFormatter sf = new SimpleFormatter();
                    fh.setFormatter(sf);
                    logg.addHandler(fh);
                    logg.setUseParentHandlers(false);
                    logg.log(Level.INFO,workShops.get(workShops.size() - 1).getWorkshopName()+" made successfully!");
                } catch (Exception e){

                    System.out.println("error!!!");
                }
            } else
                System.out.println("This workshop was made!");
            coins -= 400;
        }
        else
            System.out.println("Not enough coin!");
    }

    public void buildTailoring(){
        if(coins >= 400) {
            if (!isExisted("tailoring")) {
                workShops.add(new WorkShops("tailoring", 400, 6, "fabric", "cloth"));
                System.out.println("Tailoring built successfully");
                try {
                    FileHandler fh = new FileHandler("logfile.txt", true);
                    SimpleFormatter sf = new SimpleFormatter();
                    fh.setFormatter(sf);
                    logg.addHandler(fh);
                    logg.setUseParentHandlers(false);
                    logg.log(Level.INFO,workShops.get(workShops.size() - 1).getWorkshopName()+" made successfully!");
                } catch (Exception e){

                    System.out.println("error!!!");
                }
            } else
                System.out.println("This workshop was made!");
            coins -= 400;
        }
        else
            System.out.println("Not enough coin!");
    }

    public void buildIceCreamWorkshop(){
        if(coins >= 400) {
            if (!isExisted("icecreamworkshop")) {
                workShops.add(new WorkShops("icecreamworkshop", 550, 7, "packedMilk", "iceCream"));
                System.out.println("Ice cream work shop built successfully");
                try {
                    FileHandler fh = new FileHandler("logfile.txt", true);
                    SimpleFormatter sf = new SimpleFormatter();
                    fh.setFormatter(sf);
                    logg.addHandler(fh);
                    logg.setUseParentHandlers(false);
                    logg.log(Level.INFO,workShops.get(workShops.size() - 1).getWorkshopName()+" made successfully!");
                } catch (Exception e){

                    System.out.println("error!!!");
                }
            } else
                System.out.println("This workshop was made!");
            coins -= 400;
        }
        else
            System.out.println("Not enough coin!");
    }

    private WorkShops getWorkshopByName(String name){
        for(WorkShops workShops : workShops){
            if(workShops.getWorkshopName().equals(name))
                return workShops;
        }
        return null;
    }

    private Goods getGoodByName(String name){
       for(Goods goods : goods){
           if(goods.getName().equals(name))
               return goods;
       }
       return null;
    }

    public void working(String name){
        WorkShops workShop = getWorkshopByName(name);
        if(workShop == null)
            System.out.println("You don't have this workshop!!!");
        else {
            Goods good = getGoodByName(workShop.getRequiredItem());
            if (workShop.getIsWorking())
                System.out.println("This workshop is already working!");
            else if (workShop.getCost() > coins)
                System.out.println("You don't have enough coins!");
            else if (good.getInventory() < 1)
                System.out.println("You don't have enough item!");
            else {
                workShop.setWorkingTrue();
                workShop.setPassedTimeZero();
                good.useItem();
                System.out.println(workShop.getWorkshopName() + " starts working.");
                try {
                    FileHandler fh = new FileHandler("logfile.txt", true);
                    SimpleFormatter sf = new SimpleFormatter();
                    fh.setFormatter(sf);
                    logg.addHandler(fh);
                    logg.setUseParentHandlers(false);
                    logg.log(Level.INFO, workShop.getWorkshopName() + " stars working.It takes " + workShop.getRequiredItem() + " turns..");
                } catch (Exception e) {

                    System.out.println("error!!!");
                }
            }
        }
    }

    private boolean storeHasCapacity(int size){
       if(size <= STORE_SIZE - storeCapacity)
           return true;
       else
           return false;
    }

    private void checkWorkshops(){
       for(WorkShops workShops : workShops){
           if(workShops.isFinished()){
               try {
                   FileHandler fh = new FileHandler("logfile.txt", true);
                   SimpleFormatter sf = new SimpleFormatter();
                   fh.setFormatter(sf);
                   logg.addHandler(fh);
                   logg.setUseParentHandlers(false);
                   logg.log(Level.INFO,workShops.getWorkshopName()+" finished his work...");
               } catch (Exception e){

                   System.out.println("error!!!");
               }
               goodsOnGround.add(new Goods(workShops.getProduct(),"ground"));
               goodsOnGround.get(goodsOnGround.size() - 1).setRowAndColumn(workShops.getWorkshopName());
               workShops.setPassedTimeZero();
               workShops.setWorkingFalse();
           }
           if(workShops.getIsWorking())
               workShops.passingTime();
       }
    }

    private void checkGoods(){
        for(int i=0;i<goodsOnGround.size();i++) {
            if(goodsOnGround.get(i).isExpired()){
                try {
                    FileHandler fh = new FileHandler("logfile.txt", true);
                    SimpleFormatter sf = new SimpleFormatter();
                    fh.setFormatter(sf);
                    logg.addHandler(fh);
                    logg.setUseParentHandlers(false);
                    logg.log(Level.INFO,goodsOnGround.get(i).getName()+" has been expired!!!");
                } catch (Exception e){

                    System.out.println("error!!!");
                }
                goodsOnGround.remove(i);
                i--;
            }
            else
                goodsOnGround.get(i).passTimeOutOfStore();
        }
    }

    public void pickupItem(int row,int column){
        for(int i = 0 ; i < goodsOnGround.size() ; i++){
            if(goodsOnGround.get(i).getRow() == row && goodsOnGround.get(i).getColumn() == column){
                if(storeHasCapacity(goodsOnGround.get(i).getSize())){
                    storeCapacity += goodsOnGround.get(i).getSize();
                    System.out.println(goodsOnGround.get(i).getName()+" added to storehouse.");
                    for(Goods goods : goods){
                        if(goods.getName().equals(goodsOnGround.get(i).getName())) {
                            goods.setInventory();
                            try {
                                FileHandler fh = new FileHandler("logfile.txt", true);
                                SimpleFormatter sf = new SimpleFormatter();
                                fh.setFormatter(sf);
                                logg.addHandler(fh);
                                logg.setUseParentHandlers(false);
                                logg.log(Level.INFO,goodsOnGround.get(i).getName()+" added to storehouse!!!");
                            } catch (Exception e){
                                System.out.println("error!!!");
                            }
                        }
                    }
                    goodsOnGround.remove(i);
                    i--;
                }
                else{
                    System.out.println("Store has no capacity!!!");
                }
            }
        }
    }

    public void truckLoad(String name){
        if(!isTruckOnWay) {
            for (Goods goods : goods) {
                if (goods.getName().equals(name)) {
                    if (goods.getInventory() > 0)
                        System.out.println("Not enough item in store.");
                    else if (MAX_TRUCK_CAPACITY - truckSize < goods.getSize())
                        System.out.println("The truck capacity is not enough!");
                    else {
                        truckItems.add(new Goods(goods.getName(),goods.getPrice()));
                        goods.useItem();
                        truckSize += goods.getSize();
                        System.out.println(goods.getName() + " added into the truck.");
                        try {
                            FileHandler fh = new FileHandler("logfile.txt", true);
                            SimpleFormatter sf = new SimpleFormatter();
                            fh.setFormatter(sf);
                            logg.addHandler(fh);
                            logg.setUseParentHandlers(false);
                            logg.log(Level.INFO,goods.getName()+" added to truck!!!");
                        } catch (Exception e){

                            System.out.println("error!!!");
                        }
                    }
                }
            }
        }
        else
            System.out.println("Truck is on the way!!!");
    }

    public void truckUnload(String name){
        if(!isTruckOnWay) {
            boolean unload = false;
            if (truckSize == 0)
                System.out.println("Truck is empty!");
            else {
                for (int i = 0; i < truckItems.size(); i++) {
                    if (truckItems.get(i).getName().equals(name)) {
                        truckSize -= truckItems.get(i).getSize();
                        try {
                            FileHandler fh = new FileHandler("logfile.txt", true);
                            SimpleFormatter sf = new SimpleFormatter();
                            fh.setFormatter(sf);
                            logg.addHandler(fh);
                            logg.setUseParentHandlers(false);
                            logg.log(Level.INFO,truckItems.get(i).getName()+" removed from truck!!!");
                        } catch (Exception e){

                            System.out.println("error!!!");
                        }
                        truckItems.remove(i);
                        unload = true;
                        i--;
                    }
                }
                if (unload)
                    System.out.println(name + " disembarked.");
                else
                    System.out.println("There is no " + name + " in truck!");
            }
        }
        else
            System.out.println("Truck is on the way!");
    }

    public void sendTruck(){
        if(truckSize > 0) {
            try {
                FileHandler fh = new FileHandler("logfile.txt", true);
                SimpleFormatter sf = new SimpleFormatter();
                fh.setFormatter(sf);
                logg.addHandler(fh);
                logg.setUseParentHandlers(false);
                logg.log(Level.INFO,"truck sent to city!!!");
            } catch (Exception e){

                System.out.println("error!!!");
            }
            isTruckOnWay = true;
        }
        else
            System.out.println("Truck is empty!!!");
    }

    private void checkTruck(){
        if(isTruckOnWay){
            if(truckOnWay == REQUIRED_TIME_FOR_TRUCK){
                for (Goods goods : truckItems)
                    coins += goods.getPrice();
                isTruckOnWay = false;
                try {
                    FileHandler fh = new FileHandler("logfile.txt", true);
                    SimpleFormatter sf = new SimpleFormatter();
                    fh.setFormatter(sf);
                    logg.addHandler(fh);
                    logg.setUseParentHandlers(false);
                    logg.log(Level.INFO,"truck has arrived from city!");
                } catch (Exception e){

                    System.out.println("error!!!");
                }
            }
        }
        else
            truckOnWay++;
    }

    private boolean isWllIsEmpty(){
        if(well > 0)
            return false;
        else
            return true;
    }

    public void well(){
        if(isWllIsEmpty() && !wellProcess) {
            wellPassedTime = 0;
            wellProcess = true;
            System.out.println("Well filling started!!!");
            try {
                FileHandler fh = new FileHandler("logfile.txt", true);
                SimpleFormatter sf = new SimpleFormatter();
                fh.setFormatter(sf);
                logg.addHandler(fh);
                logg.setUseParentHandlers(false);
                logg.log(Level.INFO,"well starts to filling!!");
            } catch (Exception e){

                System.out.println("error!!!");
            }
        }
        else if(wellProcess)
            System.out.println("Well is filling.");
        else
            System.out.println("Well has water!");

    }

    private void checkWell(){
        if(wellProcess){
            wellPassedTime++;
            if(wellPassedTime == TIME_REQUIRED_FOR_WELL)
                well = 5;
        }
    }

    public void planting(int row,int column){
        boolean planted = false;
        if(well > 0) {
            if (grasses.size() > 0) {
                for (int i=0;i<grasses.size() && !planted;i++) {
                    if (row == grasses.get(i).getRow() && column == grasses.get(i).getColumn()) {
                        grasses.get(i).setNumber();
                        well--;
                        try {
                            FileHandler fh = new FileHandler("logfile.txt", true);
                            SimpleFormatter sf = new SimpleFormatter();
                            fh.setFormatter(sf);
                            logg.addHandler(fh);
                            logg.setUseParentHandlers(false);
                            logg.log(Level.INFO,"Grass increased at "+row+" "+column);
                        } catch (Exception e){

                            System.out.println("error!!!");
                        }
                        System.out.println("Grass planted...");
                    }
                    else {
                        grasses.add(new Grass(row, column));
                        well--;
                        planted = true;
                        try {
                            FileHandler fh = new FileHandler("logfile.txt", true);
                            SimpleFormatter sf = new SimpleFormatter();
                            fh.setFormatter(sf);
                            logg.addHandler(fh);
                            logg.setUseParentHandlers(false);
                            logg.log(Level.INFO,"New Grass at "+row+" "+column);
                        } catch (Exception e){

                            System.out.println("error!!!");
                        }
                        System.out.println("Grass planted...");
                    }
                }
            } else {
                grasses.add(new Grass(row, column));
                well--;
                System.out.println("Grass planted...");
                logg.log(Level.INFO,"New Grass at "+row+" "+column);
            }
        }
        else
            System.out.println("Fill the well and try later...");
    }

    public void upgradeWorkshop(String name){
        WorkShops workShop = getWorkshopByName(name);
        if(workShop == null)
            System.out.println("You don't have this workshop!!!");
        else{
            if(coins > 1000){
                workShop.upgradeWorkshop(name);
                System.out.println(workShop.getWorkshopName()+" upgraded successfully.");
                coins -= 1000;
                try {
                    FileHandler fh = new FileHandler("logfile.txt", true);
                    SimpleFormatter sf = new SimpleFormatter();
                    fh.setFormatter(sf);
                    logg.addHandler(fh);
                    logg.setUseParentHandlers(false);
                    logg.log(Level.INFO,workShop.getWorkshopName()+" upgraded successfully!");
                } catch (Exception e){

                    System.out.println("error!!!");
                }
            }
            else
                System.out.println("You don't have enough coin!!!");

        }
    }

    public void passTurn(int n){
        for(int i=1;i<=n;i++) {
            passedTurn++;
            checkWorkshops();
            checkGoods();
            checkTruck();
            checkWell();
        }
        System.out.println(passedTurn);
    }
}



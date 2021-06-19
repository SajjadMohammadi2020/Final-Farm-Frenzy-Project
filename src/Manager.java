import java.util.ArrayList;

public class Manager {

    User user ;
    AllOfAnimals animals ;
    static int passedTurn = 0;
    final static int STORE_SIZE = 30;
    final static int STORE_CAPACITY_AT_FIRST = 0;
    static int storeCapacity = STORE_CAPACITY_AT_FIRST;
    ArrayList<WorkShops> workShops = new ArrayList<>();
    static ArrayList<Goods> goods = new ArrayList<>();
    static ArrayList<Goods> goodsOnGround = new ArrayList<>();
    ArrayList<Goods> truckItems = new ArrayList<>();
    static ArrayList<Grass> grasses = new ArrayList<>();
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

    Manager(User user){
        this.user =  user ;
        this.animals = AllOfAnimals.getAllOfAnimals_instance(this.user.userName,this.user.maxLevel);
    }

    public void inquiry(){
        animals.inquiry();
        System.out.println("\n");
    }

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
        for(Goods goods : goods)
            goods.setPrice(goods.getName());
    }

    public void buildMill(){
        if(coins >= 300) {
            if (!isExisted("Mill")) {
                workShops.add(new WorkShops("Mill", 150, 4, "egg", "flour"));
                System.out.println("Mill built successfully!");
            } else
                System.out.println("This workshop was made!");
            coins -= 300;
        }
        else
            System.out.println("Not enough coin!");
    }

    public void buildFabricWeaving(){
        if(coins >= 300) {
            if (!isExisted("FabricWeaving")) {
                workShops.add(new WorkShops("FabricWeaving", 250, 5, "feather", "fabric"));
                System.out.println("Fabric weaving workshop built successfully");
            } else
                System.out.println("This workshop was made!");
            coins -= 300;
        }
        else
            System.out.println("Not enough coin!");
    }

    public void buildMilkPacking(){
        if(coins >= 300) {
            if (!isExisted("MilkPacking")) {
                workShops.add(new WorkShops("MilkPacking", 400, 6, "milk", "packedMilk"));
                System.out.println("Milk packing workshop built successfully");
            } else
                System.out.println("This workshop was made!");
        }
        else
            System.out.println("Not enough coin!");
        coins -= 300;
    }

    public void buildBakery(){
        if(coins >= 400) {
            if (!isExisted("Bakery")) {
                workShops.add(new WorkShops("Bakery", 250, 5, "flour", "bread"));
                System.out.println("Bakery built successfully");
            } else
                System.out.println("This workshop was made!");
            coins -= 400;
        }
        else
            System.out.println("Not enough coin!");
    }

    public void buildTailoring(){
        if(coins >= 400) {
            if (!isExisted("Tailoring")) {
                workShops.add(new WorkShops("Tailoring", 400, 6, "fabric", "cloth"));
                System.out.println("Tailoring built successfully");
            } else
                System.out.println("This workshop was made!");
            coins -= 400;
        }
        else
            System.out.println("Not enough coin!");
    }

    public void buildIceCreamWorkshop(){
        if(coins >= 400) {
            if (!isExisted("IceCreamWorkshop")) {
                workShops.add(new WorkShops("IceCreamWorkshop", 550, 7, "packedMilk", "iceCream"));
                System.out.println("Ice cream work shop built successfully");
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
        Goods good = getGoodByName(workShop.getRequiredItem());
        if(workShop.getIsWorking())
            System.out.println("This workshop is already working!");
        else if(workShop.getCost() > coins)
            System.out.println("You don't have enough coins!");
        else if(good.getInventory() < 1)
            System.out.println("You don't have enough item!");
        else{
            workShop.setWorkingTrue();
            workShop.setPassedTimeZero();
            good.useItem();
            System.out.println(workShop.getWorkshopName()+" starts working.");
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
                        if(goods.getName().equals(goodsOnGround.get(i).getName()))
                            goods.setInventory();
                    }
                    goodsOnGround.remove(i);
                    i--;
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
        if(truckSize > 0)
            isTruckOnWay = true;
        else
            System.out.println("Truck is empty!!!");
    }

    private void checkTruck(){
        if(isTruckOnWay){
            if(truckOnWay == REQUIRED_TIME_FOR_TRUCK){
                for (Goods goods : truckItems)
                    coins += goods.getPrice();
                isTruckOnWay = false;
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
        if(isWllIsEmpty()) {
            wellPassedTime = 0;
            wellProcess = true;
        }
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
        if(grasses.size() > 0) {
            for (Grass grass : grasses) {
                if (row == grass.getRow() && column == grass.getColumn())
                    grass.setNumber();
                else
                    grasses.add(new Grass(row, column));
            }
        }
        else
            grasses.add(new Grass(row, column));
    }

    public void passTurn(int n){
        for(int i=1;i<=n;i++) {
            passedTurn++;
            animals.TurnAllOfAnimals();
            checkWorkshops();
            checkGoods();
            checkTruck();
            checkWell();
            System.out.println("\n");
        }
        System.out.println(passedTurn);

    }

    public void buyAnimal(String name){
        switch (name){
            case "hen" :
                if(coins>=DomesticAnimal.henBuyPrice){
                animals.makeDomesticAnimal(name);} break;
            case "turkey" :
                if(coins>=DomesticAnimal.turkeyBuyPrice){
                    animals.makeDomesticAnimal(name); } break;
            case "buffalo" :
                if(coins>=DomesticAnimal.buffaloBuyPrice){
                    animals.makeDomesticAnimal(name); } break;
            case "cat" :
                if(coins>=OtherAnimals.catBuyPrice){
                    animals.makeOtherAnimal(name); } break;
            case "dog" :
                if(coins>=OtherAnimals.dogBuyPrice){
                    animals.makeDomesticAnimal(name);} break;
            default: System.out.println("Wrong buy animal!!!!!!!"); break;
        }
    }

    public void cage(int x , int y ){
        animals.cage(x,y);
    }


}

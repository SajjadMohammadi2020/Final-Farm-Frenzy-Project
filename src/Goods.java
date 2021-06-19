//کلاسی برای کالاها
public class Goods {

    //مقادیر این کلاس
    private int price;
    private int row;
    private int column;
    private String name;
    private int timeToExpire;
    private int size;
    private String type;
    private int inventory;
    private int timeOutOfStore;
    final static int EXPIRATION_TIME_FOR_PRIMARY = 4;
    final static int EXPIRATION_TIME_FOR_SECONDARY = 5;
    final static int EXPIRATION_TIME_FOR_FINAL = 6;

    //کانستراکتور این کلاس
    public Goods(String name){
        if(isPrimary(name)) {
            this.name = name;
            this.timeToExpire = EXPIRATION_TIME_FOR_PRIMARY;
            this.size = 1;
            this.type = "primary";
            this.inventory = 0;
        }
        else if(isSecondary(name)) {
            this.name = name;
            this.timeToExpire = EXPIRATION_TIME_FOR_SECONDARY;
            this.size = 2;
            this.type = "secondary";
            this.inventory = 0;
        }
        else {
            this.name = name;
            this.timeToExpire = EXPIRATION_TIME_FOR_FINAL;
            this.size = 4;
            this.type = "final";
            this.inventory = 0;
        }
    }

    //کانستراکتور دوم این کلاس
    public Goods(String name,String ground){
        if(isPrimary(name)) {
            this.row = 1;
            this.column = 1;
            this.name = name;
            this.timeToExpire = EXPIRATION_TIME_FOR_PRIMARY;
            this.size = 1;
            this.type = "primary";
            this.timeOutOfStore = 0;
        }
        else if(isSecondary(name)) {
            this.row = 1;
            this.column = 1;
            this.name = name;
            this.timeToExpire = EXPIRATION_TIME_FOR_SECONDARY;
            this.size = 2;
            this.type = "secondary";
            this.timeOutOfStore = 0;
        }
        else {
            this.row = 1;
            this.column = 1;
            this.name = name;
            this.timeToExpire = EXPIRATION_TIME_FOR_FINAL;
            this.size = 4;
            this.type = "final";
            this.timeOutOfStore = 0;
        }
        Manager.goodsOnGround.add(this);
    }

    //کانستراکتور برای تبدیل product به goods
    Goods(String name , int row , int col ){
        this.name = name ;
        this.row = row ; this.column = col ;this.timeToExpire = EXPIRATION_TIME_FOR_PRIMARY ;
        this.timeOutOfStore =  0 ;  this.size = 1 ; this.type = "primary";
        this.inventory = 0;
        Manager.goodsOnGround.add(this);
    }

    //کانستراکتور دوم این کلاس
    public Goods(String name,int price){
        this.name = name;
        if (isPrimary(name)) {
            this.size = 1;
            this.price = price;
        }
        else if(isSecondary(name)) {
            this.size = 2;
            this.price = price;
        }
        else {
            this.size = 4;
            this.price = price;
        }

    }

    //
    public int getInventory(){return inventory;}

    //تابعی برای دادن اسم محصول
    public String getName(){return name;}

    //
    public void setInventory(){this.inventory++;}


    public int getSize(){return size;}

    public void passTimeOutOfStore(){this.timeOutOfStore++;}

    public void setRowAndColumn(String name){
        if(name.equals("Mill")){
            this.row = 5;
            this.column = 5;
        }
        else if(name.equals("FabricWeaving")){
            this.row = 5;
            this.column = 3;
        }
        else if(name.equals("MilkPacking")){
            this.row = 5;
            this.column = 1;
        }
        else if(name.equals("Bakery")){
            this.row = 0;
            this.column = 1;
        }
        else if(name.equals("Tailoring")){
            this.row = 0;
            this.column = 3;
        }
        else if(name.equals("IceCreamWorkshop")){
            this.row = 0;
            this.column = 5;
        }
    }

    public boolean isExpired(){
        if(this.timeOutOfStore == this.timeToExpire)
            return true;
        else
            return false;
    }

    public void setPrice(String name){
        if(name.equals("egg"))
            price = 15;
        else if(name.equals("feather"))
            price = 20;
        else if(name.equals("milk"))
            price = 25;
        else if(name.equals("flour"))
            price = 40;
        else if(name.equals("fabric"))
            price = 50;
        else if(name.equals("packedMilk"))
            price = 60;
        else if(name.equals("bread"))
            price = 80;
        else if(name.equals("cloth"))
            price = 100;
        else
            price = 120;
    }

    public int getRow(){return row;}

    public int getColumn(){return column;}

    public boolean isPrimary(String name){
        String[] primaries = {"egg","feather","milk"};
        for(int i = 0;i < 3;i++){
            if(primaries[i].equals(name))
                return true;
        }
        return false;
    }

    public boolean isSecondary(String name){
        String[] secondaries = {"flour","fabric","packedMilk"};
        for(int i = 0;i < 3;i++){
            if(secondaries[i].equals(name))
                return true;
        }
        return false;
    }

    public int getPrice(){return price;}

    public void useItem(){
        this.inventory -= 1;
    }
}

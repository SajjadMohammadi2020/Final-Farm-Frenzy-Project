import java.util.Random;

//کلاس حیوانات اهلی که از کلاس animal اکستند شده است
public class DomesticAnimal extends Animal {

    //اعداد ثابت مورد نیاز مرغ
    public static final int henBuyPrice = 100 ;
    public static final int henSellPrice = 80 ;
    public static final int henLife = 100 ;
    public static final int henProductTime = 2 ;
    public static final String henProduct = "egg" ;

    //اعداد ثابت مورد نیاز بوقلمون
    public static final int turkeyBuyPrice = 200 ;
    public static final int turkeySellPrice = 160 ;
    public static final int turkeyLife = 100 ;
    public static final int turkeyProductTime = 3 ;
    public static final String turkeyProduct = "feather" ;

    //اعداد ثابت مورد نیاز بوفالو
    public static final int buffaloBuyPrice = 300 ;
    public static final int buffaloSellPrice = 240 ;
    public static final int buffaloLife = 100 ;
    public static final int buffaloProductTime = 5 ;
    public static final String buffaloProduct = "milk" ;

    //متغیر های موجود در این کلاس
    int sellPrice ;
    int buyPrice ;
    int time ;
    int productTime ;
    String product ;

    //کانستراکتور این کلاس
    DomesticAnimal(String name , int x , int y ){
        if(name.equals("Hen")||name.equals("Turkey")||name.equals("Buffalo")){
            this.name = name ; this.x = x ; this.y =y ; this.time =  0 ;
            switch (name){
                case "Hen" :
                    this.buyPrice = henBuyPrice ;
                    this.sellPrice = henSellPrice ;
                    this.life = henLife ;
                    this.productTime = henProductTime ;
                    this.product = henProduct ;
                    break;
                case "Buffalo":
                    this.buyPrice = buffaloBuyPrice ;
                    this.sellPrice = buffaloSellPrice ;
                    this.life = buffaloLife ;
                    this.productTime = buffaloProductTime ;
                    this.product = buffaloProduct ;
                    break;
                case "Turkey" :
                    this.buyPrice = turkeyBuyPrice ;
                    this.sellPrice = turkeySellPrice ;
                    this.life = turkeyLife ;
                    this.productTime = turkeyProductTime ;
                    this.product = turkeyProduct ;
                    break;}
        } else {
            System.out.println("Wrong DomesticAnimal!");
        }
    }

    //تابعی برای تولید محصول
    public void makeProduct(){
        if(this.time%this.productTime==0){
            DomesticAnimalProduct product = new DomesticAnimalProduct(this.product,this.x,this.y);
        }
    }

}

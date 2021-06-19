//کلاس محصولات تولیدی حیوانات اهلی
public class DomesticAnimalProduct {

    //اعداد ثابت مورد نیاز برای قیمت محصولات تولیدی توسط حیوانات اهلی
    public static final int eggBuyPrice = 15 ;
    public static final int featherBuyPrice = 20 ;
    public static final int milkBuyPrice = 25 ;

    //متغیر های این کلاس
    int sellPrice ;
    String name ;
    int x ;
    int y ;

    //
    public void Turn(){
        System.out.println(this.name + " " + this.x + " " + this.y );
    }

    //کانستراکتور این کلاس
    DomesticAnimalProduct(String name , int x, int y){
        if(name.equals("egg")||name.equals("feather")||name.equals("milk")){
            this.name = name ;
            this.x = x ; this.y = y ;
            switch (name){
                case "egg" : this.sellPrice = eggBuyPrice ; break;
                case "feather" : this.sellPrice = featherBuyPrice ; break;
                case "milk" : this.sellPrice = milkBuyPrice ; break;
            }
        } else {
            System.out.println("wrong DomesticAnimalProduct!");
        }
        Goods good = new Goods(name,this.x,this.y);
        AllOfDomesticProducts.addDomesticAnimalProduct(this);
    }
}

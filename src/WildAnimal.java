//کلاس حیوانات وحشی که از کلاس animal اکستند شده است
public class WildAnimal extends Animal{

    //مقادیر ثابت مورد نیاز خرس
    public static final int bearSpeed = 1 ;
    public static final int bearLife = 4 ;
    public static final int bearSellPrice = 400 ;

    //مقادیر ثابت مورد نیاز شیر
    public static final int lionSpeed = 1 ;
    public static final int lionLife = 3 ;
    public static final int lionSellPrice = 300 ;

    //مقادیر مورد نیاز ببر
    public static final int tigerSpeed = 2 ;
    public static final int tigerLife = 4 ;
    public static final int tigerSellPrice = 500 ;

    //متغیرهای موجود در این کلاس
    int sellPrice ;
    int speed ;
    boolean caged ;
    int max_life ;

    //کانستراکتور این کلاس
    WildAnimal(String name , int x , int y ){
        if(name.equals("Bear")||name.equals("Lion")||name.equals("Tiger")){
            this.name = name ; this.x = x ; this.y = y ; this.caged = false ;
            switch (name){
                case "Bear" :
                    this.sellPrice = bearSellPrice ;
                    this.life = bearLife ;
                    this.speed = bearSpeed ;
                    this.max_life = bearLife ;
                    break;
                case "Lion" :
                    this.sellPrice = lionSellPrice ;
                    this.life = lionLife ;
                    this.speed = lionSpeed ;
                    this.max_life = lionLife ;
                    break;
                case "Tiger" :
                    this.sellPrice = tigerSellPrice ;
                    this.life = tigerLife ;
                    this.speed = tigerSpeed ;
                    this.max_life = tigerLife ;
                    break;
            }
        } else {
            System.out.println("Wrong WildAnimal!");
        }
    }

}

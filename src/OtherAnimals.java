//کلاس حیوانات متفرقه ( شامل Cat و Dog ) که از کلاس animal اکستند شده است .
public class OtherAnimals extends Animal{

    //اعداد ثابت مورد نیاز برای قیمت Cat و Dog
    public static final int catBuyPrice = 150 ;
    public static final int dogBuyPrice = 100 ;

    //متغیرهای این کلاس
    int buyPrice ;

    //کانستراکتور این کلاس
    OtherAnimals(String name , int x , int y ){
        if(name.equals("Cat")||name.equals("Dog")){
            this.name = name ; this.x= x ; this.y = y ;
            switch (name){
                case "Cat" :
                    this.buyPrice = catBuyPrice ;
                    break;
                case "Dog" :
                    this.buyPrice = dogBuyPrice ;
                    break;
            }
        }else {
            System.out.println("Wrong OtherAnimal!");
        }
    }
}

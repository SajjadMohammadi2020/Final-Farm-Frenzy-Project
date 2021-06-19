//کلاس مرحله ( حاوی ماموریت ها و متغیرهای مورد نیاز هر مرحله )
public class Level {

    // متغیرهای موجود در این کلاس ( توضیحات هر متغیر در کلاس mission ) آمده است.
    int coinsAtFirst ;
    int max_egg ;
    int max_feather ;
    int max_milk ;
    int max_egg_first_product ;
    int max_feather_first_product ;
    int max_milk_first_product ;
    int max_egg_second_product ;
    int max_feather_second_product ;
    int max_milk_second_product ;
    int max_mission_coins ;
    int max_hen ;
    int max_turkey ;
    int max_buffalo ;
    String wildAnimals[][] ;
    int maxTime ;
    int coinsForReward;


    //کانستراکتور این کلاس
    Level(int coinsAtFirst ,
          int max_egg ,
          int max_feather ,
          int max_milk ,
          int max_egg_first_product ,
          int max_feather_first_product ,
          int max_milk_first_product ,
          int max_egg_second_product ,
          int max_feather_second_product ,
          int max_milk_second_product ,
          int max_mission_coins ,
          int max_hen ,
          int max_turkey ,
          int max_buffalo ,
          String[][] wildAnimals ,
          int maxTime ,
          int coinsForReward){
        this.coinsAtFirst = coinsAtFirst ;
        this.max_egg = max_egg;
        this.max_feather = max_feather ;
        this.max_milk = max_milk;
        this.max_egg_first_product = max_egg_first_product ;
        this.max_feather_first_product = max_feather_first_product;
        this.max_milk_first_product = max_milk_first_product;
        this.max_egg_second_product = max_egg_second_product;
        this.max_feather_second_product = max_feather_second_product;
        this.max_milk_second_product = max_milk_second_product;
        this.max_mission_coins = max_mission_coins ;
        this.max_hen = max_hen ;
        this.max_turkey = max_turkey ;
        this.max_buffalo = max_buffalo;
        this.wildAnimals = wildAnimals ;
        this.maxTime = maxTime ;
        this.coinsForReward = coinsForReward ;
    }
}

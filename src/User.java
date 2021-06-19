//کلاس User برای اداره و ذخیره امور کاربر است .
public class User {

    int maxLevel ;
    String userName ;
    String password ;
    int coins ;

    User(String userName , String password ){
        this.userName = userName ;
        this.password = password ;
        this.maxLevel = 1 ;
        this.coins = 0 ;
    }

    User(){}
}

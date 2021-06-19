import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

//کلاسی برای نظارت بر کل کاربران
public class AllOfUsers {
    //متغیرهای این کلاس
    ArrayList<User> users ;
    File file ;

    //متغیری برای ایجاد فقط و فقط یک نمونه از این کلاس
    public static AllOfUsers AllOfUsers_Instance ;

    //کانستراکتور پرایوت این کلاس
    private AllOfUsers(){
        users = new ArrayList<>();
        File file = new File("AllOfUsers.txt");
        this.file = file ;
        try {
            if(file.createNewFile()){

            }else {
               readFile();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void addUser(User user){
        if(!isExist(user.userName)){
            this.users.add(user);
        }
        writeFile();
    }

    //تابعی برای ایجاد فقط و فقط یک نمونه از این کلاس
    public static AllOfUsers getAllOfUsers_Instance(){
        if(AllOfUsers_Instance==null){
            AllOfUsers_Instance = new AllOfUsers();
            return AllOfUsers_Instance ;
        }else {
            return null ;
        }
    }

    //تابعی برای خواندن کاربران از فایل مربوطه
    public void readFile(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<String> lines = getLines();
        String obj = "" ;
        for (int i = 0; i < lines.size(); i++) {
            String x = lines.get(i);
            if(x.equals("[")||x.equals("]")){

            }else if(x.contains("  }")){
                obj+="  }";
                User user = gson.fromJson(obj,User.class);
                this.users.add(user);
                obj="";
            }else{
                obj += x ;
            }
        }
    }

    //تابعی برای ذخیره کاربران در فایل مربوطه
    public void writeFile(){
        try {
            FileWriter fileWriter = new FileWriter(this.file);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(this.users);
            fileWriter.write(json);
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //تابعی برای گرفتن آرایه خطوط فایل جهت ایجاد User ها
    public ArrayList<String> getLines(){
        ArrayList result = new ArrayList();
        try {
            Scanner myReader = new Scanner(this.file);
            while (myReader.hasNextLine()){
                String x = myReader.nextLine();
                result.add(x);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result ;
    }

    //تابعی که در آغاز برنامه برای شناسایی کاربر قدیمی یا ورود کاربر جدید استفاده میشود.
    public User SignUpLogin(){
        System.out.printf("CHOOSE:\nSIGNUP\nLOG IN\n");
        Scanner input = new Scanner(System.in);
        String str= input.nextLine();
        String[][] strings = {{"log in","LOG IN"},{"signup","SIGNUP"}};
        for (int i = 0; i < strings.length; i++) {
            str = str.replaceAll("(?i)"+strings[i][0],strings[i][1]);
        }
        User user ;
            if(str.equals("SIGNUP")){
                user = SIGNUP();
                this.addUser(user);
                return user ;
            }else if(str.equals("LOG IN")){
                user = LOGIN();
                this.addUser(user);
                return user ;
            }else {
                System.out.println("Wrong Input!");
                user = SignUpLogin() ;
                this.addUser(user);
                return user ;
            }
    }

    //تابعی برای ورود کاربر جدید
    public User SIGNUP(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter UserName :");
        String userName = input.nextLine();
        if(!isExist(userName)){
            System.out.println("Please Enter Your Password : ");
            String password = input.nextLine();
            User user = new User(userName,password);
            System.out.println("Your Account Created Successfully!");
            return user ;
        }else {
            System.out.println("this account has already exists!");
            User user = SignUpLogin();
            return user ;
        }
    }

    //تابعی برای تشخیص این که کاربر تکراری است یا نه
    public boolean isExist(String userName){
        boolean isExist = false ;
        for (int i = 0; i < this.users.size(); i++) {
            User user = this.users.get(i);
            if(user.userName.equals(userName)){isExist = true ;}
        }
        return isExist ;
    }

    //تابعی که برای logIn کردن استفاده میشود .
    public User LOGIN(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter UserName :");
        String userName = input.nextLine();
        if(isExist(userName)){
            User user = getPassword(userName);
            return user ;
        }else {
            System.out.println("There is no such account!");
            User user = SignUpLogin() ;
            return user ;
        }
    }

    //تابعی که برای گرفتن passWord درست و مشخص کردن کاربر استفاده میشود .
    public User getPassword(String userName){
        System.out.println("Please enter password :");
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();
        if(passwordIsRight(userName,password)){
            System.out.println("LOG IN was successfully!");
            User user = getUserByName(userName,password);
            return user ;
        }else {
            System.out.println("Wrong password!");
            User user = getPassword(userName);
            return user ;
        }
    }

    //تابعی که مشخص میکند passWord وارد شده درست است یا نه
    public boolean passwordIsRight(String userName , String password){
        boolean result = false ;
        for (int i = 0; i < this.users.size(); i++) {
            User user = this.users.get(i);
            if(user.userName.equals(userName)&&user.password.equals(password)){
                result = true ;
            }
        }
        return result ;
    }


    //تابعی که با گرفتن userName و passWord کاربر را بر میگرداند .
    public User getUserByName(String userName , String password){
        User result ;
        for (int i = 0; i < this.users.size(); i++) {
            User user = this.users.get(i);
            if(user.userName.equals(userName)&&user.password.equals(password)){
                result = user ;
                return result ;
            }
        }
        return null ;
    }
}

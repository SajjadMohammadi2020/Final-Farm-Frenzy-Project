import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Mission {

    //مقادیری که ماموریت های هر مرحله را تعیین میکند .
    public static final int max_level_number = 5; //تعداد کل مراحل
    public static final int coins_at_first[] = {100,150,200,250,300};//تعداد سکه ها در ابتدای مرحله
    public static final int max_time_level[] = {100,120,140,160,180};//حداکثر زمان جایزه دار مرحله
    public static final int coins_for_reward[] = {30,50,70,90,110};//تعداد سکه های جایزه در صورت اتمام در زمان معین
    public static final int max_egg[] = {5,6,7,8,9} ; //تعداد تخم مرغ های مورد نیاز در هر مرحله
    public static final int max_feather[] = {2,3,4,5,6};//تعداد تخم پرهای مورد نیاز در هر مرحله
    public static final int max_milk[] = {1,2,3,4,5};//مقدار شیر مورد نیاز در هر مرحله
    public static final int max_egg_first_product[] = {4,5,6,7,8} ;//مقدار آرد در مورد نیاز در هر مرحله
    public static final int max_feather_first_product[] = {3,4,5,6,7} ;//مقدار پارچه مورد نیاز در هر مرحله
    public static final int max_milk_first_product [] = {2,3,4,5,6};//مقدار شیر پاکتی مورد نیاز در هر مرحله
    public static final int max_egg_second_product[] = {3,4,5,6,7} ;//مقدار نان مورد نیاز در هر مرحله
    public static final int max_feather_second_product[] = {3,4,5,6,7} ;//مقدار پیراهن مورد نیاز در هر مرحله
    public static final int max_milk_second_product [] = {2,3,4,5,6};//مقدار بستنی مورد نیاز در هر مرحله
    public static final int max_mission_coins[] = {50,60,70,80,90} ;//مقدار سکه مورد نیاز در هر مرحله
    public static final int max_hen [] = {4,5,6,7,8};//تعداد مرغ مورد نیاز هر مرحله
    public static final int max_turkey[] = {4,5,6,7,8} ;//تعداد بوقلمون مورد نیاز در هر مرحله
    public static final int max_buffalo[] = {3,4,5,6,7} ;//تعداد بوفالو مورد نیاز در هر مرحله
    public static final String wildAnimals[][][] = { { {"Lion","10"} , {"Lion","25"} }  ,  { {"Lion","12" } , {"Lion","23" } , {"Lion","35"} } ,
            { {"Lion","15"} , {"Bear","24"} , {"Lion" , "40"} } , { {"Lion","15" } , { "Bear","30" } , {"Tiger","50"}} ,
            { {"Bear","15"} , {"Tiger","35"} , {"Tiger","50"}}};//حیوانات وحشی و زمان فرود آنها در هر مرحله


    //متغیر های این کلاس
    int levelNumber ;
    Level[] levels ;

    //کانستراکتور این کلاس
    Mission(){
        readFile();
    }

    //تابعی برای ایجاد ماموریت های مراحل جدید
    public void createNewMission(){
        this.levelNumber = max_level_number ;
        this.levels = new Level[levelNumber] ;
        for (int i = 0; i < levelNumber; i++) {
            this.levels[i] = new Level(coins_at_first[i],max_egg[i],max_feather[i],
                    max_milk[i],max_egg_first_product[i],max_feather_first_product[i],max_milk_first_product[i],
                    max_egg_second_product[i],max_feather_second_product[i],max_milk_second_product[i],
                    max_mission_coins[i],max_hen[i],max_turkey[i],max_buffalo[i],wildAnimals[i],max_time_level[i],
                    coins_for_reward[i] );
        }
    }

    //تابعی برای نوشتن ذخیره ماموریت ها در فایل
    public void writeFile(){
        try {
            File file = new File("missions.txt");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String js = gson.toJson(this.levelNumber)+"\n";
            fileWriter.write(js);
            String j = gson.toJson(this.levels);
            fileWriter.write(j);
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //تابعی برای خواندن ماموریت ها از فایل
    public void readFile(){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            File file = new File("missions.txt");
            file.createNewFile();
            ArrayList<String> lines = getLines(file);
            String level = lines.get(0);
            String obj = "" ;
            int j = 0 ;
            this.levelNumber = gson.fromJson(level,int.class);
            this.levels = new Level[this.levelNumber];
            for (int i = 2; i < lines.size(); i++) {
                String x = lines.get(i);
                if(x.equals("[")||x.equals("]")){

                } else if (x.contains("  }")){
                    obj += "  }" ;
                    Level level1 = gson.fromJson(obj,Level.class);
                    this.levels[j] = level1 ; j++ ;
                    obj = "" ;
                }else {
                    obj += x ;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //تابعی برای گرفتن خطوط فایل جهت خواندن ماموریت ها
    public ArrayList<String> getLines(File file){
        ArrayList<String> result = new ArrayList<>();
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()){
                String x = myReader.nextLine();
                result.add(x);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result ;
    }

}

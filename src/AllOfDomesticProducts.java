import java.util.ArrayList;

//کلاسی برای نظارت بر محصولات تولیدی حیوانات اهلی
public class AllOfDomesticProducts {

    //متغیر های این کلاس
    ArrayList<DomesticAnimalProduct> products ;

    public static AllOfDomesticProducts allOfDomesticProducts_instance ;

    //کانستراکتور پرایوت این کلاس
    private AllOfDomesticProducts(){
        this.products = new ArrayList<>();
    }

    //تابعی برای ایجاد فقظ و فقط یک نمونه ار کلاس
    public static AllOfDomesticProducts getAllOfDomesticProducts_instance(){
        if(allOfDomesticProducts_instance==null){
            allOfDomesticProducts_instance = new AllOfDomesticProducts();
            return allOfDomesticProducts_instance ;
        } else {
            return null ;
        }
    }

    //تابعی برای افزودن محصول
    public static void addDomesticAnimalProduct(DomesticAnimalProduct product){
        allOfDomesticProducts_instance.products.add(product);
    }

    //تابعی برای گرفتن محصولات حیوانات اهلی با استفاده ار موقعیت
    public static DomesticAnimalProduct getDomesticAnimalProductByLocation(int x , int y ){
        DomesticAnimalProduct result ;
        for (int i = 0; i < allOfDomesticProducts_instance.products.size(); i++) {
            DomesticAnimalProduct product = allOfDomesticProducts_instance.products.get(i);
            if(product.x==x&&product.y==y){
                result = product ;
                return result ;
            }
        }
        return null ;
    }
}

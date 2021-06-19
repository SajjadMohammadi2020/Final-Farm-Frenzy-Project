public class WorkShops {
    private int cost;
    private int requiredTime;
    private boolean isWorking;
    private String workshopName;
    private int passedTime;
    private String requiredItem;
    private String product;

    public WorkShops(String workshopName,int cost,int requiredTime,String requiredItem,String product){
        this.workshopName = workshopName;
        this.cost = cost;
        this.requiredTime = requiredTime;
        this.requiredItem = requiredItem;
        this.product = product;
    }

    public String getWorkshopName(){return workshopName;}

    public int getCost(){return cost;}

    public boolean getIsWorking(){return isWorking;}

    public void setWorkingTrue(){this.isWorking = true;}

    public void setWorkingFalse(){this.isWorking = false;}

    public void passingTime(){this.passedTime++;}

    public void setPassedTimeZero(){this.passedTime = 0;}

    public String getRequiredItem(){return requiredItem;}

    public String getProduct(){return product;}

    public boolean isFinished(){
        if(this.passedTime == this.requiredTime)
            return true;
        else
            return false;
    }
}

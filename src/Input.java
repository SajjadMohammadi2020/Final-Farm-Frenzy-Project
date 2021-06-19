import java.util.Locale;
import java.util.Scanner;

public class Input {

    private Manager manager;
    private Scanner sc = new Scanner(System.in);

    public Input(Manager manager){
        this.manager = manager;
    }

    private void processBuilding(String[] split){
        if(split[1].toLowerCase(Locale.ROOT).equals("mill"))
            manager.buildMill();
        else if(split[1].toLowerCase(Locale.ROOT).equals("fabric"))
            manager.buildFabricWeaving();
        else if(split[1].toLowerCase(Locale.ROOT).equals("milk"))
            manager.buildMilkPacking();
        else if(split[1].toLowerCase(Locale.ROOT).equals("bakery"))
            manager.buildBakery();
        else if(split[1].toLowerCase(Locale.ROOT).equals("tailoring"))
            manager.buildTailoring();
        else if(split[1].toLowerCase(Locale.ROOT).equals("ice"))
            manager.buildIceCreamWorkshop();
        else
            System.out.println("Invalid build order!!!");
    }

    private void processWorking(String[] split){
        if(split[1].toLowerCase(Locale.ROOT).equals("mill"))
            manager.working("Mill");
        else if(split[1].toLowerCase(Locale.ROOT).equals("fabric"))
            manager.working("FabricWeaving");
        else if(split[1].toLowerCase(Locale.ROOT).equals("milk"))
            manager.working("MilkPacking");
        else if(split[1].toLowerCase(Locale.ROOT).equals("bakery"))
            manager.working("Bakery");
        else if(split[1].toLowerCase(Locale.ROOT).equals("tailoring"))
            manager.working("Tailoring");
        else if(split[1].toLowerCase(Locale.ROOT).equals("ice"))
            manager.working("IceCreamWorkshop");
    }

    private void processPickingUp(String[] split){
        manager.pickupItem(Integer.parseInt(split[1]),Integer.parseInt(split[2]));
    }

    private void processTransporting(String[] split){
        if(split[1].toLowerCase(Locale.ROOT).equals("load"))
            manager.truckLoad(split[2].toLowerCase(Locale.ROOT));
        else if(split[1].toLowerCase(Locale.ROOT).equals("unload"))
            manager.truckUnload(split[2].toLowerCase(Locale.ROOT));
        else
            manager.sendTruck();
    }

    private void processTurn(String[] split){
        manager.passTurn(Integer.parseInt(split[1]));
    }

    private void processPlant(String[] split){
        manager.planting(Integer.parseInt(split[1]),Integer.parseInt(split[2]));
    }

    public void run(){
        String input;
        while (!(input = sc.nextLine()).equalsIgnoreCase("LOG OUT")){
            if(input.toLowerCase(Locale.ROOT).startsWith("build"))
                processBuilding(input.split("\\s"));
            else if(input.toLowerCase(Locale.ROOT).startsWith("work"))
                processWorking(input.split("\\s"));
            else if(input.toLowerCase(Locale.ROOT).startsWith("turn"))
                processTurn(input.split("\\s"));
            else if(input.toLowerCase(Locale.ROOT).startsWith("pickup"))
                processPickingUp(input.split("\\s"));
            else if(input.toLowerCase(Locale.ROOT).startsWith("truck"))
                processTransporting(input.split("\\s"));
            else if(input.toLowerCase(Locale.ROOT).equals("well"))
                manager.well();
            else if(input.toLowerCase(Locale.ROOT).startsWith("plant"))
                processPlant(input.split("\\s"));
            else if(input.toLowerCase(Locale.ROOT).startsWith("buy")){
                manager.buyAnimal(input.toLowerCase(Locale.ROOT).split("\\s")[1]);
            }else if(input.toLowerCase(Locale.ROOT).startsWith("cage")){
                String [] caging = input.split("\\s");
                int x = Integer.parseInt(caging[1]);
                int y = Integer.parseInt(caging[2]);
                manager.cage(x,y);
            } else if(input.toLowerCase(Locale.ROOT).equals("inquiry")){
                manager.inquiry();
            } else {
                System.out.println("Wrong input!!");
            }
        }
    }
}

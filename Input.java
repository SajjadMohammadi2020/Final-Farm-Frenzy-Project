import java.lang.ref.SoftReference;
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
            manager.working("mill");
        else if(split[1].toLowerCase(Locale.ROOT).equals("fabric"))
            manager.working("fabricweaving");
        else if(split[1].toLowerCase(Locale.ROOT).equals("milk"))
            manager.working("milkpacking");
        else if(split[1].toLowerCase(Locale.ROOT).equals("bakery"))
            manager.working("bakery");
        else if(split[1].toLowerCase(Locale.ROOT).equals("tailoring"))
            manager.working("tailoring");
        else if(split[1].toLowerCase(Locale.ROOT).equals("ice"))
            manager.working("icecreamworkshop");
    }

    private void processPickingUp(String[] split){
        if((Integer.parseInt(split[1]) < 1 && Integer.parseInt(split[1]) > 6) && (Integer.parseInt(split[2]) < 1 && Integer.parseInt(split[2]) > 6))
            System.out.println("Invalid numbers!!!");
        else
            manager.pickupItem(Integer.parseInt(split[1]),Integer.parseInt(split[2]));

    }

    private void processTransporting(String[] split){
        if(split[1].toLowerCase(Locale.ROOT).equals("load"))
            manager.truckLoad(split[1].toLowerCase(Locale.ROOT));
        else if(split[1].toLowerCase(Locale.ROOT).equals("unload"))
            manager.truckUnload(split[1].toLowerCase(Locale.ROOT));
        else
            manager.sendTruck();
    }

    private void processTurn(String[] split){
        manager.passTurn(Integer.parseInt(split[1]));
    }

    private void processPlant(String[] split){
        if((Integer.parseInt(split[1]) < 1 || Integer.parseInt(split[1]) > 6) || (Integer.parseInt(split[2]) < 1 || Integer.parseInt(split[2]) > 6))
            System.out.println("Invalid numbers!!!");
        else
            manager.planting(Integer.parseInt(split[1]),Integer.parseInt(split[2]));
    }

    private void processUpgrade(String[] split){
        manager.upgradeWorkshop(split[1].toLowerCase(Locale.ROOT));
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
            else if(input.toLowerCase(Locale.ROOT).startsWith("upgrade"))
                processUpgrade(input.split("\\s"));
        }
    }
}

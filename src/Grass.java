public class Grass {
    private int row;
    private int column;
    private int number;

    public Grass(int row,int column){
        this.row = row;
        this.column = column;
        this.number = 1;
    }

    public int getRow(){return row;}

    public int getColumn(){return column;}

    public void setNumber(){this.number++;}

    public void decreaseNumber(){this.number--;}

    public int getNumber(){return this.number;}
}

package model.cases;

public class CasePiege extends Case{

    public CasePiege(int x, int y){
        super(x,y);
    }

    @Override
    public void action() {
        //Blesse le Joueur
    }

    @Override
    public boolean hasAction() {
        return true;
    }

    @Override
    public String toString() {
        return "4";
    }
}

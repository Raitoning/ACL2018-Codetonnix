package model.cases;

public class CasePiege extends Case{

    public CasePiege(int x, int y){
        super(x,y);
    }

    @Override
    public void action() {

    }

    @Override
    public boolean hasAction() {
        return true;
    }


}

package model.cases;

public class CaseMagique extends Case{

    public CaseMagique(int x, int y){
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

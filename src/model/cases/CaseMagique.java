package model.cases;

public class CaseMagique extends Case{

    public CaseMagique(int x, int y){
        super(x,y);
    }

    @Override
    public void action() {
        //Fait quelquechose
    }

    @Override
    public boolean hasAction() {
        return true;
    }
}

package model.cases;

import model.Heros;

public class CaseMagique extends Case{

    private boolean active;

    public CaseMagique(int x, int y){
        super(x,y);
        active = false;
    }

    @Override
    public void action(Heros h) {
        //Fait quelquechose
        if(!active){
            h.setPtsVie(h.getPtsVie()+1);
            this.active = true;
        }
    }

    @Override
    public boolean hasAction() {
        return true;
    }

    @Override
    public String toString() {
        return "2";
    }
}

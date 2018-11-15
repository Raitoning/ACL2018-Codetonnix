package model.cases;

import model.Heros;

public class CasePiege extends Case{

    private boolean active;

    public CasePiege(int x, int y){
        super(x,y);
        active = false;
    }

    @Override
    public void action(Heros h) {
        //Blesse le Joueur
        h.setPtsVie(h.getPtsVie()-1);
        h.setInvincible(true);
        active = true;
    }

    @Override
    public boolean hasAction() {
        return true;
    }


}

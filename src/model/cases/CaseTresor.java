package model.cases;

import model.Heros;

public class CaseTresor extends Case{

    public CaseTresor(int x, int y){
        super(x,y);
    }

    @Override
    public void action(Heros h) {
        //met fin au jeu
        System.out.println("Tu as vaincu ! Espèrons que tu ais 20 chaises maintenant...");
    }

    @Override
    public String toString() {
        return "5";
    }
}

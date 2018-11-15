package model.cases;

import model.Heros;

public class CasePassage extends Case {

    private CasePassage casePassage;

    public CasePassage(int x, int y){
        super(x,y);
        casePassage = null;
    }

    public CasePassage(int x, int y, CasePassage c){
        super(x,y);
        casePassage = c;
    }

    @Override
    public void action(Heros h) {
        //Téléporte le joueur
        int x = (int)(Math.random()*50);
        int y = (int)(Math.random()*50);
        h.setPos(x,y);
    }

    @Override
    public String toString() {
        return "3";
    }
}

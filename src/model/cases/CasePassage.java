package model.cases;

import model.Heros;

import java.util.Random;

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
        Random random = new Random();
        int x = random.nextInt(49);
        int y = random.nextInt(49);
        h.setPos(x*20,y*20);
    }

    @Override
    public String toString() {
        return "3";
    }

    public boolean hasAction(){
        return true;
    }
}

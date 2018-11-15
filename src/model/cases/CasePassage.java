package model.cases;

import model.Heros;

import java.util.Random;

public class CasePassage extends Case {

    private CasePassage link;

    public CasePassage(int x, int y){
        super(x,y);
    }

    public CasePassage(int x, int y, CasePassage link) {
        super(x, y);
        this.link = link;
        link.link(this);
    }

    public void link(CasePassage link) {
        this.link = link;
    }

    public CasePassage getLink() {
        return link;
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

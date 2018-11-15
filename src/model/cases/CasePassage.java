package model.cases;

import model.Heros;

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
        int x = (int)(Math.random()*50);
        int y = (int)(Math.random()*50);
        h.setPos(x,y);
    }



    @Override
    public String toString() {
        return "3";
    }
}

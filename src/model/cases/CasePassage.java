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
        h.setPos(link.getPosX()*20,link.getPosY()*20);
    }

    @Override
    public String toString() {
        return "3";
    }

    public boolean hasAction(){
        return true;
    }
}

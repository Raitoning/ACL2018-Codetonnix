package model.cases;

import model.Heros;

public class CaseDefaut extends Case{

    public CaseDefaut(int x, int y){
        super(x,y);
    }

    @Override
    public void action(Heros h) {

    }

    @Override
    public String toString() {
        return "0";
    }
}

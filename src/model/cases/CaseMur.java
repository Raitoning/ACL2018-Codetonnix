package model.cases;

import javax.imageio.ImageIO;
import java.awt.*;

public class CaseMur extends Case{

    public CaseMur(int x, int y){
        super(x,y);
    }

    @Override
    public void action() {

    }

    @Override
    public String toString() {
        return "1";
    }


    @Override
    public boolean isSolid() {
        return true;
    }

}

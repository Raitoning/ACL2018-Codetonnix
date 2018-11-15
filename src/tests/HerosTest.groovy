package tests

import engine.Cmd
import model.Heros
import model.Labyrinthe
import model.cases.CaseDefaut
import model.cases.CaseMur
import org.junit.Before
import org.junit.Test
import static org.junit.Assert.*

class HerosTest{

    private Labyrinthe l;
    private Heros h;

    @Before
    public void setUp(){
        l = new Labyrinthe();
        /**
         *  Création d'une partie du labyrinthe de la forme (x: murs, o: defaut)
         *  x x x x x
         *  x o o o x
         *  x o o o x
         *  x o o o x
         *  x x x x x
         */
        for(int i = 3; i<=7; i++){
            for(int j = 3; j<=7; j++){
                if(i == 3 ||i == 7|| j == 3 || j == 7){
                    l.setCases(i,j,new CaseMur(i,j))
                }else{
                    l.setCases(i,j,new CaseDefaut(i,j));
                }
            }
        }
        //Creation du heros place sur la case [5][5] du tableau cases du labyrinthe l
        h = new Heros(100,100,3);
    }

    @Test
    public void testDeplacementDroite(){
        h.deplacer(Cmd.RIGHT,l);
        assertEquals("Déplacement à droite invalide, devrait être à 120",120,h.getPosX());
        assertEquals("Y devrait rester à 100",100,h.getPosY());
    }

    @Test
    public void testDeplacementGauche(){
        Heros h = new Heros(100,100,3);
        h.deplacer(Cmd.LEFT,l);
        assertEquals("Déplacement à gauche invalide, devrait être à 80",80,h.getPosX());
        assertEquals("Y devrait rester à 100",100,h.getPosY());
    }

    @Test
    public void testDeplacementHaut(){
        h.deplacer(Cmd.UP,l);
        assertEquals("Déplacement vers le haut invalide, devrait être à 80",80,h.getPosY());
        assertEquals("X devrait rester à 100",100,h.getPosX());
    }

    @Test
    public void testDeplacementBas(){
        h.deplacer(Cmd.DOWN,l);
        assertEquals("Déplacement vers le haut invalide, devrait être à 120",120,h.getPosY());
        assertEquals("X devrait rester à 100",100,h.getPosX());
    }

    @Test
    public void testColisionDroite(){
        h.deplacer(Cmd.RIGHT,l);
        h.deplacer(Cmd.RIGHT,l);
        assertEquals("Colision à droite invalide, x devrait valoir 120",120,h.getPosX());
        assertEquals("y devrait rester à 100",100,h.getPosY());
    }

    @Test
    public void testColisionGauche(){
        h.deplacer(Cmd.LEFT,l);
        h.deplacer(Cmd.LEFT,l);
        assertEquals("Colision à gauche invalide, x devrait valoir 80",80,h.getPosX());
        assertEquals("y devrait rester à 100",100,h.getPosY());
    }

    @Test
    public void testColisionBas(){
        h.deplacer(Cmd.DOWN,l);
        h.deplacer(Cmd.DOWN,l);
        assertEquals("Colision vers le bas invalide, y devrait valoir 120",120,h.getPosY());
        assertEquals("x devrait rester à 100",100,h.getPosX());
    }

    @Test
    public void testColisionHaut(){
        h.deplacer(Cmd.UP,l);
        h.deplacer(Cmd.UP,l);
        assertEquals("Colision vers le bas invalide, y devrait valoir 80",80,h.getPosY());
        assertEquals("x devrait rester à 100",100,h.getPosX());
    }

}

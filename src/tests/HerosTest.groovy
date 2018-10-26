package tests

import engine.Cmd
import model.Heros

class HerosTest extends groovy.util.GroovyTestCase {

    public void testDeplacementDroite(){
        Heros h = new Heros(5,5,3);
        h.deplacer(Cmd.RIGHT);
        assertEquals("Déplacement à droite invalide, devrait être à 6",6,h.getPosX());
        assertEquals("Y devrait rester à 5",5,h.getPosY());
    }

    public void testDeplacementGauche(){
        Heros h = new Heros(5,5,3);
        h.deplacer(Cmd.LEFT);
        assertEquals("Déplacement à gauche invalide, devrait être à 4",4,h.getPosX());
        assertEquals("Y devrait rester à 5",5,h.getPosY());
    }

    public void testDeplacementHaut(){
        Heros h = new Heros(5,5,3);
        h.deplacer(Cmd.UP);
        assertEquals("Déplacement vers le haut invalide, devrait être à 4",4,h.getPosY());
        assertEquals("X devrait rester à 5",5,h.getPosX());
    }

    public void testDeplacementBas(){
        Heros h = new Heros(5,5,3);
        h.deplacer(Cmd.DOWN);
        assertEquals("Déplacement vers le haut invalide, devrait être à 6",6,h.getPosY());
        assertEquals("X devrait rester à 5",5,h.getPosX());
    }

}

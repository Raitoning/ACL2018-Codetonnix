package model;

import model.cases.*;

import java.io.File;
import java.util.Random;

public class Labyrinthe {

    private Case[][] cases;
    private final int NBCASES = 50;

    public Labyrinthe(){

        cases = new Case[NBCASES][NBCASES];

        Random r= new Random();
        for (int i=0;i<cases.length;i+=5){
            for (int j =0;j<cases[0].length;j+=5) {
                metaTilesInit(r.nextInt(11)+1,i,j);
            }
        }

        //System.out.println(this); //affichage du labyrinthe généré
    }

    public void generer(File f){

    }

    private void metaTilesInit(int arg,int x,int y){


        if (arg ==1) {
            /** Tuile de la forme:(x murs, o default)
             * x o x o x
             * o o o o o
             * x o x o x
             * o o o o o
             * x o x o x
             */
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i % 2 == 0 && j % 2 == 0) {
                        cases[x + i][y + j] = new CaseMur(x + i, x + j);
                    } else {
                        cases[x + i][y + j] = new CaseDefaut(x + i, x + j);
                    }
                }
            }
        } else if (arg ==2){
            /** Tuile de la forme:(x murs, o default)
             * x o x o x
             * o o x o o
             * x x x x x
             * o o x o o
             * x o x o x
             */
            metaTileLineInit(x,y,true,false,true, false,true);
            metaTileLineInit(x+1,y,false,false,true, false,false);
            metaTileLineInit(x+2,y,true,true,true, true,true);
            metaTileLineInit(x+3,y,false,false,true, false,false);
            metaTileLineInit(x+4,y,true,false,true, false,true);
        } else if (arg ==3) {
            /** Tuile de la forme:(x murs, o default)
             * x o o o x
             * o x x x o
             * o x x x o
             * o x x x o
             * x o o o x
             */
            metaTileLineInit(x,y,true,false,false, false,true);
            metaTileLineInit(x+1,y,false,true,true, true,false);
            metaTileLineInit(x+2,y,false,true,true, true,false);
            metaTileLineInit(x+3,y,false,true,true, true,false);
            metaTileLineInit(x+4,y,true,false,false, false,true);

        } else if (arg ==4) {
            /** Tuile de la forme:(x murs, o default) ! Dangerous tile
             * x x x o x
             * o o o o x
             * o x x x x
             * o o x o o
             * x o x o x
             */
            metaTileLineInit(x,y,true,true,true, false,true);
            metaTileLineInit(x+1,y,false,false,false, false,true);
            metaTileLineInit(x+2,y,false,true,true, true,true);
            metaTileLineInit(x+3,y,false,false,true, false,false);
            metaTileLineInit(x+4,y,true,false,true, false,true);

        } else if (arg ==5) {
            /** Tuile de la forme:(x murs, o default) ! Dangerous tile
             * x o x x x
             * x o o o o
             * x x x x x
             * o o o o x
             * x x x o x
             */
            metaTileLineInit(x,y,true,false,true,true,true);
            metaTileLineInit(x+1,y,true,false,false,false,false);
            metaTileLineInit(x+2,y,true,true,true,true,true);
            metaTileLineInit(x+3,y,false,false,false,false,true);
            metaTileLineInit(x+4,y,true,false,true,true,true);

        } else if (arg ==6) {
            /** Tuile de la forme:(x murs, o default)
             * x o x o x
             * o o x o o
             * x o x x x
             * o o o o o
             * x o x o x
             */
            metaTileLineInit(x,y,true,false,true, false,true);
            metaTileLineInit(x+1,y,false,false,true,false,false);
            metaTileLineInit(x+2,y,true,false,true,true,true);
            metaTileLineInit(x+3,y,false,false,false,false,false);
            metaTileLineInit(x+4,y,true,false,true,false,true);

        } else if (arg ==7) {
            /** Tuile de la forme:(x murs, o default)
             * x o x o x
             * o o x o o
             * x o x o x
             * o o x o o
             * x o x o x
             */
            metaTileLineInit(x,y,true,false,true, false,true);
            metaTileLineInit(x+1,y,false,false,true,false,false);
            metaTileLineInit(x+2,y,true,false,true,false,true);
            metaTileLineInit(x+3,y,false,false,true,false,false);
            metaTileLineInit(x+4,y,true,false,true,false,true);

        } else if (arg ==8) {
            /** Tuile de la forme:(x murs, o default)
             * x o x o x
             * o o o o o
             * x x x x x
             * o o o o o
             * x o x o x
             */
            metaTileLineInit(x,y,true,false,true, false,true);
            metaTileLineInit(x+1,y,false,false,false, false,false);
            metaTileLineInit(x+2,y,true,true,true,true,true);
            metaTileLineInit(x+3,y,false,false,false,false,false);
            metaTileLineInit(x+4,y,true,false,true,false,true);

        } else if (arg ==9) {
            /** Tuile de la forme:(x murs, o default)
             * o o x o o
             * o x x x o
             * x x x x x
             * o x x x o
             * o o x o o
             */
            metaTileLineInit(x,y,false,false,true,false,false);
            metaTileLineInit(x+1,y,false,true,true,true,false);
            metaTileLineInit(x+2,y,true,true,true,true,true);
            metaTileLineInit(x+3,y,false,true,true,true,false);
            metaTileLineInit(x+4,y,false,false,true,false,false);

        } else if (arg ==9) {
            /** Tuile de la forme:(x murs, o default)
             * o o x o o
             * o x x x o
             * x x x x x
             * o x x x o
             * o o x o o
             */
            metaTileLineInit(x,y,false,false,true,false,false);
            metaTileLineInit(x+1,y,false,true,true,true,false);
            metaTileLineInit(x+2,y,true,true,true,true,true);
            metaTileLineInit(x+3,y,false,true,true,true,false);
            metaTileLineInit(x+4,y,false,false,true,false,false);

        } else if (arg ==10) {
            /** Tuile de la forme:(x murs, o default)
             * o o x o x
             * o x o o o
             * x o o o x
             * o o o x o
             * x o x o o
             */
            metaTileLineInit(x,y,false,false,true,false,true);
            metaTileLineInit(x+1,y,false,true,false,false,false);
            metaTileLineInit(x+2,y,true,false,false,false,true);
            metaTileLineInit(x+3,y,false,false,false,true,false);
            metaTileLineInit(x+4,y,true,false,true,false,false);

        } else if (arg ==11) {
            /** Tuile de la forme:(x murs, o default)
             * x o x o o
             * o o o x o
             * x o o o x
             * o x o o o
             * o o x o x
             */
            metaTileLineInit(x,y,true,false,true,false,false);
            metaTileLineInit(x+1,y,false,false,false,true,false);
            metaTileLineInit(x+2,y,true,false,false,true,true);
            metaTileLineInit(x+3,y,false,true,false,false,false);
            metaTileLineInit(x+4,y,false,false,true,false,true);
        } else {
            System.out.println("Unknown argument: '"+arg+"'");
        }


    }

    /**
     * Fonction d'initialisation d'une ligne d'une meta-tile (1x5)
     * @param x x d'origine
     * @param y y d'origine
     * @param z Suite de boolens vrai s'il y a un mur faux sinon
     */
    private void metaTileLineInit(int x,int y, boolean ... z){
        for (int i =0;i<z.length;i++){
            if(z[i]){
                cases[x][y+i]= new CaseMur(x,y+i);
            } else {
                cases[x][y+i] = new CaseDefaut(x,y+i);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<cases.length;i++){
            for(int j=0;j<cases[0].length;j++){
                sb.append(cases[i][j].toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Case[][] getCases() {
        return cases;
    }

    public int getNBCASES() {
        return NBCASES;
    }
}

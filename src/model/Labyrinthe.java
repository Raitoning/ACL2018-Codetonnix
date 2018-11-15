package model;

import model.cases.*;

import java.io.File;
import java.util.Random;

public class Labyrinthe {

    private Case[][] cases;
    private final int NBCASES = 50;

    public Labyrinthe(){

        cases = new Case[NBCASES][NBCASES];

        randomGeneration(cases);

        randomSpecialTilesinit(cases,7);
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
            metaTileLineInit(x,y,true,false,true, false,true);
            metaTileLineInit(x+1,y,false,false,false, false,false);
            metaTileLineInit(x+2,y,true,false,true, false,true);
            metaTileLineInit(x+3,y,false,false,false, false,false);
            metaTileLineInit(x+4,y,true,false,true, false,true);
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
             * o o x o o
             * o x x x o
             * o o x o o
             * x o o o x
             */
            metaTileLineInit(x,y,true,false,false, false,true);
            metaTileLineInit(x+1,y,false,false,true, false,false);
            metaTileLineInit(x+2,y,false,true,true, true,false);
            metaTileLineInit(x+3,y,false,false,true, false,false);
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
             * o o o o o
             * o x o x o
             * x x o x x
             * o x o x o
             * o o o o o
             */
            metaTileLineInit(x,y,false,false,false,false,false);
            metaTileLineInit(x+1,y,false,false,true,true,false);
            metaTileLineInit(x+2,y,true,true,false,true,true);
            metaTileLineInit(x+3,y,false,true,false,true,false);
            metaTileLineInit(x+4,y,false,false,false,false,false);

        } else if (arg ==10) {
            /** Tuile de la forme:(x murs, o default)
             * o o o o o
             * o x x x o
             * o x x x o
             * o x x x o
             * o o o o o
             */
            metaTileLineInit(x,y,false,false,false,false,false);
            metaTileLineInit(x+1,y,false,true,true,true,false);
            metaTileLineInit(x+2,y,false,true,true,true,false);
            metaTileLineInit(x+3,y,false,true,true,true,false);
            metaTileLineInit(x+4,y,false,false,false,false,false);

        } else if (arg ==11) {
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

        } else if (arg ==12) {
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

    public void randomSpecialTilesinit(Case cases[][], int amount){

        int x,y;
        Random r = new Random();
        x = r.nextInt(getNBCASES());
        y = r.nextInt(getNBCASES());

        for (int i =0; i<amount;i++){

            while (!outOfBounds(x,y)&&(!cases[x][y].toString().equals("1"))&&(!cases[x][y].hasAction())){
                x = r.nextInt(getNBCASES());
                y = r.nextInt(getNBCASES());
            }

            if (i==0){
                setCase(new CaseTresor(x,y),x,y);
            } else {
                setCase(randomCase(r.nextInt(3),x,y),x,y);
            }

        }

    }


    private Case randomCase(int n, int x, int y){
        if (n==0){
            return dualPassage(new CasePassage(x,y));
        } else if (n==1) {
            return new CasePiege(x, y);
        } else {
            return new CaseMagique(x,y);
        }
    }

    private CasePassage dualPassage(CasePassage p){
        Random r = new Random();
        int x = r.nextInt(getNBCASES());
        int y = r.nextInt(getNBCASES());

        while (!outOfBounds(x,y)&&(!cases[x][y].toString().equals("1"))){
            x = r.nextInt(getNBCASES());
            y = r.nextInt(getNBCASES());
        }

        setCase(new CasePassage(x,y,p),x,y);
        return p;
    }

    public void setCase(Case c, int x, int y) {
        if (!outOfBounds(x,y))
            this.cases[x][y] = c;
        else
            System.out.println("Change not Possible");
    }

    private boolean outOfBounds(int x, int y){
        return (x>cases.length||y>cases[0].length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<cases.length;i++){
            for(int j=0;j<cases[0].length;j++){
                sb.append(cases[j][i].toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void randomGeneration (Case cases[][]){
        Random r= new Random();
        for (int i=0;i<cases.length;i+=5){
            for (int j =0;j<cases[0].length;j+=5) {
                metaTilesInit(r.nextInt(11)+1,i,j);
            }
        }

    }

    public Case[][] getCases() {
        return cases;
    }

    public void setGeneration(Case cases[][], int... metatiles){
        Random r= new Random();
        int y=0;
        for (int i=0;i<cases.length;i+=5){
            for (int j =0;j<cases[0].length;j+=5) {
                if (y<metatiles.length) {
                    metaTilesInit(metatiles[y], i, j);
                    y+=1;
                } else {
                    metaTilesInit(r.nextInt(11)+1,i,j);
                }
            }
        }
    }

    private static final int[] exemple = {
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 3, 4, 5, 6, 7, 8, 9,10, 1,
            1, 6, 7, 8,10, 9,11, 7, 5, 1,
            1, 9,10,11, 1, 2, 3, 4, 5, 1,
            1, 7, 2, 3, 7, 4, 2, 5, 9, 1,
            1, 3, 7, 4, 3, 5, 5, 6,10, 1,
            1, 2, 1, 4, 1, 1,10,11,12, 1,
            1, 6, 3, 4, 7, 9,10, 1,12, 1,
            1, 1, 2, 5, 6, 8,11,12,10, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }; //50x50 cases


    public int getNBCASES() {
        return NBCASES;
    }

}

package model;

import model.cases.*;

import java.io.File;

public class Labyrinthe {

    private Case[][] cases;

    public Labyrinthe(){

        cases = new Case[50][50];

        for (int i=0;i<cases.length;i+=5){
            for (int j =0;j<cases[0].length;j+=5) {
                metaTilesInit(1,i,j);
            }
        }

    }

    public void generer(File f){

    }

    private void metaTilesInit(int arg,int x,int y){

        for (int i=0;i<5;i++){
            for (int j =0;j<5;j++){
                if (i%2==0&&j%2==0){
                    cases[x+i][y+j]= new CaseMur(x+i,x+j);
                } else {
                    cases[x+i][y+j]= new CaseDefaut(x+i,x+j);
                }
            }
        }

    }
}

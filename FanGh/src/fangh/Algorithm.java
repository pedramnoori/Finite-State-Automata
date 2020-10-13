/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fangh;

import java.util.Scanner;

/**
 *
 * @author pedram
 */
public class Algorithm {

    String[][] strArrayInput;
    String startState;
    String[] finalState;
    Scanner s = new Scanner(System.in);
    int intStateNumber = 0;
    char a;
    boolean checkFor;
    boolean B = true;

    int graph_vertices;
    boolean[] mark;
    boolean[][] matric_adj_bool = new boolean[intStateNumber][intStateNumber];
    

    public Algorithm() {

        System.out.print("How many state do you have? : ");
        intStateNumber = s.nextInt();

        strArrayInput = new String[intStateNumber + 1][intStateNumber + 1];

        for (int i = 0; i < strArrayInput.length; i++) {
            strArrayInput[i][0] = "" + i;
        }
        for (int i = 0; i < strArrayInput.length; i++) {
            strArrayInput[0][i] = "" + i;
        }
        for (int i = 1; i < strArrayInput.length; i++) {
            for (int j = 1; j < strArrayInput.length; j++) {
                System.out.println("["+(i-1)+", "+(j-1)+"]");
                strArrayInput[j][i] = s.next();
            }
        }
    }

    public void adjacent() {
        for (int i = 1; i < strArrayInput.length; i++) {
            System.out.print("State " + (i) + " :" + "  ");
            for (int j = 1; j < strArrayInput.length; j++) {
                if (!strArrayInput[j][i].equals("-")) {
                    System.out.print(strArrayInput[j][i] + "(" + j + ")" + "  ");
                }
            }

            System.out.println("");
        }
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");

    }

    public void MemberShip(String[][] strArray) {
        
        System.out.println("Enter Start State");
        startState = s.next();
        System.out.println("--------");
        int starts = Integer.parseInt(startState);
        System.out.print("Enter Number of final State : ");
        int finalNumber = s.nextInt();
        System.out.println("--------");
        System.out.println("Enter Final states");
        finalState = new String[finalNumber];
        for (int i = 0; i < finalNumber; i++) {
            finalState[i] = s.next();
            System.out.println("--------");
        }
        System.out.print("Enter your path : ");
        String path = s.next();
        System.out.println("--------");

        for (int i = 0; i < path.length(); i++) {
            a = path.charAt(i);
            checkFor = false;

            for (int j = 1; j < strArrayInput.length; j++) {
                if (!checkFor) {
                    if (strArrayInput[j][starts].charAt(0) == a) {
                        starts = j;
                        checkFor = true;
                    } else if (j == strArrayInput.length - 1) {
                        System.out.println("False");
                        B = false;
                    }
                }
            }

        }
        if (B) {
            String strStarts = starts + "";
            for (int j = 0; j < finalState.length; j++) {
                
                if (strStarts.equals(finalState[j])) {
                    System.out.println("True");

                } else if (j == (finalState.length - 1)) {
                    System.out.println("False");
                }
            }
        }
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
    }

//    public void deleteLoop() {
//        for (int i = 1; i < strArrayInput.length; i++) {
//            strArrayInput[i][i] = "-";
//        }
//        for (int i = 1; i < strArrayInput.length; i++) {
//            for (int j = 0; j < strArrayInput.length; j++) {
//                if (!strArrayInput[j][i].equals("-") && !strArrayInput[i][j].equals("-")) {
//                    strArrayInput[i][j] = "-";
//                }
//            }
//
//        }
//    }

    public void dfs(int p) {

        mark[p] = true;
        for (int i = 0; i < intStateNumber; i++) {
            if (!mark[i] && matric_adj_bool[p][i]) {
                dfs(i);
            }
        }
    }

    public int deleteLoops() {
        mark = new boolean[intStateNumber];
        matric_adj_bool = new boolean[intStateNumber][intStateNumber];
        int[][] check = new int[intStateNumber][intStateNumber];
        
        
        for (int i = 0; i < intStateNumber; i++) {
            for (int j = 0; j < intStateNumber; j++) {
                if(!strArrayInput[i+1][j+1].equals("-") && !strArrayInput[j+1][i+1].equals("-")){
                    matric_adj_bool[i][j] = true;
                }else
                    matric_adj_bool[i][j] = false;
            }
        }
        
        
        System.out.println("Graph edges that we have to delete is :");
        for (int v = 0; v < intStateNumber; v++) {
            for (int u = 0; u < intStateNumber; u++) {
                
                dfs(u);
                
                if (matric_adj_bool[v][u] && mark[v]) {
                    System.out.println("Edge between " + (v + 1) + " and  " + (u + 1));
                    strArrayInput[v+1][u+1] = "-";
                    matric_adj_bool[v][u] = false;
                }
                
                mark[u] = false;
            }
        }
        return 0;
    }
}

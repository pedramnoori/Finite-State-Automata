package fangh;

import java.io.File;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        
        
        String graphStr = "";
        
        Algorithm m = new Algorithm();
        
        int intUserInput = 0;
        Scanner s = new Scanner(System.in);
        
        do{
        
        System.out.println("1 : For print adjacent ");
        System.out.println("2 : For print Delete loop ");
        System.out.println("3 : For print test membership of a string ");
        System.out.println("4 : For print print graph ");
        System.out.println("0 : For Exit :) ");
  
        intUserInput = s.nextInt();
        
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        if(intUserInput == 1){
                    m.adjacent();
        }
        if(intUserInput == 2){
            m.deleteLoops();
        }
        if(intUserInput == 3){
         m.MemberShip(m.strArrayInput);   
        }
        if(intUserInput ==4){
            String strGraphViz = "digraph G {\n";
        for(int i=1 ; i<m.strArrayInput.length ; i++){
            for(int j=1 ; j<m.strArrayInput.length ; j++){
                if(!m.strArrayInput[j][i].equals("-")){
                strGraphViz = strGraphViz + Integer.toString(i) + " -> "
                        + Integer.toString(j) +" [ label=\"" + m.strArrayInput[j][i] + "\"" +
                        " ];\n";
                                  
               }
            }
        }
        strGraphViz = strGraphViz +"}";
        graphStr = strGraphViz ;

        GraphViz gv = new GraphViz();
        File out = new File("Graph_Picture.png");
        gv.writeGraphToFile( gv.getGraph(graphStr, "png", "dot"), out);
        }
        }while(intUserInput != 0);
        
    }
}
        

    




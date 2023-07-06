package org.SortSoccerPlayers;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

  protected static Scanner sc;

  static {
    try {
      sc = new Scanner(Paths.get("Spieler.txt"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[]args){
    List<Spieler> spielerList = new ArrayList<>();
    String Line =sc.nextLine();
    while(sc.hasNextLine()){
      String[] spielerHandler;
      spielerHandler = spaceFinder(Line).split(" ");
      int Counter = 0;
      Spieler iniHandle= new Spieler("","","",0,"","", 0,0,0);


      //Class Initialize
      iniHandle.setVorName(spielerHandler[Counter]);
      Counter++;
      iniHandle.setZuName(spielerHandler[Counter]);
      Counter++;
      if(spielerHandler[Counter].equals("Offensives") || spielerHandler[Counter].equals("Hängende")){
        iniHandle.setSpielposition(spielerHandler[Counter] + " " + spielerHandler[Counter+1]);
        Counter++;
      }
      else{
        iniHandle.setSpielposition(spielerHandler[Counter]);
      }
      Counter++;
      iniHandle.setAlter(Integer.parseInt(spielerHandler[Counter]));
      Counter++;
      if(spielerHandler[Counter+2].equals("SG")||spielerHandler[Counter+2].equals(("München"))){
        iniHandle.setSpielposition(spielerHandler[Counter] + " " + spielerHandler[Counter+1] + " " + spielerHandler[Counter+2]);
        Counter++;
        Counter++;
      }
      else {
        iniHandle.setVerein(spielerHandler[Counter] + " " + spielerHandler[Counter+1]);
        Counter++;
      }
      Counter++;
      if(spielerHandler[Counter].equals("LaLiga")||spielerHandler[Counter].equals("1.Bundesliga")){
        iniHandle.setLiga(spielerHandler[Counter]);
        iniHandle.setSp(Integer.parseInt(spielerHandler[Counter+1]));
        iniHandle.setTore(Integer.parseInt(spielerHandler[Counter+2]));
        iniHandle.setAlter(Integer.parseInt(spielerHandler[Counter+3]));
      } else if (spielerHandler[Counter].equals("Italien")) {
        iniHandle.setLiga(spielerHandler[Counter] + " " + spielerHandler[Counter+1] + " " + spielerHandler[Counter+2]);
        iniHandle.setSp(Integer.parseInt(spielerHandler[Counter+3]));
        iniHandle.setTore(Integer.parseInt(spielerHandler[Counter+4]));
        iniHandle.setAlter(Integer.parseInt(spielerHandler[Counter+5]));
      }
      else{
        iniHandle.setLiga(spielerHandler[Counter] + " " + spielerHandler[Counter+1]);
        iniHandle.setSp(Integer.parseInt(spielerHandler[Counter+2]));
        iniHandle.setTore(Integer.parseInt(spielerHandler[Counter+3]));
        iniHandle.setAlter(Integer.parseInt(spielerHandler[Counter+4]));
      }


      spielerList.add(iniHandle);
      Line =sc.nextLine();
    }
    sc.close();

    System.out.println("//WELCOME TO THE SORT PLAYER CONSOLE//");
    System.out.println("//THIS IS A SIMPLE MENU CONCERNING SORT OPTIONS FOR THE (Spieler.txt) PLAYER LIST//");
    System.out.println("//YOU HAVE THE FOLLOWING OPTIONS: ");
    System.out.println("//1: SORT ALL PLAYERS BY NAME (A,B,C,...)");
    System.out.println("//2: SORT ALL PLAYERS BY GOALS AND LAST NAME (A,B,C,...)");
    System.out.println("//3: SORT ALL PLAYERS BY THEIR GOALQUOTE (Z,Y,X,...)");
    System.out.println("//PLEASE NOTE THAT YOUR INPUT NEEDS TO BE ACCORDING TO THE NUMBER OF OPTION (1,2,3)!");
    System.out.print("YOUR INPUT:");

    Scanner in = new Scanner(System.in);
    boolean keepon=true;
    while (keepon){
      switch (Integer.parseInt(in.next())){
        case 1 :
          System.out.println("%%PROCEEDING%%");
          sortName(spielerList);
          break;
        case 2:
          System.out.println("%%PROCEEDING%%");
          sortGoals(spielerList);
          break;
        case 3:
          System.out.println("%%PROCEEDING%%");
          sortQuote(spielerList);
          break;
        default:
          System.out.println("&&YOUR INPUT DOESNT MATCH WITH THE OPTION NUMBERS!!!");
          break;
      }
    System.out.println("DO YOU WANT TO RETURN TO tHE MENU? (YES:1/NO:2)");
      switch (Integer.parseInt(in.next())){
        case 1 :
          System.out.println("%%PROCEEDING%%");
          break;
        case 2 :
          System.out.println("%%PROCEEDING%%");
          keepon=false;
          break;
        default:
          System.out.println("&&YOUR INPUT DOESNT MATCH WITH THE OPTION NUMBERS!!!");
          System.out.println("%%PROCEEDING%%");
          keepon=false;
          break;
      }
    }
  }

  private static void sortQuote(List<Spieler> spielerList) {
    //Normalerweise gehört das umgekehrt, müsste das so wie unten machen, keine Lust aber! + rundung funktioniert in java anders
    Comparator<Spieler> comparator=Comparator.comparing((Spieler::getTrefferQuote));
    Collections.sort(spielerList, comparator);
    for (Spieler sp: spielerList) {
      System.out.println(sp.VorName + " " + sp.ZuName + " - " +  Math.round(((double)sp.Tore/(double)sp.Sp)*100) + "%");
    }
  }

  private static void sortGoals(List<Spieler> spielerList) {
    spielerList.sort(new Comparator<Spieler>() {
      @Override
      public int compare(Spieler o1, Spieler o2) {
        int comparison = 0;
        int quote1, quote2;
        quote1=o1.Assist+ o1.Tore;
        quote2=o2.Assist+ o2.Tore;
        comparison=Integer.compare(quote2,quote1);
        if(comparison==0){
          o1.getZuName().compareTo(o2.getZuName());
        }
        return comparison;
      }
    });
    for (Spieler sp: spielerList) {
      System.out.println(sp.VorName + " " + sp.ZuName + " - " + (sp.Tore+sp.Assist));
    }
  }

  private static void sortName(List<Spieler> spielerList) {
    spielerList.sort(new Comparator<Spieler>() {
      @Override
      public int compare(Spieler o1, Spieler o2) {
        int comparison = 0;
        comparison=o1.getVorName().compareTo(o2.getVorName());
        if(comparison==0){
          o1.getZuName().compareTo(o2.getZuName());
        }
        return comparison;
      }
    });
    for (Spieler sp: spielerList) {
    System.out.println(sp.VorName + " " + sp.ZuName + " - " + sp.Verein + " - " + sp.Tore + " - " + sp.Assist + " - " + (sp.Tore+sp.Assist));
    }
  }

  private static String spaceFinder(String Line) {
    String Result = "";
    for (int i = 0; i<Line.length();i++) {
      if(Line.charAt(i)!=' ')
        Result=Result+Line.charAt(i);
      else if(Line.charAt(i+1)!=' ')
        Result=Result+" ";

    }
    return Result;
  }
}

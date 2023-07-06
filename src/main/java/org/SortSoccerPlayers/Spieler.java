package org.SortSoccerPlayers;
public class Spieler {

  //Class Properties ~
  protected String VorName;
  protected String ZuName;
  protected String Spielposition;
  protected int Alter;
  protected String Verein;
  protected String Liga;
  protected int Sp;
  protected int Tore;
  protected int Assist;

  //Class Constructor ~
  public Spieler(String vorname, String zuname, String spielposition, int alter, String verein, String liga, int sp, int tore, int assist) {
    VorName = vorname;
    ZuName = zuname;
    Spielposition = spielposition;
    Alter = alter;
    Verein = verein;
    Liga = liga;
    Sp = sp;
    Tore = tore;
    Assist = assist;
  }

  //Class Getter&Setter ~
  protected int getAssist() {
    return Assist;
  }
  protected int getTore() {
    return Tore;
  }
  protected int getSp() {
    return Sp;
  }
  protected String getLiga() {
    return Liga;
  }
  protected String getVerein() {
    return Verein;
  }
  protected int getAlter() {
    return Alter;
  }
  protected String getSpielposition() {
    return Spielposition;
  }
  protected String getVorName() {
    return VorName;
  }
  protected String getZuName() {
    return ZuName;
  }

  public void setVorName(String vorName) {
    VorName = vorName;
  }

  public void setZuName(String zuName) {
    ZuName = zuName;
  }

  public void setSpielposition(String spielposition) {
    Spielposition = spielposition;
  }

  public void setAlter(int alter) {
    Alter = alter;
  }

  public void setVerein(String verein) {
    Verein = verein;
  }

  public void setLiga(String liga) {
    Liga = liga;
  }

  public void setSp(int sp) {
    Sp = sp;
  }

  public void setTore(int tore) {
    Tore = tore;
  }

  public void setAssist(int assist) {
    Assist = assist;
  }

  //Trefferquote

  public double getTrefferQuote(){
      return 100*((double) getTore() /getSp());
  }

}
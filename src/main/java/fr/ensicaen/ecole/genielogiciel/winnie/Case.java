package fr.ensicaen.ecole.genielogiciel.winnie;

public class Case {
    private int _valeur;
    private int _update_mouvement;
    private int _update_competence;
    private int _end;
    public Case(int valeur, int competence, int mouvement, int end){
        _valeur= valeur;
        _update_mouvement= mouvement;
        _update_competence= competence;
        _end= end;
    }
    public void afficher(){
        if(_update_competence== 0){
            System.out.println("Je suis la case de deplacement "+ Integer.toString(_valeur) );
        } else if (_update_mouvement== 0) {
            System.out.println("Je suis la case de mouvement "+ Integer.toString(_valeur) );
        }
        else{
            System.out.println("Je suis la case de deplacement et de mouvement  "+ Integer.toString(_valeur) );
        }

    }

    public int get_update_competence() {
        return _update_competence;
    }

    public int get_update_mouvement() {
        return _update_mouvement;
    }
    public boolean get_end(){
        return _end == 0;
    }

}

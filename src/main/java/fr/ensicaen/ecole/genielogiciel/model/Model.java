package fr.ensicaen.ecole.genielogiciel.model;

public class Model {
    private String _nickname1;
    private String _nickname2;

    public String getNickname1() {
        return _nickname1;
    }
    public String getNickname2() {return _nickname2;}
    public void setNickname1( String nickname ) {
        _nickname1 = nickname;
    }
    public void setNickname2( String nickname ) {_nickname2 = nickname;}
}
package fr.ensicaen.ecole.genielogiciel.model;

public abstract class AbstractFactoryStudent {
    private Student _student;
    private int _skills;
    private Square _currentSquare;
    private static int _attribut;
    public  abstract Dilettante createDilettante();
    public abstract Diligent createDiligent();
    public abstract Brilliant createBrilliant();

    public abstract Student get_student();
}

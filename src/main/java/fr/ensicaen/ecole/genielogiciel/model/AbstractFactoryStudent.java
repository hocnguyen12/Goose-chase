package fr.ensicaen.ecole.genielogiciel.model;

public abstract class AbstractFactoryStudent {
    private Student _student;
    private boolean _skipNextRoundWEI = false;
    private boolean _InformaticsProblem = false;

    private boolean _BDE = false;
    private int _skillLevel = 0;
    private int _squareNumber = 0;

    public void move(int n){
        //If new position exceeds 63, the player goes back
        if (_squareNumber + n > 63) {
            _squareNumber = 63 - (_squareNumber + n - 63);
            return;
        }
        _squareNumber += n;
    }

    public boolean has_InformaticsProblem() {
        return _InformaticsProblem;
    }

    public boolean is_BDE() {
        return _BDE;
    }

    public void set_BDE(boolean _BDE) {
        this._BDE = _BDE;
    }

    public void set_InformaticsProblem(boolean _InformaticsProblem) {
        this._InformaticsProblem = _InformaticsProblem;
    }

    public int get_squareNumber() {
        return _squareNumber;
    }
    public void set_squareNumber(int _squareNumber) {
        this._squareNumber = _squareNumber;
    }
    public int get_skillLevel() {
        return _skillLevel;
    }
    public void increaseSkillLevel(int value) {
        this._skillLevel += value;
    }
    public void set_skipNextRoundWEI(boolean b) {
        _skipNextRoundWEI = b;
    }
    public boolean nextRoundSkipped() {
        return _skipNextRoundWEI;
    }
    public  abstract Dilettante createDilettante();
    public abstract Diligent createDiligent();
    public abstract Brilliant createBrilliant();

    public abstract Student get_student();
}

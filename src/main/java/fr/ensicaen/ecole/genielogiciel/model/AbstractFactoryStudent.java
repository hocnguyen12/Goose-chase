package fr.ensicaen.ecole.genielogiciel.model;

public abstract class AbstractFactoryStudent {
    private Student _student;
    private boolean _skipNextRound;
    private int _skillLevel = 0;
    private int _squareNumber = 0;

    public void move(int n){
        //If new position exceeds 63, the player goes backw²
        if (_squareNumber + n > 63) {
            _squareNumber = 63 - (_squareNumber + n - 63);
        }
        _squareNumber += n;
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
    public void set_skipNextRound(boolean b) {
        _skipNextRound = b;
    }
    public boolean nextRoundSkipped() {
        return _skipNextRound;
    }
    public  abstract Dilettante createDilettante();
    public abstract Diligent createDiligent();
    public abstract Brilliant createBrilliant();

    public abstract Student get_student();
}

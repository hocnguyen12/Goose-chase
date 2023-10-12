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
        } else if (_squareNumber + n < 0) {
            _squareNumber = 0;
        } else {
            _squareNumber += n;
        }

    }

    public boolean hasInformaticsProblem() {
        return _InformaticsProblem;
    }

    public boolean isBDE() {
        return _BDE;
    }

    public void setBDE(boolean _BDE) {
        this._BDE = _BDE;
    }

    public void setInformaticsProblem(boolean _InformaticsProblem) {
        this._InformaticsProblem = _InformaticsProblem;
    }

    public int getSquareNumber() {
        return _squareNumber;
    }
    public void setSquareNumber(int _squareNumber) {
        this._squareNumber = _squareNumber;
        if(_squareNumber < 0){
            this._squareNumber= 0;
        }
    }
    public int getSkillLevel() {
        return _skillLevel;
    }
    public void increaseSkillLevel(int value) {
        this._skillLevel += value;
        if(_skillLevel < 0){
            _skillLevel = 0;
        }
    }
    public void setSkipNextRoundWEI(boolean b) {
        _skipNextRoundWEI = b;
    }
    public boolean nextRoundSkipped() {
        return _skipNextRoundWEI;
    }
    public  abstract Dilettante createDilettante();
    public abstract Diligent createDiligent();
    public abstract Brilliant createBrilliant();

    public abstract Student getStudent();
}

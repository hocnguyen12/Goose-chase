package fr.ensicaen.ecole.genielogiciel.model;

public abstract class AbstractFactoryStudent {
    private Student _student;
    private String _name;
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
        if (_squareNumber + n < 0) {
            _squareNumber = 0;
            return;
        }
        _squareNumber += n;
    }

    public String getName() {
        return _name;
    }
    public void setName(String _name) {
        this._name = _name;
    }

    public boolean hasInformaticsProblem() {
        return _InformaticsProblem;
    }
    public void setInformaticsProblem(boolean _InformaticsProblem) {
        this._InformaticsProblem = _InformaticsProblem;
    }
    // SquareBDE
    public boolean isBDE() {
        return _BDE;
    }
    public void setBDE(boolean _BDE) {
        this._BDE = _BDE;
    }
    // Square number
    public int getSquareNumber() {
        return _squareNumber;
    }
    public void setSquareNumber(int squareNumber) {
        if (squareNumber < 0) {
            _squareNumber = 0;
            return;
        }
        _squareNumber = squareNumber;
    }
    // Skill Level
    public int getSkillLevel() {
        return _skillLevel;
    }
    public void increaseSkillLevel(int value) {
        if (_skillLevel + value < 0) {
            _skillLevel = 0;
            return;
        }
        _skillLevel += value;
    }
    // SquareWEI (skips next round)
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
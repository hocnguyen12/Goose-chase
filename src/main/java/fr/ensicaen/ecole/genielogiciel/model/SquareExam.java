package fr.ensicaen.ecole.genielogiciel.model;

public class SquareExam implements Square{
    private int _number;

    public SquareExam(int _number) {
        this._number = _number;
    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        //student s = s.get_student()
        int skillLevel = s.get_skillLevel();
        if (skillLevel < 8) {
            s.set_squareNumber(s.get_skillLevel() - (8 - skillLevel));
        }
    }

    @Override
    public String get_squareNameFR() {
        return "Examens";
    }

    @Override
    public String get_squareNameEN() {
        return "Exams";
    }
}

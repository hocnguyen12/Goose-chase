package fr.ensicaen.ecole.genielogiciel.model;
public class ConcreteFactoryDUT extends AbstractFactoryEtudiant{

    public static int _attribut = 0;
    private Etudiant _etudiant;
    public ConcreteFactoryDUT(){
        if(_attribut%3 == 0){
            _etudiant= createDiletante();
            _attribut++;
        }
        else if (_attribut % 3 == 1 ){
            _etudiant= createAssidu();
            _attribut++;
        }else{
            _etudiant= createBrillant();
            _attribut++;
        }
    }
    @Override
    public Diletante createDiletante() {
        return new Diletante();
    }

    @Override
    public Assidu createAssidu() {
        return new Assidu();
    }

    @Override
    public Brillant createBrillant() {
        return new Brillant();
    }
}

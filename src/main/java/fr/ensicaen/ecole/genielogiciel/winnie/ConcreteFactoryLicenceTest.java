package fr.ensicaen.ecole.genielogiciel.winnie;
import fr.ensicaen.ecole.genielogiciel.model.Assidu;
import fr.ensicaen.ecole.genielogiciel.model.Brillant;
import fr.ensicaen.ecole.genielogiciel.model.ConcreteFactoryLicence;
import fr.ensicaen.ecole.genielogiciel.model.Diletante;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteFactoryLicenceTest {
    ConcreteFactoryLicence licence1;
    ConcreteFactoryLicence licence2;
    ConcreteFactoryLicence licence3;
    ConcreteFactoryLicence licence4;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        licence1 =new ConcreteFactoryLicence();
        licence2 =new ConcreteFactoryLicence();
        licence3 =new ConcreteFactoryLicence();
        licence4 =new ConcreteFactoryLicence();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        licence1= null;
        licence2= null;
        licence3= null;
        licence4= null;
    }

    @org.junit.jupiter.api.Test
    void createDiletante() {
        assertTrue(licence1.get_etudiant() instanceof Diletante);
        //assertEquals(0,licence1.get_attribut());

        assertTrue(licence4.get_etudiant() instanceof Diletante);
        //assertEquals(3,licence4.get_attribut());
    }

    @org.junit.jupiter.api.Test
    void createAssidu() {
        assertTrue(licence2.get_etudiant() instanceof Assidu);
        //assertTrue(licence1.get_etudiant() instanceof Diletante);

    }

    @org.junit.jupiter.api.Test
    void createBrillant() {
        assertTrue(licence3.get_etudiant() instanceof Brillant);
    }
}
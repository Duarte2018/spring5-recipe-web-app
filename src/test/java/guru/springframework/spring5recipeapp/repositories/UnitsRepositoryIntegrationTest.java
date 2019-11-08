package guru.springframework.spring5recipeapp.repositories;

import guru.springframework.spring5recipeapp.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitsRepositoryIntegrationTest {

    @Autowired
    UnitsRepository unitsRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @DirtiesContext //hace reload de la db para no contaminar el segundo test
    public void findAllByUnit() {
        Optional<UnitOfMeasure> uomOptional = unitsRepository.findAllByUnit("Teaspoon");
        assertEquals("Teaspoon", uomOptional.get().getUnit());
    }

    @Test
    public void findAllByUnitCup() {
        Optional<UnitOfMeasure> uomOptional = unitsRepository.findAllByUnit("Cup");
        assertEquals("Cup", uomOptional.get().getUnit());
    }
}
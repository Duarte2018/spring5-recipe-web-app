package guru.springframework.spring5recipeapp.services;

import guru.springframework.spring5recipeapp.commands.UnitOfMeasureCommand;
import guru.springframework.spring5recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.spring5recipeapp.model.UnitOfMeasure;
import guru.springframework.spring5recipeapp.repositories.UnitsRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UnitsServiceImplTest {

    UnitOfMeasureToUnitOfMeasureCommand unitToUnitCommand;
    UnitsService unitsService;

    @Mock
    UnitsRepository unitsRepository;

    @Before
    public void setUp() throws Exception {
        unitToUnitCommand = new UnitOfMeasureToUnitOfMeasureCommand();
        MockitoAnnotations.initMocks(this);
        unitsService = new UnitsServiceImpl(unitsRepository, unitToUnitCommand);
    }

    @Test
    public void listAllUnits() {
        //given
        Set<UnitOfMeasure> unitsOfMeasure = new HashSet<>();
        UnitOfMeasure unit = new UnitOfMeasure();
        unit.setId(1L);
        unitsOfMeasure.add(unit);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId(2L);
        unitsOfMeasure.add(uom2);

        when(unitsRepository.findAll()).thenReturn(unitsOfMeasure);

        //when
        Set<UnitOfMeasureCommand> commands = unitsService.listAllUnits();
        //then
        assertEquals(2, commands.size());
        verify(unitsRepository, times(1)).findAll();
    }
}
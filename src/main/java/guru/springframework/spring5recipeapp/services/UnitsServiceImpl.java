package guru.springframework.spring5recipeapp.services;

import guru.springframework.spring5recipeapp.commands.UnitOfMeasureCommand;
import guru.springframework.spring5recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.spring5recipeapp.model.UnitOfMeasure;
import guru.springframework.spring5recipeapp.repositories.UnitsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class UnitsServiceImpl implements UnitsService {

    private final UnitsRepository unitsRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitToUnitCommand;

    public UnitsServiceImpl(UnitsRepository unitsRepository, UnitOfMeasureToUnitOfMeasureCommand unitToUnitCommand) {
        this.unitsRepository = unitsRepository;
        this.unitToUnitCommand = unitToUnitCommand;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUnits() {
        return StreamSupport.stream(unitsRepository.findAll()
                .spliterator(), false)
                .map(unitToUnitCommand::convert)
                .collect(Collectors.toSet());
    }
}

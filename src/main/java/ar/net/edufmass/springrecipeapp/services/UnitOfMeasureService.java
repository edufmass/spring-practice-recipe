package ar.net.edufmass.springrecipeapp.services;

import ar.net.edufmass.springrecipeapp.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}

package cz.vutbr.fit.pdb.projekt.api.commands.services.helpingservices;

import cz.vutbr.fit.pdb.projekt.features.helperInterfaces.PersistentObject;

public interface CommandDeleteService<T extends PersistentObject> extends CommandService<T> {

    T finishDeleting(T persistentObject);

}
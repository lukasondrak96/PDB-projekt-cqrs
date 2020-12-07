package cz.vutbr.fit.pdb.projekt.events.events.comment;

import cz.vutbr.fit.pdb.projekt.api.commands.services.helpingservices.DeleteCommandService;
import cz.vutbr.fit.pdb.projekt.api.commands.services.helpingservices.UpdateCommandService;
import cz.vutbr.fit.pdb.projekt.events.events.AbstractEvent;
import cz.vutbr.fit.pdb.projekt.features.helperInterfaces.ObjectInterface;
import cz.vutbr.fit.pdb.projekt.features.helperInterfaces.PersistentObject;

public class CommentDeletedEvent<T extends PersistentObject> extends AbstractEvent<T> {

    public CommentDeletedEvent(ObjectInterface objectInterface, UpdateCommandService<T> commandService) {
        super(objectInterface, commandService);
    }

    @Override
    public T apply(T persistentObject) {
        DeleteCommandService<T> commandService = (DeleteCommandService<T>) getCommandService();
        persistentObject = commandService.assignFromTo(getObjectInterface(), persistentObject);
        return commandService.finishDeleting(persistentObject);
    }

}

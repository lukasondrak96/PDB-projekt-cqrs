package cz.vutbr.fit.pdb.projekt.events.events.group;

import cz.vutbr.fit.pdb.projekt.api.commands.services.GroupCommandService;
import cz.vutbr.fit.pdb.projekt.events.events.EventInterface;
import cz.vutbr.fit.pdb.projekt.features.helperInterfaces.persistent.PersistentGroup;

public class GroupCreatedEvent implements EventInterface<PersistentGroup> {

    private final GroupCommandService service;

    public GroupCreatedEvent(GroupCommandService service) {
        this.service = service;
    }

    @Override
    public PersistentGroup apply(PersistentGroup persistentGroup) {
        return service.finishGroupSaving(persistentGroup);
    }

}

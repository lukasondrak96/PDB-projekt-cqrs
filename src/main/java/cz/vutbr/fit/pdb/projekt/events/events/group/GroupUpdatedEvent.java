package cz.vutbr.fit.pdb.projekt.events.events.group;

import cz.vutbr.fit.pdb.projekt.api.commands.services.GroupCommandService;
import cz.vutbr.fit.pdb.projekt.events.events.EventInterface;
import cz.vutbr.fit.pdb.projekt.features.helperInterfaces.persistent.PersistentGroup;

public class GroupUpdatedEvent implements EventInterface<PersistentGroup> {

    private final GroupCommandService service;

    public GroupUpdatedEvent(GroupCommandService service) {
        this.service = service;
    }

    @Override
    public PersistentGroup apply(PersistentGroup persistentGroup) {
        return service.updateGroup(persistentGroup);
    }

}

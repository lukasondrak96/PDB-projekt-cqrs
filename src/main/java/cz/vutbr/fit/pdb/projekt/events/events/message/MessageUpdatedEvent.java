package cz.vutbr.fit.pdb.projekt.events.events.message;

import cz.vutbr.fit.pdb.projekt.api.commands.services.MessageCommandService;
import cz.vutbr.fit.pdb.projekt.events.events.EventInterface;
import cz.vutbr.fit.pdb.projekt.features.helperInterfaces.persistent.PersistentMessage;

public class MessageUpdatedEvent implements EventInterface<PersistentMessage> {

    private final MessageCommandService service;

    public MessageUpdatedEvent(MessageCommandService service) {
        this.service = service;
    }

    @Override
    public PersistentMessage apply(PersistentMessage persistentMessage) {
        return service.updateMessage(persistentMessage);
    }

}

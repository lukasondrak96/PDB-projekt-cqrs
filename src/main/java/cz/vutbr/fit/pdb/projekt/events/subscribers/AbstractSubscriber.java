package cz.vutbr.fit.pdb.projekt.events.subscribers;

import cz.vutbr.fit.pdb.projekt.features.persistent.PersistentObject;
import org.greenrobot.eventbus.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractSubscriber<T extends PersistentObject> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractSubscriber.class);

    final List<EventBus> eventBuses = new LinkedList<>();
    protected T persistentObject;
    protected EventBus EVENT_BUS_MONGO;

    public AbstractSubscriber(EventBus... eventBuses) {
        EVENT_BUS_MONGO = new EventBus();
        LOGGER.info("Constructing a subscriber and registering {} event buses", eventBuses.length);
        for (EventBus eventBus : eventBuses) {
            register(eventBus);
        }
    }

    public void post(Object object) {
        for (EventBus eventBus : eventBuses) {
            LOGGER.info("Posting {} to event bus {}", object, eventBus);
            eventBus.post(object);
        }
    }

    public void register(EventBus eventBus) {
        LOGGER.info("Registering to event bus {}", eventBus);
        eventBus.register(this);
        eventBuses.add(eventBus);
    }

    public void unregister(EventBus eventBus) {
        LOGGER.info("Unregistering from event bus {}", eventBus);
        eventBus.unregister(this);
        eventBuses.remove(eventBus);
    }

}

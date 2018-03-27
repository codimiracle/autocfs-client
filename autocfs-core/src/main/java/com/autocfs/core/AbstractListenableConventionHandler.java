package com.autocfs.core;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Codimiracle on 2018/3/27.
 */

public abstract class AbstractListenableConventionHandler implements ListenableConventionHandler {

    private Vector<ListenableConventionHandler.ConventionHandlerListener> listeners;

    public AbstractListenableConventionHandler() {
        listeners = new Vector<ListenableConventionHandler.ConventionHandlerListener>();
    }

    @Override
    public void addConvensionHandlerListener(ConventionHandlerListener listener) {
        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    @Override
    public void removeConventionHandlerListener(ConventionHandlerListener listener) {
        listeners.remove(listener);
    }

    protected void publishMessage(MetadataDescriptor descriptor, float progress) {
        Iterator<ConventionHandlerListener> iterator = listeners.iterator();
        HandlerMessage message = new HandlerMessage(descriptor, progress);
        while (iterator.hasNext()) {
            ConventionHandlerListener listener = iterator.next();
            listener.onHandling(message);
        }
    }
}

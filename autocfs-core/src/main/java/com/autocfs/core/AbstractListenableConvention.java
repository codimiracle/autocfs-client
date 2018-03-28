package com.autocfs.core;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Codimiracle on 2018/3/27.
 */

public abstract class AbstractListenableConvention implements ListenableConvention {

    private Vector<ListenableConvention.ConventionHandlerListener> listeners;

    public AbstractListenableConvention() {
        listeners = new Vector<ListenableConvention.ConventionHandlerListener>();
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
    protected void publishStartedMessage(MetadataDescriptor descriptor) {
        HandlerMessage message = new HandlerMessage(descriptor);
        Iterator<ConventionHandlerListener> iterator = listeners.iterator();
        while (iterator.hasNext()) {
            ConventionHandlerListener listener = iterator.next();
            listener.onHandleBegin(message);
        }
    }
    protected void publishFinishedMessage(MetadataDescriptor descriptor, int resultCode) {
        ResultMessage message = new ResultMessage(descriptor, resultCode);
        Iterator<ConventionHandlerListener> iterator = listeners.iterator();
        while (iterator.hasNext()) {
            ConventionHandlerListener listener = iterator.next();
            listener.onHandleEnd(message);
        }
    }
    protected void publishMessage(MetadataDescriptor descriptor, float progress) {
        Iterator<ConventionHandlerListener> iterator = listeners.iterator();
        ProgressMessage message = new ProgressMessage(descriptor, progress);
        while (iterator.hasNext()) {
            ConventionHandlerListener listener = iterator.next();
            listener.onHandling(message);
        }
    }
}

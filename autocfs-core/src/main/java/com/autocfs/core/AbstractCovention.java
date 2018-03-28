package com.autocfs.core;

public abstract class AbstractCovention extends AbstractListenableConvention implements CommonConvention {
    private MetadataDescriptor descriptor;

    public AbstractCovention(MetadataDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    public MetadataDescriptor getDescriptor() {
        return descriptor;
    }

    private StateMachine state;

    protected void setState(StateMachine state) {
        this.state = state;
    }

    public StateMachine getState() {
        return state;
    }

    @Override
    public void start() throws UnsupportedOperationException {
        state.start();
    }

    @Override
    public void pause() throws UnsupportedOperationException {
        state.pause();
    }

    @Override
    public void resume() throws UnsupportedOperationException {
        state.resume();
    }

    @Override
    public void stop() throws UnsupportedOperationException {
        state.stop();
    }

    @Override
    public void restart() throws UnsupportedOperationException {
        state.restart();
    }

    @Override
    public boolean isStarted() {
        return state.isStarted();
    }

    @Override
    public boolean isPaused() {
        return state.isPaused();
    }

    @Override
    public boolean isStopped() {
        return state.isStopped();
    }

    @Override
    public boolean isFinished() {
        return state.isFinished();
    }
}

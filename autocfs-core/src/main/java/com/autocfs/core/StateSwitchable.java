package com.autocfs.core;

public interface StateSwitchable {
    public void start() throws UnsupportedOperationException;

    public void pause() throws UnsupportedOperationException;

    public void resume() throws UnsupportedOperationException;

    public void stop() throws UnsupportedOperationException;

    public void restart() throws UnsupportedOperationException;

    public boolean isStarted();

    public boolean isPaused();

    public boolean isStopped();

    public boolean isFinished();
}

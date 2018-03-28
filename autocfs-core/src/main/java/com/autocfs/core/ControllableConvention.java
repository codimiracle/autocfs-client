package com.autocfs.core;

public interface ControllableConvention extends StateSwitchable, Convention {
    public class StateMachine implements StateSwitchable {
        @Override
        public void start() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void pause() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void resume() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void stop() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void restart() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean isStarted() {
            return false;
        }

        @Override
        public boolean isPaused() {
            return false;
        }

        @Override
        public boolean isStopped() {
            return false;
        }

        @Override
        public boolean isFinished() {
            return false;
        }
    }

    public abstract class StartableStateMachine extends StateMachine {
        @Override
        public abstract void start() throws UnsupportedOperationException;
    }

    public abstract class PausableStateMachine extends StateMachine {
        @Override
        public abstract void pause() throws UnsupportedOperationException;

        @Override
        public abstract void stop() throws UnsupportedOperationException;

        @Override
        public boolean isStarted() {
            return true;
        }
    }

    public abstract class ResumableStateMachine extends StateMachine {
        @Override
        public abstract void resume() throws UnsupportedOperationException;

        @Override
        public boolean isPaused() {
            return true;
        }
    }

    public abstract class CompletetionStateMachine extends StateMachine {
        @Override
        public boolean isFinished() {
            return true;
        }
    }

}

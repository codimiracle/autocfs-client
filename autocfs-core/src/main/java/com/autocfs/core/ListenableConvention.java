package com.autocfs.core;

public interface ListenableConvention extends Convention {

    public class HandlerMessage {
        private MetadataDescriptor descriptor;

        public HandlerMessage(MetadataDescriptor descriptor) {
            this.descriptor = descriptor;
        }

        public MetadataDescriptor getDescriptor() {
            return descriptor;
        }
    }
    public class ProgressMessage extends HandlerMessage {
        private float progress;
        public ProgressMessage(MetadataDescriptor descriptor, float progress) {
            super(descriptor);
            this.progress = progress;
        }

        public float getProgress() {
            return progress;
        }
    }
    public class ResultsMessage extends HandlerMessage {
        private int resultCode;
        public ResultsMessage(MetadataDescriptor descriptor, int resultCode) {
            super(descriptor);
            this.resultCode = resultCode;
        }

        public int getResultCode() {
            return resultCode;
        }
    }
    public interface ConventionHandlerListener {
        //public boolean onMetadataDescriptorChecking(MetadataDescriptor descriptor);
        public void onHandling(ProgressMessage message);
        public void onHandleBegin(HandlerMessage message);
        public void onHandleEnd(ResultsMessage message);
    };
    public void addConvensionHandlerListener(ConventionHandlerListener listener);
    public void removeConventionHandlerListener(ConventionHandlerListener listener);
}

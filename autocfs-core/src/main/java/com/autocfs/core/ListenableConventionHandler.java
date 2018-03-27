package com.autocfs.core;

public interface ListenableConventionHandler extends ConventionHandler {
    public class HandlerMessage {
        private MetadataDescriptor descriptor;
        private float progress;

        public HandlerMessage(MetadataDescriptor descriptor, float progress) {
            this.descriptor = descriptor;
            this.progress = progress;
        }

        public MetadataDescriptor getDescriptor() {
            return descriptor;
        }

        public float getProgress() {
            return progress;
        }
    }
    public interface ConventionHandlerListener {
        //public boolean onMetadataDescriptorChecking(MetadataDescriptor descriptor);
        public void onHandling(HandlerMessage message);
    };
    public void addConvensionHandlerListener(ConventionHandlerListener listener);
    public void removeConventionHandlerListener(ConventionHandlerListener listener);
}

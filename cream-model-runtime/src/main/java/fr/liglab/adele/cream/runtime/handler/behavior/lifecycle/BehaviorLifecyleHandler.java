package fr.liglab.adele.cream.runtime.handler.behavior.lifecycle;

import fr.liglab.adele.cream.annotations.internal.HandlerReference;
import org.apache.felix.ipojo.ConfigurationException;
import org.apache.felix.ipojo.InstanceManager;
import org.apache.felix.ipojo.PrimitiveHandler;
import org.apache.felix.ipojo.annotations.Handler;
import org.apache.felix.ipojo.metadata.Element;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

@Handler(name = HandlerReference.BEHAVIOR_LIFECYCLE_HANDLER, namespace = HandlerReference.NAMESPACE)
public class BehaviorLifecyleHandler extends PrimitiveHandler {

    private final Object myLock = new Object();

    private final List<BehaviorStateListener> stateListeners = new ArrayList<>();

    @Override
    public void configure(Element metadata, Dictionary configuration) throws ConfigurationException {
        //Do nothing
    }

    @Override
    public synchronized void stop() {
        //Do nothing
    }

    @Override
    public synchronized void start() {
        setValidity(false);
    }

    public synchronized void registerBehaviorListener(BehaviorStateListener listener) {
        stateListeners.add(listener);
    }

    public synchronized void unregisterBehaviorListener(BehaviorStateListener listener) {
        stateListeners.remove(listener);
    }


    public void stopBehavior() {
        synchronized (myLock) {
            if (this.getValidity()) {
                setValidity(false);
            }
        }
    }

    public void startBehavior(){
        synchronized (myLock) {
            if (!this.getValidity()) {
                setValidity(true);
            }
        }
    }

    @Override
    public void stateChanged(int state) {
            notifyListener(state);
    }

    private void notifyListener(int state){
        for (BehaviorStateListener behaviorStateListener: stateListeners){
            behaviorStateListener.behaviorStateChange(state);
        }
    }
}

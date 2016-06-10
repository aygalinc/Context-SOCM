package fr.liglab.adele.cream.runtime.internal.factories;

import org.apache.felix.ipojo.ComponentFactory;
import org.apache.felix.ipojo.ConfigurationException;
import org.apache.felix.ipojo.HandlerManager;
import org.apache.felix.ipojo.InstanceManager;
import org.apache.felix.ipojo.metadata.Element;
import org.osgi.framework.BundleContext;

import java.util.Dictionary;

/**
 * Created by aygalinc on 31/05/16.
 */
public class ContextEntityManager extends InstanceManager{

    /**
     * Creates a new Component Manager.
     * The instance is not initialized.
     *
     * @param factory  the factory managing the instance manager
     * @param context  the bundle context to give to the instance
     * @param handlers handler object array
     */
    public ContextEntityManager(ComponentFactory factory, BundleContext context, HandlerManager[] handlers) {
        super(factory, context, handlers);

    }

    public void configure(Element metadata, Dictionary configuration) throws ConfigurationException {
        super.configure(metadata,configuration);
    }



}

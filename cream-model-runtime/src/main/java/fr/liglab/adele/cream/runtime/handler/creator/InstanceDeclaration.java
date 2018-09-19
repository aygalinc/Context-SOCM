package fr.liglab.adele.cream.runtime.handler.creator;

import org.apache.felix.ipojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Dictionary;

/**
 * This class gathers information about an instance that must be created
 */
public class InstanceDeclaration {

    private static final Logger LOG = LoggerFactory.getLogger(InstanceDeclaration.class);

    /**
     * The name of the instance
     */
    private final String name;

    /**
     * The configuration used to instantiate the component
     */
    private final Dictionary<String, Object> configuration;

    /**
     * The created instance
     */
    private ComponentInstance instance;

    /**
     * Creates a new instance declaration woth the given configuration
     */
    public InstanceDeclaration(String name, Dictionary<String, Object> configuration) {
        this.name = name;
        this.configuration = configuration;
    }

    /**
     * Get the instance name
     */
    public String getName() {
        return name;
    }

    /**
     * Whether this item has already been instantiated or it is pending
     */
    public boolean isInstantiated() {
        return instance != null && instance.getState() != ComponentInstance.DISPOSED;
    }

    /**
     * Tries to instantiate a pending instance
     */
    public void instantiate(Factory factory) {
        if (factory != null && !isInstantiated()) {
            try {
                instance = factory.createComponentInstance(configuration);
            } catch (UnacceptableConfiguration | MissingHandlerException | ConfigurationException ignored) {
                LOG.error("instantiation failed caused by:  ", ignored);

            }
        }
    }

    @SuppressWarnings("unchecked")
	protected <E> E getEntity() {
        return isInstantiated() ? (E) ((InstanceManager) this.instance).getPojoObject(): null;
    }


    /**
     * Destroys this item
     */
    public void dispose() {
        if (instance != null) {
            instance.dispose();
            instance = null;
        }
    }

}
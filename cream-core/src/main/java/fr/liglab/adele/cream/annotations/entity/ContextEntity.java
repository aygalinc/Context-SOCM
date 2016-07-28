package fr.liglab.adele.cream.annotations.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ContextEntity {

	/**
	 * The list of provided context services
	 */
    Class<?> [] services();

    /**
     * The name of the service property used to describe context provider factories
     */
    String ENTITY_CONTEXT_SERVICES = "factory.context.entity.services";

    /**
     * This annotations declares a relation of the context entity
     *
     */
    interface Relation {
    	
    	static String ID(Class<?> entity, String relation) {
    		return ID(entity.getSimpleName(),relation);
    	}

    	static String ID(String entity, String relation) {
    		return entity.toLowerCase()+"."+relation;
    	}
    	
        @Target(ElementType.FIELD)
        @interface Field {

        	Class<?> DEFAULT_OWNER = Object.class;
        	
			/**
			 * The class of the service virtually owning the relation
			 * 
			 */
		    Class<?> owner() default Object.class;
		    
		    /**
	    	 * The name of the relation
	    	 */
        	String value();
        }
    }
    
	/**
	 * This interface groups all the annotations helping entities to implement context state
	 * 
	 */
	interface State {
	
		 static String ID(Class<?> service, String state) {
			return ID(service.getSimpleName(),state);
		}
	
		 static String ID(String service, String state) {
			return service.toLowerCase()+"."+state;
		}
	
		@Target(ElementType.FIELD)
		@Retention(RetentionPolicy.RUNTIME)
		@interface Field {
			
			String NO_VALUE = "";
	
			/**
			 * The class of the service defining the state to be implemented
			 * 
			 */
		    Class<?> service();
	
		    /**
		     * The name of the state to be implemented
		     */
		    String state();
		    
		    /**
		     * The default value of the state
		     */
		    String value() default NO_VALUE;
		    
		    /**
		     * Whether the service provider can modify the state using the injected field
		     */
		    boolean directAccess() default false;
		    
		}
		
		@Target(ElementType.FIELD)
		@interface Apply {
	
			/**
			 * The class of the service defining the state to be implemented
			 * 
			 */
		    Class<?> service();
	
		    /**
		     * The name of the state to be implemented
		     */
		    String state();
		}
		
		@Target(ElementType.FIELD)
		@interface Pull {
	
			/**
			 * The class of the service defining the state to be implemented
			 * 
			 */
		    Class<?> service();
	
		    /**
		     * The name of the state to be implemented
		     */
		    String state();
	
		    /**
		     * Sets the period of time.
		     */
		    long period() default -1L;
	
		    /**
		     * Sets the time unit to use for the period.
		     */
		    TimeUnit unit() default TimeUnit.SECONDS;
	
		}
		
		@Target(ElementType.METHOD)
		@interface Push {
	
			/**
			 * The class of the service defining the state to be implemented
			 * 
			 */
		    Class<?> service();
	
		    /**
		     * The name of the state to be implemented
		     */
		    String state();
	
		}	
	
	}
    
}

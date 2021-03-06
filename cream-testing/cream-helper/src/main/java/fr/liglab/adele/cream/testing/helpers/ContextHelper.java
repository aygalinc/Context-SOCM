package fr.liglab.adele.cream.testing.helpers;

import org.ow2.chameleon.testing.helpers.IPOJOHelper;
import org.ow2.chameleon.testing.helpers.OSGiHelper;

/**
 * Created by aygalinc on 25/07/16.
 */
public class ContextHelper {



    private final ContextEntityHelper contextEntityHelper;

    private final FunctionalExtensionHelper functionalExtensionHelper;

    public ContextHelper(OSGiHelper osGiHelper, IPOJOHelper ipojoHelper) {
        functionalExtensionHelper = new FunctionalExtensionHelper(ipojoHelper);
        contextEntityHelper = new ContextEntityHelper(osGiHelper);
    }

    public ContextEntityHelper getContextEntityHelper() {
        return contextEntityHelper;
    }

    public FunctionalExtensionHelper getFunctionalExtensionHelper() {
        return functionalExtensionHelper;
    }


}

package fr.liglab.adele.cream.annotations.internal;

/**
 * Created by aygalinc on 01/06/16.
 */
public enum FunctionalExtensionReference {

    FUNCTIONAL_EXTENSION_INDIVIDUAL_ELEMENT_NAME("functional.extension"),

    SPECIFICATION_ATTRIBUTE_NAME("functional.extension.spec"),

    IMPLEMEMENTATION_ATTRIBUTE_NAME("implementation"),

    FIELD_ATTRIBUTE_NAME("field"),

    ID_ATTRIBUTE_NAME("id"),

    FUNCTIONAL_EXTENSION_MANDATORY_ATTRIBUTE_NAME("mandatory"),

    FUNCTIONAL_EXTENSION_ID_CONFIG("functional.extension.id"),

    FUNCTIONAL_EXTENSION_RECONFIGURATION("functional.extension.reconfiguration"),

    FUNCTIONAL_EXTENSION_ALTERNATIVE_CONFIGURATION("alternative.configurations"),

    FUNCTIONAL_EXTENSION_IS_INSTANTIATE("is.instantiate"),

    FUNCTIONAL_EXTENSION_MANAGED_SPECS_CONFIG("managed.specification");

    /**
     * Constante used in filter
     */
    public final static String FUNCTIONAL_EXTENSION_FACTORY_TYPE_PROPERTY = "functional.extension.factory.property";

    public final static String FUNCTIONAL_EXTENSION_FACTORY_TYPE_PROPERTY_VALUE = "functional.extension.factory";

    private final String property;

    FunctionalExtensionReference(String property) {
        this.property = property;
    }


    @Override
    public String toString() {
        return property;
    }
}

package com.athul.common.toggles;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum MyToggles implements Feature {

    @Label("TEST TOGGLE 1")
    TEST_LABEL_1,

    @Label("TEST TOGGLE 2")
    TEST_LABEL_2;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}

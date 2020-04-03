package com.athul.common.toggles;

import lombok.Synchronized;
import org.togglz.core.Feature;
import org.togglz.core.annotation.ActivationParameter;
import org.togglz.core.annotation.DefaultActivationStrategy;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.user.FeatureUser;
import org.togglz.core.user.SimpleFeatureUser;

import java.util.Objects;

public enum MyToggles implements Feature {

    @Label("TEST TOGGLE 1")
    @EnabledByDefault
    @DefaultActivationStrategy(id = CustomStrategy.ID,
            parameters = {
                    @ActivationParameter(name = CustomStrategy.PARAM, value = "test_criteria.txt")
            })
    TEST_LABEL_1,

    @Label("TEST TOGGLE 2")
    @EnabledByDefault
    TEST_LABEL_2;

    public boolean isActive() {
        FeatureManager manager = FeatureContext.getFeatureManagerOrNull();
        return Objects.nonNull(manager) && manager.isActive(this);
    }

    @Synchronized
    public boolean isActiveForCriteria(String criteria) {

        FeatureManager manager = FeatureContext.getFeatureManagerOrNull();

        if (Objects.isNull(manager)) {
            return false;
        }

        FeatureUser user = manager.getCurrentFeatureUser();

        if (user instanceof SimpleFeatureUser) {
            ((SimpleFeatureUser) user).setAttribute(CustomStrategy.ATTRIBUTE, criteria);
        }
        return manager.isActive(this);
    }


}

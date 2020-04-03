package com.athul.common.toggles;

import com.athul.common.StrategyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.togglz.core.activation.Parameter;
import org.togglz.core.activation.ParameterBuilder;
import org.togglz.core.repository.FeatureState;
import org.togglz.core.spi.ActivationStrategy;
import org.togglz.core.user.FeatureUser;

import java.util.Objects;

@Component
public class CustomStrategy implements ActivationStrategy {

    public static final String ID = "customActivationStrategy";
    public static final String NAME = "Custom Activation Strategy";
    public static final String PARAM = "criteriaFile";
    public static final String ATTRIBUTE = "criteria";

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public boolean isActive(FeatureState featureState, FeatureUser featureUser) {

        if (Objects.nonNull(featureUser) && Objects.nonNull(featureUser.getAttribute(ATTRIBUTE))) {
            String criteria = StringUtils.defaultString(featureUser.getAttribute(ATTRIBUTE).toString(), "NA");
            String criteriaFileName = featureState.getParameter(PARAM);
            return StrategyUtils.isCriteriaEnabled(criteriaFileName, criteria);

        }
        return false;
    }

    @Override
    public Parameter[] getParameters() {
        return new Parameter[]
                {
                        ParameterBuilder.create("criteriaFile")
                                .label("Criteria File Name")
                                .description("Name of the file that contains the custom strategy criteria")
                };
    }
}

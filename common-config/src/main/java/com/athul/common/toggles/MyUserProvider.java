package com.athul.common.toggles;

import org.springframework.stereotype.Component;
import org.togglz.core.user.FeatureUser;
import org.togglz.core.user.SimpleFeatureUser;
import org.togglz.core.user.UserProvider;

import java.util.Objects;

@Component
public class MyUserProvider implements UserProvider {

    private FeatureUser user;

    @Override
    public FeatureUser getCurrentUser() {

        if (Objects.isNull(this.user)) {
            this.user = new SimpleFeatureUser("admin", true);
        }

        return this.user;
    }
}

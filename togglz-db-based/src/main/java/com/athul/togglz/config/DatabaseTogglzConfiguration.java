package com.athul.togglz.config;

import com.athul.common.toggles.MyToggles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;
import org.togglz.core.repository.jdbc.JDBCStateRepository;
import org.togglz.core.user.NoOpUserProvider;

import javax.sql.DataSource;

@Component
@Slf4j
public class DatabaseTogglzConfiguration {

    @Autowired
    private DataSource dataSource;


    @Bean
    public FeatureManager dbFeatureManager() {
        FeatureManager featureManager = new FeatureManagerBuilder()
                .stateRepository(new JDBCStateRepository(dataSource))
                .featureEnum(MyToggles.class)
                .userProvider(new NoOpUserProvider())
                .build();
        return featureManager;
    }
}

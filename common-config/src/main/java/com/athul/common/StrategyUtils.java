package com.athul.common;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

@Slf4j
@UtilityClass
public class StrategyUtils {

    private static Map<String, List<String>> criteriaLists;

    static {
        init();
    }

    static void init() {

        criteriaLists = Maps.mutable.empty();
        processCriteriaFiles();
    }

    public boolean isCriteriaEnabled(String file, String criteria) {
        return criteriaLists.getOrDefault(file, Lists.mutable.empty()).contains(criteria);
    }

    private void processCriteriaFiles() {
        try {

            MutableList<File> files = Lists.adapt((List<File>) FileUtils.listFiles
                    (ResourceUtils.getFile("classpath:criteria/"), new String[]{"txt"}, true));

            files.forEach(file -> loadFiles(file));

        } catch (FileNotFoundException e) {
            log.error("Unable to iterate thru resources to put entry in the map", e);

        }
    }

    private void loadFiles(File file) {
        try {
            criteriaLists.put(file.getName(), Lists.adapt(FileUtils.readLines(file, Charset.defaultCharset())));
        } catch (IOException e) {
            log.error("Unable to add entry to map for file: {}", file.getName(), e);
        }
    }

}

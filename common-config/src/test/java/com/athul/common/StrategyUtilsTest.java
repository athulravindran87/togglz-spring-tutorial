package com.athul.common;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StrategyUtilsTest {

    @Test
    public void isCriteriaEnabled() {
        assertTrue(StrategyUtils.isCriteriaEnabled("test_criteria.txt", "1234"));
        assertTrue(StrategyUtils.isCriteriaEnabled("test_criteria.txt", "4567"));
        assertFalse(StrategyUtils.isCriteriaEnabled("test_criteria.txt", "7890"));

        assertTrue(StrategyUtils.isCriteriaEnabled("test_criteria_2.txt", "ABCD"));
        assertTrue(StrategyUtils.isCriteriaEnabled("test_criteria_2.txt", "EFGH"));
        assertFalse(StrategyUtils.isCriteriaEnabled("test_criteria_2.txt", "7890"));

    }
}
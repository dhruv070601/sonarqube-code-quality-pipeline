package com.dhruv.demo;
public class QualityService {
    public boolean isReleaseEligible(int testFailures, double coveragePercent) {
        return testFailures == 0 && coveragePercent >= 80.0;
    }
    public String classifyBuild(boolean releaseEligible) {
        return releaseEligible ? "PASS" : "BLOCK";
    }
}
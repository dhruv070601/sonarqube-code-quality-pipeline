package com.dhruv.demo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class QualityServiceTest {
    private final QualityService service = new QualityService();
    @Test void eligibleBuildPasses() { assertTrue(service.isReleaseEligible(0, 85.0)); assertEquals("PASS", service.classifyBuild(true)); }
    @Test void failedTestsBlockRelease() { assertFalse(service.isReleaseEligible(1, 95.0)); assertEquals("BLOCK", service.classifyBuild(false)); }
    @Test void lowCoverageBlocksRelease() { assertFalse(service.isReleaseEligible(0, 70.0)); }
}
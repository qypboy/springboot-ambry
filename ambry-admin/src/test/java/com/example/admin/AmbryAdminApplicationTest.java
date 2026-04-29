package com.example.admin;

import com.example.business.system.region.service.RegionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = AmbryAdminApplication.class)
class AmbryAdminApplicationTest {

    @Autowired
    RegionService regionService;

    @Test
    void contextLoadsBusinessModules() {
        assertThat(regionService.tree("0")).isNotEmpty();
    }
}

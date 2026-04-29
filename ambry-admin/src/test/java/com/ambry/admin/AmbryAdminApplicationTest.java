package com.ambry.admin;

import com.ambry.business.manager.RegionManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = AmbryAdminApplication.class)
class AmbryAdminApplicationTest {

    @Autowired
    RegionManager regionManager;

    @Test
    void contextLoadsBusinessModules() {
        assertThat(regionManager).isNotNull();
    }
}

package by.ibragimov.natrus;

import by.ibragimov.natrus.config.logging.LoggingInitializer;
import by.ibragimov.natrus.utils.Profiles;
import by.ibragimov.natrus.domain.config.DaoConfig;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles(Profiles.TEST)
@ContextConfiguration(classes = { DaoConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class SpringTestBase {

    @BeforeClass
    public static void init() {
        new LoggingInitializer().contextInitialized(null);
    }
}

package by.ibragimov.heap;

import by.ibragimov.heap.domain.DaoConfig;
import by.ibragimov.heap.security.LoggingInitializer;
import by.ibragimov.heap.utils.annotations.profiles.Profiles;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles(Profiles.TEST)
@ContextConfiguration(classes = DaoConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class RepositoryBaseTest {
    static {
        new LoggingInitializer().contextInitialized(null);
    }
}

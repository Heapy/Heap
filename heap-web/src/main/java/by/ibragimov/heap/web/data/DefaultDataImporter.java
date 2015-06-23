package by.ibragimov.heap.web.data;

import by.ibragimov.heap.domain.common.HeapUser;
import by.ibragimov.heap.domain.common.HeapUserRepository;
import by.ibragimov.heap.utils.annotations.profiles.DevelopmentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * TODO: CommentMe!
 *
 * @author Ibragimov Ruslan
 */
@Service
@DevelopmentProfile
public class DefaultDataImporter implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private HeapUserRepository heapUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (heapUserRepository.findAll().size() > 0) {
            return;
        }

        HeapUser heapUser = new HeapUser();
        heapUser.setEmail("r.ibragimov@itx.by");
        heapUser.setSecret(UUID.randomUUID().toString());
        heapUser.setPassword(passwordEncoder.encode("dilbert"));
        heapUserRepository.save(heapUser);
    }
}

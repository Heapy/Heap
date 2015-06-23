package by.ibragimov.heap.security;

import by.ibragimov.heap.domain.common.HeapUser;
import by.ibragimov.heap.domain.common.HeapUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private HeapUserRepository heapUserRepository;

    @Override
    public HeapUserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(email)) {
            throw new UsernameNotFoundException("No email passed.");
        }

        HeapUser user = this.heapUserRepository.getByEmail(email);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(String.format("User with email=%s was not found", email));
        } else {
            return new HeapUserDetails(user);
        }
    }
}

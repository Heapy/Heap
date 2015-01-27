package by.ibragimov.natrus.dao.converters.assemblers;

import by.ibragimov.natrus.dao.entities.Users;
import by.ibragimov.natrus.domain.dtos.users.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler extends BaseAssembler<Users, UserDto> {

    @Override
    public Users assembleNullSafe(UserDto dto) {
        return new Users()
                .setId(dto.getId());
    }
}

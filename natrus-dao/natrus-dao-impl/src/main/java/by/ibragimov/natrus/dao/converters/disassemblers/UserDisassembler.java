package by.ibragimov.natrus.dao.converters.disassemblers;

import by.ibragimov.natrus.dao.entities.Users;
import by.ibragimov.natrus.domain.dtos.users.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserDisassembler extends BaseDisassembler<Users, UserDto> {

    @Override
    public UserDto disassembleNullSafe(Users entity, Boolean isRecursive) {
        return UserDto
                .newBuilder()
                .id(entity.getId())
                .build();
    }
}

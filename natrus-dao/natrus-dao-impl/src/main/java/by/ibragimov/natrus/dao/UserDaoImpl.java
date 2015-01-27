package by.ibragimov.natrus.dao;

import by.ibragimov.natrus.dao.entities.Users;
import by.ibragimov.natrus.dao.repositories.CommonRepository;
import by.ibragimov.natrus.domain.dtos.users.UserDto;

public class UserDaoImpl extends CommonDaoImpl<UserDto, CommonRepository<Users>, Users> implements UserDao {
}

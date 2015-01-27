package by.ibragimov.natrus.dao;

import by.ibragimov.natrus.dao.entities.Tag;
import by.ibragimov.natrus.dao.repositories.CommonRepository;
import by.ibragimov.natrus.domain.dtos.bookmars.TagDto;

public class TagDaoImpl extends CommonDaoImpl<TagDto, CommonRepository<Tag>, Tag> implements TagDao {
}

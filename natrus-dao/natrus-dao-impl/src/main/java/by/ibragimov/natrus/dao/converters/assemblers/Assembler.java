package by.ibragimov.natrus.dao.converters.assemblers;

import by.ibragimov.natrus.dao.entities.BaseEntity;
import by.ibragimov.natrus.domain.dtos.BaseDto;

import java.util.Set;

public interface Assembler<E extends BaseEntity, DTO extends BaseDto> {

    E assemble(DTO dto);

    E assembleNullSafe(DTO dto);

    Set<E> assemble(Set<DTO> dtos);
}

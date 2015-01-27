package by.ibragimov.natrus.dao.converters.assemblers;

import by.ibragimov.natrus.dao.entities.BaseEntity;
import by.ibragimov.natrus.domain.dtos.BaseDto;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BaseAssembler<E extends BaseEntity, DTO extends BaseDto> implements Assembler<E, DTO> {

    @Override
    public Set<E> assemble(Set<DTO> dtos) {
        return dtos == null ? null : dtos
                .parallelStream()
                .filter(Objects::nonNull)
                .map(this::assemble)
                .collect(Collectors.toSet());
    }

    @Override
    public E assemble(DTO dto) {
        return dto == null ? null : assembleNullSafe(dto);
    }
}

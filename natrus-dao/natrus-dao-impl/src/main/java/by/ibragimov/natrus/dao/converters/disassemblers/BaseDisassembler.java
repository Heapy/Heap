package by.ibragimov.natrus.dao.converters.disassemblers;

import by.ibragimov.natrus.dao.converters.utils.ConvertersUtils;
import by.ibragimov.natrus.dao.entities.BaseEntity;
import by.ibragimov.natrus.domain.dtos.BaseDto;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BaseDisassembler<E extends BaseEntity, DTO extends BaseDto> implements Disassembler<E, DTO> {

    public abstract DTO disassembleNullSafe(E entity, Boolean isRecursive);

    @Override
    public DTO disassemble(E entity) {
        return entity == null ? null : disassembleNullSafe(entity, ConvertersUtils.RECURSIVE);
    }

    @Override
    public DTO liteDisassemble(E entity) {
        return entity == null ? null : disassembleNullSafe(entity, ConvertersUtils.NON_RECURSIVE);
    }

    @Override
    public Set<DTO> disassemble(Collection<E> entities) {
        return disassemble(entities, ConvertersUtils.RECURSIVE);
    }

    @Override
    public Set<DTO> liteDisassemble(Collection<E> entities) {
        return disassemble(entities, ConvertersUtils.NON_RECURSIVE);
    }

    private Set<DTO> disassemble(Collection<E> entities, Boolean isRecursive) {
        if (isRecursive) {
            return entities
                    .parallelStream()
                    .filter(Objects::nonNull)
                    .map(this::disassemble)
                    .collect(Collectors.toSet());
        } else {
            return entities
                    .parallelStream()
                    .filter(Objects::nonNull)
                    .map(this::liteDisassemble)
                    .collect(Collectors.toSet());
        }
    }
}

package by.ibragimov.natrus.dao.converters.disassemblers;

import by.ibragimov.natrus.dao.entities.BaseEntity;
import by.ibragimov.natrus.domain.dtos.BaseDto;

import java.util.Collection;
import java.util.Set;

public interface Disassembler<E extends BaseEntity, DTO extends BaseDto> {

    DTO disassemble(E entity);

    DTO liteDisassemble(E entity);

    Set<DTO> disassemble(Collection<E> entities);

    Set<DTO> liteDisassemble(Collection<E> entities);
}

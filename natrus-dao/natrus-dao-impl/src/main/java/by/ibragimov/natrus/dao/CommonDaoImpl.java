package by.ibragimov.natrus.dao;

import by.ibragimov.natrus.dao.converters.assemblers.BaseAssembler;
import by.ibragimov.natrus.dao.converters.disassemblers.BaseDisassembler;
import by.ibragimov.natrus.dao.entities.BaseEntity;
import by.ibragimov.natrus.dao.repositories.CommonRepository;
import by.ibragimov.natrus.domain.dtos.BaseDto;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Set;

/**
 * Common implementation of CommonDao.
 */
@Transactional
public abstract class CommonDaoImpl<DTO extends BaseDto, R extends CommonRepository<ENTITY>, ENTITY extends BaseEntity>
        implements CommonDao<DTO> {

    @Autowired
    private R repository;

    @Autowired
    private BaseAssembler<ENTITY, DTO> baseAssembler;

    @Autowired
    private BaseDisassembler<ENTITY, DTO> baseDisassembler;

    @Override
    public Set<DTO> findAll() {
        return baseDisassembler.disassemble(repository.findAll());
    }

    @Override
    public DTO save(DTO dto) {
        return baseDisassembler.disassemble(repository.save(baseAssembler.assemble(dto)));
    }

    @Override
    public DTO get(Long id) {
        return baseDisassembler.disassemble(repository.findOne(id));
    }

    @Override
    public void remove(Long id) {
        repository.delete(id);
    }
}

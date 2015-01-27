package by.ibragimov.natrus.dao;

import java.util.Set;

/**
 * CRUD and Custom Query methods common for all entities.
 */
public interface CommonDao<DTO> {

    Set<DTO> findAll();

    DTO save(DTO dto);

    DTO get(Long id);

    void remove(Long id);
}

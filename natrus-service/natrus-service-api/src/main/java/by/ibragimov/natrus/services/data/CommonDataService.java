package by.ibragimov.natrus.services.data;

import java.util.Set;

public interface CommonDataService<DTO> {

    Set<DTO> findAll();

    DTO save(DTO dto);

    DTO get(Long id);

    void remove(Long id);
}

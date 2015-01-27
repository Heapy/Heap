package by.ibragimov.natrus.services.data;

import by.ibragimov.natrus.domain.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CommonDataServiceImpl<DTO> implements CommonDataService<DTO> {

    @Autowired
    private CommonDao<DTO> commonDao;

    @Override
    public Set<DTO> findAll() {
        return commonDao.findAll();
    }

    @Override
    public DTO save(DTO dto) {
        return commonDao.save(dto);
    }

    @Override
    public DTO get(Long id) {
        return commonDao.get(id);
    }

    @Override
    public void remove(Long id) {
        commonDao.remove(id);
    }
}

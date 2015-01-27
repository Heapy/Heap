package by.ibragimov.natrus.controllers;

import by.ibragimov.natrus.domain.dtos.BaseDto;
import by.ibragimov.natrus.services.data.CommonDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

public abstract class BaseRestController<DTO extends BaseDto> {

    protected abstract String getName();

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseRestController.class);

    @Autowired
    private CommonDataService<DTO> service;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public Set<DTO> list() {
        LOGGER.trace("{} list requested.", getName());
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DTO get(@PathVariable("id") Long id) {
        LOGGER.trace("{} with id={} requested.", getName(), id);
        return service.get(id);
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public DTO create(DTO dto) {
        LOGGER.trace("Request for {} creating received. Dto: {}", getName(), dto);
        return service.save(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public DTO create(@PathVariable("id") Long id, DTO dto) {
        LOGGER.trace("Request for {} creating received. Dto: {}", getName(), dto);
        return service.save(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") Long id) {
        LOGGER.trace("Deleting {} with id={} requested.", getName(), id);
        service.remove(id);
    }

}

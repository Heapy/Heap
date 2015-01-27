package by.ibragimov.natrus.controllers;

import by.ibragimov.natrus.domain.dtos.bookmars.TagDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagsController extends BaseRestController<TagDto> {

    @Override
    protected String getName() {
        return "Tag";
    }
}

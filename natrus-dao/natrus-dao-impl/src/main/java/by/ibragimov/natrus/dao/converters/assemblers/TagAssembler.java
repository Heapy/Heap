package by.ibragimov.natrus.dao.converters.assemblers;

import by.ibragimov.natrus.dao.entities.Tag;
import by.ibragimov.natrus.domain.dtos.bookmars.TagDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagAssembler extends BaseAssembler<Tag, TagDto> {

    @Autowired
    private BookmarkAssembler bookmarkAssembler;

    @Override
    public Tag assembleNullSafe(TagDto dto) {
        return new Tag()
                .setName(dto.getName())
                .setBookmarks(bookmarkAssembler.assemble(dto.getBookmarks()));
    }
}

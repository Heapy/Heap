package by.ibragimov.natrus.dao.converters.assemblers;

import by.ibragimov.natrus.dao.entities.Bookmark;
import by.ibragimov.natrus.domain.dtos.bookmars.BookmarkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookmarkAssembler extends BaseAssembler<Bookmark, BookmarkDto> {

    @Autowired
    private TagAssembler tagAssembler;

    @Override
    public Bookmark assembleNullSafe(BookmarkDto dto) {
        return new Bookmark()
                .setId(dto.getId())
                .setUrl(dto.getUrl())
                .setTitle(dto.getTitle())
                .setTags(tagAssembler.assemble(dto.getTags()))
                .setNote(dto.getNote());
    }
}

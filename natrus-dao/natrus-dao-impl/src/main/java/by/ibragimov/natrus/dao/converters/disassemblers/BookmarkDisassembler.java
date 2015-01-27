package by.ibragimov.natrus.dao.converters.disassemblers;

import by.ibragimov.natrus.dao.entities.Bookmark;
import by.ibragimov.natrus.domain.dtos.bookmars.BookmarkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static by.ibragimov.natrus.domain.dtos.bookmars.BookmarkDto.Builder;

@Component
public class BookmarkDisassembler extends BaseDisassembler<Bookmark, BookmarkDto> {

    @Autowired
    private TagDisassembler tagDisassembler;

    @Override
    public BookmarkDto disassembleNullSafe(Bookmark entity, Boolean isRecursive) {
        Builder builder = BookmarkDto.newBuilder()
                .id(entity.getId())
                .note(entity.getNote())
                .title(entity.getTitle())
                .url(entity.getUrl());
        if (isRecursive) {
            builder.tags(tagDisassembler.liteDisassemble(entity.getTags()));
        }
        return builder.build();
    }
}

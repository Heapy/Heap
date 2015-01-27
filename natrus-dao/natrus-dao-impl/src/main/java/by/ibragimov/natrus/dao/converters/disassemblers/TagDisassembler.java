package by.ibragimov.natrus.dao.converters.disassemblers;

import by.ibragimov.natrus.dao.entities.Tag;
import by.ibragimov.natrus.domain.dtos.bookmars.TagDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static by.ibragimov.natrus.domain.dtos.bookmars.TagDto.Builder;

@Component
public class TagDisassembler extends BaseDisassembler<Tag, TagDto> {

    @Autowired
    private BookmarkDisassembler bookmarkDisassembler;

    @Override
    public TagDto disassembleNullSafe(Tag entity, Boolean isRecursive) {
        Builder builder = TagDto
                .newBuilder()
                .name(entity.getName());
        if (isRecursive) {
            builder.bookmarks(bookmarkDisassembler.liteDisassemble(entity.getBookmarks()));
        }
        return builder.build();
    }
}

package by.ibragimov.natrus.controllers;

import by.ibragimov.natrus.domain.dtos.bookmars.BookmarkDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookmarks")
public class BookmarksController extends BaseRestController<BookmarkDto> {

    @Override
    protected String getName() {
        return "Bookmark";
    }
}

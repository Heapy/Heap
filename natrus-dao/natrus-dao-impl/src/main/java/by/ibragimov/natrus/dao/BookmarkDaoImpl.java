package by.ibragimov.natrus.dao;

import by.ibragimov.natrus.dao.entities.Bookmark;
import by.ibragimov.natrus.dao.repositories.bookmark.BookmarkRepository;
import by.ibragimov.natrus.domain.dtos.bookmars.BookmarkDto;
import org.springframework.stereotype.Component;

@Component
public class BookmarkDaoImpl extends CommonDaoImpl<BookmarkDto, BookmarkRepository, Bookmark> implements BookmarkDao {
}

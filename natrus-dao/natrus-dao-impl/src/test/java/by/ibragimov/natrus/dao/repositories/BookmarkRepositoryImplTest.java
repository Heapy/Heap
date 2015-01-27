package by.ibragimov.natrus.dao.repositories;

import by.ibragimov.natrus.SpringTestBase;
import by.ibragimov.natrus.dao.BookmarkDao;
import by.ibragimov.natrus.domain.dtos.bookmars.BookmarkDto;
import by.ibragimov.natrus.domain.dtos.bookmars.TagDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class BookmarkRepositoryImplTest extends SpringTestBase {

    @Autowired
    private BookmarkDao bookmarkDao;

    @Test
    public void testCRD() throws Exception {
        Long id = bookmarkDao.save(
                BookmarkDto
                        .newBuilder()
                        .note("Note here.")
                        .title("Title")
                        .url("http://ibragimov.by/")
                        .tag(TagDto.newBuilder().name("Tag1").build())
                        .build()).getId();
        assertNotNull(bookmarkDao.get(id));
        bookmarkDao.remove(id);
        assertNull(bookmarkDao.get(id));
    }
}

package by.ibragimov.heap.domain.rkeep.interim;

import by.ibragimov.heap.domain.common.BaseEntity;
import by.ibragimov.heap.domain.common.HeapUser;

import javax.persistence.Entity;
import java.sql.Timestamp;

@Entity
public class ReceiptImage extends BaseEntity<ReceiptImage> {

    private String image;

    private HeapUser heapUser;

    private Boolean isDone;

    private Timestamp startTime;

    public String getImage() {
        return image;
    }

    public ReceiptImage setImage(String image) {
        this.image = image;
        return this;
    }

    public HeapUser getHeapUser() {
        return heapUser;
    }

    public ReceiptImage setHeapUser(HeapUser heapUser) {
        this.heapUser = heapUser;
        return this;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public ReceiptImage setIsDone(Boolean isDone) {
        this.isDone = isDone;
        return this;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public ReceiptImage setStartTime(Timestamp startTime) {
        this.startTime = startTime;
        return this;
    }
}

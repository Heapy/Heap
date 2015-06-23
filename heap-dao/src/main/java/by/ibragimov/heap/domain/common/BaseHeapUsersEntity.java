package by.ibragimov.heap.domain.common;

import by.ibragimov.heap.utils.Warnings;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * This class must extend all entities, that belongs to client.
 *
 * @author Ibragimov Ruslan
 */
@MappedSuperclass
public abstract class BaseHeapUsersEntity<T extends BaseEntity> extends BaseEntity<T>  {

    private HeapUser heapUser;

    @ManyToOne
    public HeapUser getHeapUser() {
        return heapUser;
    }

    @SuppressWarnings(Warnings.UNCHECKED)
    public T setHeapUser(HeapUser heapUser) {
        this.heapUser = heapUser;
        return (T) this;
    }

}

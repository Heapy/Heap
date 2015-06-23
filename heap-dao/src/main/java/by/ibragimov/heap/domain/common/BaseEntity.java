package by.ibragimov.heap.domain.common;

import by.ibragimov.heap.utils.Warnings;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

/**
 * Base entity class contains identifier of entity and generation strategy.
 *
 * @author Ibragimov Ruslan
 */
@MappedSuperclass
@OptimisticLocking(type = OptimisticLockType.VERSION)
@Access(AccessType.FIELD)
public abstract class BaseEntity<T extends BaseEntity> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Version
    private Long version;

    public Long getId() {
        return this.id;
    }

    @SuppressWarnings(Warnings.UNCHECKED)
    public T setId(Long id) {
        this.id = id;
        return (T) this;
    }


    public Long getVersion() {
        return this.version;
    }

    public BaseEntity setVersion(Long version) {
        this.version = version;
        return this;
    }
}

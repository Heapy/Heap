package by.ibragimov.natrus.domain.common;

import by.ibragimov.natrus.utils.Warnings;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity<T extends BaseEntity> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    public Long getId() {
        return this.id;
    }

    @SuppressWarnings(Warnings.UNCHECKED)
    public T setId(Long id) {
        this.id = id;
        return (T) this;
    }
}

package by.ibragimov.natrus.domain.markers;

/**
 * A common interface for all entities.
 */
public interface Identified<T> {

    /**
     * Returns the identifier of the entity.
     *
     * @return identifier of entity.
     */
    T getId();
}

package by.ibragimov.natrus.domain.markers;

/**
 * A common interface for all typed entities.
 */
public interface Typed<T extends Enum> {

    /**
     * Returns type of entity.
     *
     * @return type of entity.
     */
    T getType();
}

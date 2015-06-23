package by.ibragimov.heap.utils.annotations.profiles;

import org.springframework.context.annotation.Profile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to mark development-only beans.
 *
 * @author Ibragimov Ruslan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Profile(Profiles.DEVELOPMENT)
public @interface DevelopmentProfile {
}

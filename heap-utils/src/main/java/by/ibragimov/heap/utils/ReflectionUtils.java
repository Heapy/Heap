package by.ibragimov.heap.utils;

public final class ReflectionUtils {

    private ReflectionUtils() {
    }

    public static boolean isImplementsInterface(Class interfaze, Class clazz) {
        for (Class c : clazz.getInterfaces()) {
            if (c.equals(interfaze)) {
                return true;
            }
        }
        return false;
    }

}

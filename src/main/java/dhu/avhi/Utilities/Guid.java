package dhu.avhi.Utilities;

import java.util.UUID;

public class Guid {

    private UUID value;
    private static String empty = "00000000-0000-0000-0000-000000000000";

    public Guid() {
        value = UUID.randomUUID();
    }

    public Guid(String str) {
        value = UUID.fromString(str);
    }

    public Guid(UUID id) {
        value = id;
    }

    public static Guid newGuid() {
        return new Guid();
    }

    public String toString() {
        return value.toString();
    }

    public static Guid empty() {
        return new Guid(empty);
    }
}

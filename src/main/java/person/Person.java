package person;

import person.appearance.Appearance;

public class Person {

    private final String id;
    private final String fullName;
    private final Physical phys;
    private final Appearance appearance;
    private final Phone phone;

    public Person(final String id,
                  final String fullName,
                  final Physical phys,
                  final Appearance appearance,
                  final Phone phone) {
        this.id = id;
        this.fullName = fullName;
        this.phys = phys;
        this.appearance = appearance;
        this.phone = phone;
    }


    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder()
                .append(id).append("\n")
                .append(String.format("%1$s", fullName)).append("\n")
                .append(phys).append("\n")
                .append(appearance).append("\n");
        if (phone != null) {
            sb.append(phone);
        } else {
            sb.append("Телефона нет");
        }
        return sb.toString();
    }
}
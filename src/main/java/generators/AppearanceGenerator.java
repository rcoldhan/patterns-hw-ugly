package generators;

import person.appearance.Appearance;
import person.appearance.hair.Hair;

import java.util.HashMap;

public class AppearanceGenerator implements Generator<Appearance> {

    private String eyes;
    private int hairLength;
    private String hairColor;

    /**
     * Внешность генерируется по третьей цифре кода (i):
     * Глаза: по индексу i/2 (=0..4)
     * Длина волос: i
     * Цвет волос: из enum по индексу i-1 при i>0 (=0..8).
     */
    @Override
    public final void generateParams(final int code) {
        final int i = code % 100 / 10;

        final HashMap<Integer, String> eyesColorMap = new HashMap<>() {{
            put(0, "голубые");
            put(1, "зелёные");
            put(2, "карие");
            put(3, "серые");
            put(4, "разные");
        }};
        eyes = eyesColorMap.get(i / 2);
        hairLength = i;

        final HashMap<Integer, String> hairColorMap = new HashMap<>() {{
            put(1, "чёрные");
            put(2, "каштановые");
            put(3, "рыжие");
            put(4, "светлые");
            put(5, "седые");
            put(6, "розовые");
            put(7, "зелёные");
            put(8, "фиолетовые");
            put(9, "синие");
        }};
        if (i > 0) {
            hairColor = hairColorMap.get(i);
        }
    }

    @Override
    public final Appearance buildResponse() {
        Hair hair;
        if (hairLength > 0) {
            if (hairLength > 4) {
                hair = new Hair("длинные, ", hairColor);
            } else {
                hair = new Hair("короткие, ", hairColor);
            }
        } else {
            hair = new Hair("нет", "");
        }
        return new Appearance(eyes, hair);
    }
}
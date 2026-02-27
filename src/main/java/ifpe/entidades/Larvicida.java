package ifpe.entidades;

import java.text.Normalizer;

public enum Larvicida {
    BTI, OLEO_ESSENCIAL, VAZIO;

    public static Larvicida toLarvicida(String texto) {
        if (texto == null) return VAZIO;

        String semAcento = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");

        String formatada = semAcento.toUpperCase().replace(" ", "_");

        for (Larvicida l : Larvicida.values()) {
            if (l.name().equals(formatada)) {
                return l;
            }
        }
        return VAZIO;
    }
}

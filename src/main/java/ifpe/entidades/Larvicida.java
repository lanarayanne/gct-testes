package ifpe.entidades;

public enum Larvicida {
    BTI, OLEO_ESSENCIAL, VAZIO;

    public static Larvicida toLarvicida(String texto) {
        for (Larvicida l : Larvicida.values()) {
            if (l.name().equalsIgnoreCase(texto.replace(" ", "_"))) return l;
        }
        return VAZIO;
    }
}

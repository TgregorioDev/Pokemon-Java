package pokemon;

public enum Tipo {
    FOGO, AGUA, GRAMA, NORMAL, ELETRICO;

    // Método para calcular vantagens/desvantagens
    public double multiplicadorEfetividade(Tipo tipoAlvo) {
        if (this == FOGO) {
            if (tipoAlvo == GRAMA) return 2.0;  // Fogo > Grama
            if (tipoAlvo == AGUA) return 0.5;   // Fogo < Água
            if (tipoAlvo == ELETRICO) return 1.0;
        }
        if (this == AGUA) {
            if (tipoAlvo == FOGO) return 2.0;  // Água > Fogo
            if (tipoAlvo == GRAMA) return 0.5;  // Água < Grama
            if (tipoAlvo == ELETRICO) return 0.0;
        }
        if (this == GRAMA) {
            if (tipoAlvo == AGUA) return 2.0;   // Grama > Água
            if (tipoAlvo == FOGO) return 0.5;   // Grama < Fogo
            if (tipoAlvo == ELETRICO) return 1.0;
        }
        if (this == ELETRICO)
        if (tipoAlvo == AGUA) return 2.0; //eletrico > agua
        if (tipoAlvo == FOGO) return 1.0;
        if (tipoAlvo == GRAMA) return 0.5;


        return 1.0; // Neutralidade (NORMAL ou outros casos)
    }

    // Método auxiliar para converter String em Tipo (opcional)
    public static Tipo fromString(String tipoStr) {
        try {
            return Tipo.valueOf(tipoStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            return NORMAL; // Tipo padrão se não reconhecer
        }
    }
}
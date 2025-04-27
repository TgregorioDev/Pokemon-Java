package pokemon;

public class Ataque {   //classe ataque, movimentos do pokemon
    private String nome;
    private Tipo tipo;
    private int poder;
    private int precisao;  //0 a 100 (%)

    public Ataque(String nome, Tipo tipo, int poder, int precisao) { //construtor
        this.nome = nome;
        this.tipo = tipo;
        this.poder = poder;
        this.precisao = precisao;
    }

    //Getters
    public String getNome() { return nome; }
    public int getPoder() { return poder; }
    public int getPrecisao() { return precisao; }
    public Tipo getTipo() { return tipo; }
    
}

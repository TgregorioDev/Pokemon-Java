package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private String nome; //variáveis encapsulada
    private Tipo tipo;
    private int nivel;
    private int hp;
    private int ataque;
    private int defesa;
    private int velocidade;
    private List<Ataque> ataques; //cria lista de ataques
    private int xp;
    private int xpParaProxNivel;

    //construtor, em sua estrutura recebe os parâmetros de um pokemon
    public Pokemon(String nome, Tipo tipo, int nivel, int hp, int ataque, int defesa, int velocidade) {
        this.nome = nome;     //cada this. atribui um valor a cada atributo
        this.tipo = tipo;
        this.nivel = nivel;
        this.hp = hp;
        this.ataque = ataque;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.ataques = new ArrayList<>();
        this.xp = 0;
        this.xpParaProxNivel = 100; // Exemplo fixo (poderia ser por curva de nível)

    }
    public Pokemon(Pokemon outro) {
        this(outro.getNome(), outro.getTipo(), outro.getNivel(), outro.getHp(),
             outro.getAtaque(), outro.getDefesa(), outro.getVelocidade());
        this.ataques.addAll(outro.getAtaques());
    }

    //métodos
    public void adicionarAtaque(Ataque ataque) {
        if (ataques.size() < 4){ //limita em 4 ataques por pokemon
            ataques.add(ataque);
        } else {
            System.out.println("Limite de ataques atingido!");
        }
    }

    public void receberDano(int dano) {
        this.hp -= dano;
        if (this.hp < 0) this.hp = 0;
        System.out.println(this.nome + " recebeu " + dano + " de dano! HP restante: " + this.hp);
    }

    public boolean estaVivo() {
        return this.hp > 0;
    }

    public void ganharXp(int xpGanho) { //método
        this.xp += xpGanho;
        System.out.println(this.nome + " ganhou " + xpGanho + " XP!");
        if (this.xp >= this.xpParaProxNivel){
            subirNivel();
        }
    }

    // No arquivo Pokemon.java
    public Tipo getTipo() {
        return this.tipo; // Certifique-se que existe este método
    }

    private void subirNivel() { //construtor
        this.nivel++;
        this.xp -= this.xpParaProxNivel;
        this.xpParaProxNivel = (int) (this.xpParaProxNivel * 1.2); //aumenta para o próximo nível
        //melhora stats
        this.hp += 5;
        this.ataque += 2;
        this.defesa += 2;
        System.err.println(this.nome + " subiu para o nivel " + this.nivel + "!");
    }

    // Getters para acessar os atributos
    public String getNome() { return nome; }
    public int getAtaque() { return ataque; }
    public int getDefesa() { return defesa; }
    public int getVelocidade() { return velocidade; }
    public List<Ataque> getAtaques() { return ataques; }
    public int getHp() { return hp; }
    public int getNivel() { return nivel; }

}
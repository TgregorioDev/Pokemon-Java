package pokemon;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Batalha {
    private Pokemon pokemonJogador;
    private Pokemon pokemonInimigo;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    public Batalha(Pokemon pokemonJogador, Pokemon pokemonInimigo) {
        this.pokemonJogador = pokemonJogador;
        this.pokemonInimigo = pokemonInimigo;
    }

    public void iniciar() {
        System.out.println("\n === BATALHA POKÉMON ===");
        System.out.println(pokemonJogador.getNome() + " (Lv " + pokemonJogador.getNivel() + ") vs " + 
                          pokemonInimigo.getNome() + " (Lv " + pokemonInimigo.getNivel() + ")\n");

        while (pokemonJogador.estaVivo() && pokemonInimigo.estaVivo()) {
            // Turno do jogador
            if (pokemonJogador.estaVivo()) {
                System.out.println("\n--- SEU TURNO ---");
                System.out.println("HP: " + pokemonJogador.getHp() + " | Inimigo HP: " + pokemonInimigo.getHp());
                Ataque ataqueJogador = escolherAtaque(pokemonJogador);
                calcularDano(pokemonJogador, pokemonInimigo, ataqueJogador);
            }

            // Turno do inimigo (se ainda estiver vivo)
            if (pokemonInimigo.estaVivo()) {
                System.out.println("\n--- TURNO DO INIMIGO ---");
                Ataque ataqueInimigo = escolherAtaqueInimigo();
                calcularDano(pokemonInimigo, pokemonJogador, ataqueInimigo);
            }
        }

        verificarVencedor();
    }

    private Ataque escolherAtaque(Pokemon pokemon) {
        List<Ataque> ataques = pokemon.getAtaques();
        System.out.println("Escolha seu ataque:");
        
        for (int i = 0; i < ataques.size(); i++) {
            System.out.println((i + 1) + ". " + ataques.get(i).getNome() + 
                              " (" + ataques.get(i).getTipo() + ")");
        }

        int escolha = scanner.nextInt() - 1;
        return ataques.get(escolha);
    }

    private Ataque escolherAtaqueInimigo() {
        List<Ataque> ataques = pokemonInimigo.getAtaques();
        return ataques.get(random.nextInt(ataques.size()));
    }

    private void calcularDano(Pokemon atacante, Pokemon defensor, Ataque ataque) {
        // Cálculo completo do dano
        
        double multiplicador = ataque.getTipo().multiplicadorEfetividade(defensor.getTipo());
        int dano = (int) (((ataque.getPoder() * atacante.getAtaque()) / defensor.getDefesa()) * multiplicador);

        System.out.println(atacante.getNome() + " usou " + ataque.getNome() + "!");
        if (multiplicador > 1.0) {
            System.out.println("Foi super efetivo!");
        } else if (multiplicador < 1.0) {
            System.out.println("Foi pouco efetivo...");
        }

        defensor.receberDano(dano);
    }

    private void verificarVencedor() {
        if (pokemonJogador.estaVivo()) {
            System.out.println("\n " + pokemonJogador.getNome() + " venceu a batalha! ");
            pokemonJogador.ganharXp(30); // XP por vitória
        } else {
            System.out.println("\n " + pokemonInimigo.getNome() + " venceu... ");
        }
    }
}
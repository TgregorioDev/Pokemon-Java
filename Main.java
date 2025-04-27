package pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Cria lista de Pokemons 
        List<Pokemon> todosPokemons = new ArrayList<>();
        todosPokemons.add(new Pokemon("Charmander", Tipo.FOGO, 5, 50, 12, 8, 10));
        todosPokemons.add(new Pokemon("Squirtle", Tipo.AGUA, 5, 55, 10, 10, 8));
        todosPokemons.add(new Pokemon("Bulbasaur", Tipo.GRAMA, 5, 60, 8, 12, 7)); 
        todosPokemons.add(new Pokemon("Pikachu", Tipo.ELETRICO, 5, 45, 15, 7, 12)); 

        adicionarAtaques(todosPokemons);

        //Menu de seleção
        System.out.println("===== SELECIONE SEU POKEMON =====");
        Pokemon pokemonJogador = selecionarPokemon(todosPokemons, "Jogador");
        System.out.println("\n ===== SELECIONE O POKEMON INIMIGO =====");
        Pokemon pokemonInimigo = selecionarPokemon(todosPokemons, "Inimigo");

        //Iniciar batalha
        new Batalha(pokemonJogador, pokemonInimigo).iniciar();
    }

        //Adicionar ataques
        private static void adicionarAtaques(List<Pokemon> pokemons){
            for (Pokemon p : pokemons) {
                switch (p.getNome()) {
                    case "Charmander":
                    p.adicionarAtaque(new Ataque("Brasa", Tipo.FOGO, 20, 90));
                    p.adicionarAtaque(new Ataque("Arranhão", Tipo.NORMAL, 10, 100));
                        break;

                    case "Squirtle":
                    p.adicionarAtaque(new Ataque("Jato de Água", Tipo.AGUA, 25, 85));
                    p.adicionarAtaque(new Ataque("Mordida", Tipo.NORMAL, 15, 95));
                        break;
                    
                    case "Bulbasaur":
                    p.adicionarAtaque(new Ataque("Investida", Tipo.NORMAL, 35, 95));
                    p.adicionarAtaque(new Ataque("Chicote de vinha", Tipo.GRAMA, 35, 100));
                        break;
                    
                    case "Pikachu":
                    p.adicionarAtaque(new Ataque("Choque do Trovão",Tipo.ELETRICO, 40, 100));
                    p.adicionarAtaque(new Ataque("Rosnado", Tipo.NORMAL, 0, 100));
                        break;
                }
            }
        
        }

        //Método para selecionar Pokémon
        private static Pokemon selecionarPokemon(List<Pokemon> pokemons, String dono) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\n Opções para " + dono + ":");
            for (int i = 0; i < pokemons.size(); i++) {
                Pokemon p = pokemons.get(i);
                System.out.printf("%d. %s (Tipo: %s | HP: %d | Ataque: %d)\n", i+1, p.getNome(), p.getTipo(), p.getHp(), p.getAtaque());
            }

            System.out.print("Escolha um Pokemon (1-" + pokemons.size() + "): ");
            int escolha = scanner.nextInt() - 1;

            //retorna uma cópia para não afetar a lista original
            return new Pokemon(pokemons.get(escolha));
        }


    }


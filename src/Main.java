import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CatalogoDisco catalogo = new CatalogoDisco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bem-vindo ao Catálogo de Discos e Artistas!");
            System.out.println("Escolha uma das opções abaixo para começar:");
            System.out.println("1. Cadastrar novo disco");
            System.out.println("2. Cadastrar novo artista");
            System.out.println("3. Listar discos");
            System.out.println("4. Editar disco");
            System.out.println("5. Remover disco");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título do disco: "); String titulo = scanner.nextLine();
                    System.out.print("Ano de lançamento: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do artista: ");
                    String artistaNome = scanner.nextLine();
                    System.out.print("Gênero musical do artista: ");
                    String generoNome = scanner.nextLine();
                    Genero genero = new Genero(generoNome);
                    Artista artista = new Artista(artistaNome, genero);
                    Disco disco = new Disco(titulo, ano, artista);
                    List<Faixa> faixas = new ArrayList<>();
                    System.out.print("Quantas faixas tem o disco? ");
                    int numFaixas = scanner.nextInt();
                    scanner.nextLine(); for (int i = 0; i < numFaixas; i++) {
                        System.out.print("Título da faixa " + (i + 1) + ": ");
                        String tituloFaixa = scanner.nextLine();
                        System.out.print("Duração da faixa " + (i + 1) + " (em segundos): ");
                        int duracaoFaixa = scanner.nextInt(); scanner.nextLine();
                        faixas.add(new Faixa(tituloFaixa, duracaoFaixa));
                    }
                    disco.setFaixas(faixas); catalogo.adicionarDisco(disco);
                    System.out.println("Disco adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Nome do artista: ");
                    artistaNome = scanner.nextLine();
                    System.out.print("Gênero musical do artista: ");
                    generoNome = scanner.nextLine();
                    genero = new Genero(generoNome);
                    artista = new Artista(artistaNome, genero);
                    System.out.print("Título do disco ao qual associar: ");
                    titulo = scanner.nextLine();
                    disco = catalogo.getDiscoPorTitulo(titulo);
                    if (disco != null) {
                        disco.setArtista(artista);
                        System.out.println("Artista associado com sucesso!");
                    } else {
                        System.out.println("Disco não encontrado!");
                    }
                    break;
                case 3:
                    List<Disco> discos = catalogo.listarDiscos();
                    for (Disco d : discos) { System.out.println("Título: " + d.getTitulo());
                        System.out.println("Artista: " + d.getArtista().getNome());
                        System.out.println("Ano: " + d.getAno());
                        System.out.println("Faixas: ");
                        for (Faixa t : d.getFaixas()) {
                            System.out.println(" - " + t.getTitulo() + " (" + t.getDuracao() + "s)");
                        }
                    }
                    break;
                case 4:
                    System.out.print("Título do disco a ser editado: ");
                    titulo = scanner.nextLine();
                    disco = catalogo.getDiscoPorTitulo(titulo);
                    if (disco != null) {
                        System.out.print("Novo título: ");
                        disco.setTitulo(scanner.nextLine());
                        System.out.print("Novo ano de lançamento: ");
                        disco.setAno(scanner.nextInt());
                        scanner.nextLine();
                        System.out.println("Disco editado com sucesso!");
                    } else {
                        System.out.println("Disco não encontrado!");
                    }
                    break;
                case 5:
                    System.out.print("Título do disco a ser removido: ");
                    titulo = scanner.nextLine();
                    disco = catalogo.getDiscoPorTitulo(titulo);
                    if (disco != null) {
                        catalogo.removerDisco(disco);
                        System.out.println("Disco removido com sucesso!");
                    } else {
                        System.out.println("Disco não encontrado!");
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

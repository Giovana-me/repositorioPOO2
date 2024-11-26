import java.util.ArrayList;
import java.util.List;

public class Disco {
    private String titulo;
    private int ano;
    private List<Faixa> faixas;
    private Artista artista;

    public Disco(String titulo, int ano, Artista artista) {
        this.titulo = titulo;
        this.ano = ano;
        this.faixas = new ArrayList<>();
        this.artista = artista;
    }

    public void adicionarFaixa(Faixa faixa) {
        faixas.add(faixa);
    }

    // Getters and setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<Faixa> getFaixas() {
        return faixas;
    }

    public void setFaixas(List<Faixa> faixas) {
        this.faixas = faixas;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}

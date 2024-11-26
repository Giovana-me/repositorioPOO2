import java.util.ArrayList;
import java.util.List;

public class CatalogoDisco implements ICatalogo {
    private List<Disco> discos;

    public CatalogoDisco() {
        this.discos = new ArrayList<>();
    }

    protected List<Disco> getDiscos() {
        return discos;
    }

    @Override
    public void adicionarDisco(Disco disco) {
        discos.add(disco);
    }

    @Override
    public void removerDisco(Disco disco) {
        discos.remove(disco);
    }

    @Override
    public List<Disco> listarDiscos() {
        return discos;
    }
    public Disco getDiscoPorTitulo(String titulo) {
        for (Disco disco : getDiscos()) {
            if (disco.getTitulo().equalsIgnoreCase(titulo)) {
                return disco;
            }
        }
        return null;
    }
}




import java.util.List;

public interface ICatalogo {
    void adicionarDisco(Disco disco);
    void removerDisco(Disco disco);
    List<Disco> listarDiscos();
}

package state;

public abstract class LivroEstado {

    public abstract String getEstado();

    public boolean emprestar(Livro livro) {
        return false;
    }

    public boolean devolver(Livro livro) {
        return false;
    }

    public boolean reservar(Livro livro) {

        return false;
    }

    public boolean disponivel(Livro livro) {
        return false;
    }

    public boolean renovarEmprestimo(Livro livro) {

        return false;
    }

}

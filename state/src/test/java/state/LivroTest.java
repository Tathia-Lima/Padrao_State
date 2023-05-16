package state;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LivroTest {

    Livro livro;

    @BeforeEach
    public void setUp() {
        livro = new Livro();
    }

    // Livro Disponível
    @Test
    public void testLivroEstadoInicial() {
        assertFalse(livro.disponivel());
        assertEquals("Disponível", livro.getNomeEstado());
    }

    // Emprestar Disponível
    @Test
    public void testEmprestarLivroDisponivel() {
        livro.setEstado(LivroEstadoDisponivel.getInstance());
        assertTrue(livro.emprestar());
        assertEquals(LivroEstadoEmprestado.getInstance(), livro.getEstado());
    }

    // Reservar Disponível
    @Test
    public void testReservarLivroDisponivel() {
        livro.setEstado(LivroEstadoDisponivel.getInstance());
        assertTrue(livro.reservar());
        assertEquals(LivroEstadoReservado.getInstance(), livro.getEstado());
    }

    // Devolver Disponivel
    @Test
    public void testDevolverLivroDisponivel() {
        livro.setEstado(LivroEstadoDisponivel.getInstance());
        assertFalse(livro.devolver());
        assertEquals(LivroEstadoDisponivel.getInstance(), livro.getEstado());
    }

    // Renovar Disponivel

    @Test
    public void testLivroDisponivelTentarRenovarEmprestimo() {
        livro.setEstado(LivroEstadoDisponivel.getInstance());
        assertFalse(livro.renovarEmprestimo());
        assertEquals(LivroEstadoDisponivel.getInstance(), livro.getEstado());
    }

    // RenovarEmprestimo - Renovar Emprestimo
    @Test
    public void testRenovarEmprestimoLivroJaRenovado() {
        livro.setEstado(LivroEstadoEmprestimoRenovado.getInstance());
        assertFalse(livro.renovarEmprestimo());
        assertEquals(LivroEstadoEmprestimoRenovado.getInstance(), livro.getEstado());

    }

    // Emprestar - RenovarEmprestimo
    @Test
    public void testEmprestarLivroEmprestimoRenovado() {
        livro.setEstado(LivroEstadoEmprestimoRenovado.getInstance());
        assertFalse(livro.emprestar());
        assertEquals(LivroEstadoEmprestimoRenovado.getInstance(), livro.getEstado());

    }

    // Devolver - RenovarEmprestimo
    @Test
    public void testDevolverLivroEmprestimoRenovado() {
        livro.setEstado(LivroEstadoEmprestimoRenovado.getInstance());
        assertTrue(livro.devolver());
        assertEquals(LivroEstadoDevolvido.getInstance(), livro.getEstado());

    }

    // Disponivel - RenovarEmprestimo
    @Test
    public void testDisponivelLivroEmprestimoRenovado() {
        livro.setEstado(LivroEstadoEmprestimoRenovado.getInstance());
        assertFalse(livro.disponivel());
        assertEquals(LivroEstadoEmprestimoRenovado.getInstance(), livro.getEstado());

    }
    // Reservado - RenovarEmprestimo

    @Test
    public void testReservarLivroDisponivelEmprestimoRenovado() {
        livro.setEstado(LivroEstadoEmprestimoRenovado.getInstance());
        assertFalse(livro.reservar());
        assertEquals(LivroEstadoEmprestimoRenovado.getInstance(), livro.getEstado());

    }

    // RenovarEmprestimo - Reservado
    @Test
    public void testLivroReservadoRenovarEmprestimo() {
        livro.setEstado(LivroEstadoReservado.getInstance());
        assertFalse(livro.renovarEmprestimo());
        assertEquals(LivroEstadoReservado.getInstance(), livro.getEstado());

    }

    // Emprestar - Reservado
    @Test
    public void testEmprestarLivroReservado() {
        livro.setEstado(LivroEstadoReservado.getInstance());
        assertTrue(livro.emprestar());
        assertEquals(LivroEstadoEmprestado.getInstance(), livro.getEstado());

    }

    // Devolver - Reservado
    @Test
    public void testLivroReservadoDevolvido() {
        livro.setEstado(LivroEstadoReservado.getInstance());
        assertFalse(livro.devolver());
        assertEquals(LivroEstadoReservado.getInstance(), livro.getEstado());

    }

    // Disponivel - Reservado
    @Test
    public void testLivroReservadoDisponivel() {
        livro.setEstado(LivroEstadoReservado.getInstance());
        assertTrue(livro.disponivel());
        assertEquals(LivroEstadoDisponivel.getInstance(), livro.getEstado());

    }
    // Reservado - Reservado

    @Test
    public void testReservarLivroReservado() {
        livro.setEstado(LivroEstadoReservado.getInstance());
        assertFalse(livro.reservar());
        assertEquals(LivroEstadoReservado.getInstance(), livro.getEstado());

    }

    // Disponivel - Emprestado
    @Test
    public void testDisponibilidadeLivroEmprestado() {
        livro.setEstado(LivroEstadoEmprestado.getInstance());
        assertFalse(livro.disponivel());
        assertEquals(LivroEstadoEmprestado.getInstance(), livro.getEstado());
    }

    // Devolvido Emprestado
    @Test
    public void testDevolverLivroEmprestado() {
        livro.setEstado(LivroEstadoEmprestado.getInstance());
        assertTrue(livro.devolver());
        assertEquals(LivroEstadoDevolvido.getInstance(), livro.getEstado());
    }

    // Reservado Emprestado
    @Test
    public void testReservarLivroEmprestado() {
        livro.setEstado(LivroEstadoEmprestado.getInstance());
        assertFalse(livro.reservar());
        assertEquals(LivroEstadoEmprestado.getInstance(), livro.getEstado());
    }

    // Emprestado Emprestado
    @Test
    public void testEmprestarLivroEmprestado() {
        livro.setEstado(LivroEstadoEmprestado.getInstance());
        assertFalse(livro.emprestar());
        assertEquals(LivroEstadoEmprestado.getInstance(), livro.getEstado());
    }

    // Renovar Emprestimo livro Emprestado
    @Test
    public void testRenovarEmprestimoLivroEmprestado() {
        livro.setEstado(LivroEstadoEmprestado.getInstance());
        assertTrue(livro.renovarEmprestimo());
        assertEquals(LivroEstadoEmprestimoRenovado.getInstance(), livro.getEstado());
    }

    // Emprestar Devolvido
    @Test
    public void testEmprestarLivroDevolvido() {
        livro.setEstado(LivroEstadoDevolvido.getInstance());
        assertFalse(livro.emprestar());
        assertEquals(LivroEstadoDevolvido.getInstance(), livro.getEstado());
    }

    // Renovar emprestimo Devolvido
    @Test
    public void testRenovarLivroDevolvido() {
        livro.setEstado(LivroEstadoDevolvido.getInstance());
        assertFalse(livro.renovarEmprestimo());
        assertEquals(LivroEstadoDevolvido.getInstance(), livro.getEstado());
    }

    // Disponibilidade de Devolvido
    @Test
    public void testDisponibilidadeLivroDevolvido() {
        livro.setEstado(LivroEstadoDevolvido.getInstance());
        assertTrue(livro.disponivel());
        assertEquals(LivroEstadoDisponivel.getInstance(), livro.getEstado());
    }

    // Reservar Devolvido
    @Test
    public void testReservarLivroDevolvido() {
        livro.setEstado(LivroEstadoDevolvido.getInstance());
        assertFalse(livro.reservar());
        assertEquals(LivroEstadoDevolvido.getInstance(), livro.getEstado());
    }
    // Devolver Devolvido

    @Test
    public void testDevolverLivroDevolvido() {
        livro.setEstado(LivroEstadoDevolvido.getInstance());
        assertFalse(livro.devolver());
        assertEquals(LivroEstadoDevolvido.getInstance(), livro.getEstado());
    }

    @Test
    public void testLivroEmprestarReservado() {
        Livro livro = new Livro();
        livro.reservar();
        assertTrue(livro.emprestar());
        assertEquals("Emprestado", livro.getNomeEstado());
    }

    @Test
    public void testLivroDevolver() {
        Livro livro = new Livro();
        livro.emprestar();
        assertTrue(livro.devolver());
        assertEquals("Devolvido", livro.getNomeEstado());
    }

    @Test
    public void testLivroDevolverDisponivel() {
        Livro livro = new Livro();
        assertFalse(livro.devolver());
        assertEquals("Disponível", livro.getNomeEstado());
    }

    @Test
    public void testLivroReservar() {
        Livro livro = new Livro();
        assertTrue(livro.reservar());
        assertEquals("Reservado", livro.getNomeEstado());
    }

    @Test
    public void testLivroReservarEmprestado() {
        Livro livro = new Livro();
        livro.emprestar();
        assertFalse(livro.reservar());
        assertEquals("Emprestado", livro.getNomeEstado());
    }

    @Test
    public void testLivroRenovarEmprestimoDisponivel() {
        Livro livro = new Livro();
        assertFalse(livro.renovarEmprestimo());
        assertEquals("Disponível", livro.getNomeEstado());
    }

    @Test
    public void testLivroEmprestimoRenovadoDevolver() {
        Livro livro = new Livro();
        livro.emprestar();
        livro.renovarEmprestimo();
        assertTrue(livro.devolver());
        assertEquals("Devolvido", livro.getNomeEstado());
    }

    @Test
    public void testLivroEmprestimoRenovadoDisponivel() {
        Livro livro = new Livro();
        livro.emprestar();
        livro.renovarEmprestimo();
        assertFalse(livro.disponivel());
        assertEquals("Empréstimo Renovado", livro.getNomeEstado());
    }

    @Test
    public void testLivroReservadoEmprestar() {
        Livro livro = new Livro();
        livro.reservar();
        assertTrue(livro.emprestar());
        assertEquals("Emprestado", livro.getNomeEstado());
    }

    @Test
    public void testDevolverLivro() {
        Livro livro = new Livro();
        livro.emprestar();
        assertTrue(livro.devolver());
        assertTrue(livro.disponivel());
        assertEquals("Disponível", livro.getNomeEstado());
    }

    @Test
    public void testDevolverLivroAposRenovarEmprestimo() {
        Livro livro = new Livro();
        livro.emprestar();
        livro.renovarEmprestimo();
        assertTrue(livro.devolver());
        assertTrue(livro.disponivel());
        assertEquals("Disponível", livro.getNomeEstado());
    }

    @Test
    public void testEmprestarLivroJaEmprestado() {
        Livro livro = new Livro();
        livro.emprestar();
        assertFalse(livro.emprestar());
        assertEquals("Emprestado", livro.getNomeEstado());
    }

    @Test
    public void testReservarLivroJaEmprestado() {
        Livro livro = new Livro();
        livro.emprestar();
        assertFalse(livro.reservar());
        assertEquals("Emprestado", livro.getNomeEstado());
    }

    @Test
    public void testLivroEstadoDisponivelEmprestar() {
        Livro livro = new Livro();
        assertFalse(livro.disponivel());
        assertTrue(livro.emprestar());
        assertEquals("Emprestado", livro.getNomeEstado());
    }

    @Test
    public void testLivroEstadoDisponivelEmprestar2() {
        Livro livro = new Livro();
        assertFalse(livro.disponivel());
        assertTrue(livro.emprestar());
        assertEquals("Emprestado", livro.getNomeEstado());
    }



    @Test
    public void testLivroEstadoDisponivelRenovar() {
        Livro livro = new Livro();
        assertFalse(livro.disponivel());
        assertFalse(livro.renovarEmprestimo());
        assertEquals("Disponível", livro.getNomeEstado());
    }

    @Test
    public void testLivroEstadoEmprestadoDevolver() {
        Livro livro = new Livro();
        assertFalse(livro.disponivel());
        assertTrue(livro.emprestar());
        assertEquals("Emprestado", livro.getNomeEstado());
        assertTrue(livro.devolver());
        assertEquals("Devolvido", livro.getNomeEstado());
    }

    @Test
    public void testLivroEstadoEmprestadoRenovar() {
        Livro livro = new Livro();
        assertFalse(livro.disponivel());
        assertTrue(livro.emprestar());
        assertEquals("Emprestado", livro.getNomeEstado());
        assertTrue(livro.renovarEmprestimo());
        assertEquals("Empréstimo Renovado", livro.getNomeEstado());
    }

    @Test
    public void testLivroEstadoEmprestadoReservar() {
        Livro livro = new Livro();
        assertFalse(livro.disponivel());
        assertTrue(livro.emprestar());
        assertEquals("Emprestado", livro.getNomeEstado());
        assertFalse(livro.reservar());
        assertEquals("Emprestado", livro.getNomeEstado());
    }

    @Test
    public void testLivroEstadoEmprestadoEmprestar() {
        Livro livro = new Livro();
        assertFalse(livro.disponivel());
        assertTrue(livro.emprestar());
        assertEquals("Emprestado", livro.getNomeEstado());
        assertFalse(livro.emprestar());
        assertEquals("Emprestado", livro.getNomeEstado());
    }

    @Test
    public void testLivroEstadoEmprestadoDevolverEmprestado() {
        Livro livro = new Livro();
        assertFalse(livro.disponivel());
        assertTrue(livro.emprestar());
        assertEquals("Emprestado", livro.getNomeEstado());
        assertTrue(livro.devolver());
        assertEquals("Devolvido", livro.getNomeEstado());
        assertFalse(livro.devolver());
        assertEquals("Devolvido", livro.getNomeEstado());
    }

    @Test
    public void testLivroEstadoReservadoEmprestar() {
        Livro livro = new Livro();
        assertTrue(livro.emprestar());
        assertFalse(livro.reservar());
        assertEquals("Emprestado", livro.getNomeEstado());
        assertFalse(livro.emprestar());
        assertEquals("Emprestado", livro.getNomeEstado());
    }

}
package br.com.alexmarques.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CadastroPessoasTest {

    @Test
    @DisplayName("Deve criar o cadastro de pessoas")
    public void deveCriarOCadastroDePessoas(){
        // cenário e execução
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
         // Verificação
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();
    }

    @Test
    @DisplayName("Deve adicionar uma pessoa por vez")
    public void deveAdicionarUmaPessoa(){
        Pessoa pessoa = new Pessoa();

        CadastroPessoas cadastroPessoas = new CadastroPessoas();

        pessoa.setNome("Alex");
        cadastroPessoas.adicionar(pessoa);

        Assertions.assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test
    @DisplayName("Não deve adicionar pessoa com nome vazio")
    public void naoDeveAdicionarPessoaComNomeVazio(){
        // cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        // execução
        org.junit.jupiter.api.Assertions.assertThrows(PessoaSemNomeException.class, () -> cadastroPessoas.adicionar(pessoa) );
    }

    @Test
    @DisplayName("Deve remover uma só pessoa")
    public void deveRemoverUmaPessoa(){
        // cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Alex");
        cadastroPessoas.adicionar(pessoa);
        // execução
        cadastroPessoas.remover(pessoa);
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();

    }

    @Test
    @DisplayName("Deve exibir erro ao tentar remover pessoa inexistente")
    public void deveLancarErroAoTentarRemoverPessoaInexistente(){
        // cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        // execução
        org.junit.jupiter.api.Assertions.assertThrows(CadastroVazioException.class, () -> cadastroPessoas.remover(pessoa) );
    }

}

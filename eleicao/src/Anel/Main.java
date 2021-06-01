package Anel;

/**
 * Cenário / Funcionamento
 *
 * - Vários processos trabalhando em paralelo;
 *
 * - Um dos processos é o coordenador;
 *
 * - Todos os outros processos fazem requisições apenas ao coordenador;
 *
 * - Se em algum momento um processo fazer uma requisição ao coordenador e o
 *   coordenador não conseguir recebê-la significa que o coordenador está morto ou
 *   inativo;
 *
 * - Nesse caso o processo que realizou a requisição não recebida começa uma eleição
 *   para definir o novo coordenador.
 *
 */
public class Main {
    public static void main(String[] args) {
        Anel anelLogico = new Anel();

        anelLogico.criaProcessos();
        anelLogico.fazRequisicoes();
        anelLogico.inativaCoordenador();
        anelLogico.inativaProcesso();
    }
}

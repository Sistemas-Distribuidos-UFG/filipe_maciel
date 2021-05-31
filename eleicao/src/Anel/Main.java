package Anel;

public class Main {
    public static void main(String[] args) {
        Anel anelLogico = new Anel();

        anelLogico.criaProcessos();
        anelLogico.fazRequisicoes();
        anelLogico.inativaCoordenador();
        anelLogico.inativaProcesso();
    }
}

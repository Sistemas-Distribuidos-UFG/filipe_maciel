package Bully;


/**
 * Configurações gerais da aplicação.
 * @author Vinícius R. Biavatti
 */
public class Config {

    /**
     * Delay para a criação de cada processo. (Milisegundos)
     */
    public static final int DELAY_CRIAR_PROCESSO = 3 * 1000;

    /**
     * Delay para matar processo. (Milisegundos)
     */
    public static final int DELAY_MATAR_PROCESSO = 8 * 1000;

    /**
     * Delay para matar coordenador. (Milisegundos)
     */
    public static final int DELAY_MATAR_COORDENADOR = 10 * 1000;

    /**
     * Delay de execução de processo. (Milisegundos)
     */
    public static final int DELAY_EXECUCAO = 2 * 1000;

    /**
     * Delay para imprimir situação dos processos. (Milisegundos)
     */
    public static final int DELAY_IMPRIMIR_PROCESSOS = 1 * 1000;

    /**
     * Quantidade de IDs disponíveis para geração de PID de processo.
     */
    public static final int ID_MAX_PROCESSO = 9999;

}
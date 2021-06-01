package Anel;

import java.util.ArrayList;
import java.util.Random;

/**
 *  * Especificações
 *  *  1. a cada 30 segundos um novo processo deve ser criado;
 *  *  2. a cada 25 segundos um processo deve fazer uma requisição para o coordenador;
 *  *  3. a cada 100 segundos o coordenador fica inativo;
 *  *  4. a cada 80 segundos um processo da lista de processos fica inativo;
 *
 *  *  5. dois processos não podem ter o mesmo ID;
 *  *  6. dois processos de eleição não podem acontecer simultaneamente.
 */
public class Anel {
    private final int ADICIONA = 3000;
    private final int REQUISICAO = 2500;
    private final int INATIVO_COORDENADOR = 10000;
    private final int INATIVO_PROCESSO = 8000;

    public static ArrayList<Processo> processosAtivos;
    private final Object lock = new Object(); // Bloqueio de acesso à lista de processos ativos, somente um processo por vez. atende ao requisito 6

    public Anel() {
        processosAtivos = new ArrayList<Processo>();
    }

    public void criaProcessos() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        if(processosAtivos.isEmpty()) {
                            processosAtivos.add(new Processo(1, true));
                        } else {
                          processosAtivos.add(new Processo(
                             processosAtivos.get(processosAtivos.size() - 1).getPid() + 1, false
                          ));
                        }
                        System.out.println("Processo - "+ processosAtivos.get(processosAtivos.size() - 1).getPid() + " Criado");
                    }

                    try{
                        Thread.sleep(ADICIONA);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void fazRequisicoes() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try{
                        Thread.sleep(REQUISICAO);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }

                    synchronized (lock) {
                        if(processosAtivos.size() > 0) {
                            int indexProcessoAleatorio = new Random().nextInt(processosAtivos.size());

                            Processo processoRequisita = processosAtivos.get(indexProcessoAleatorio);
                            System.out.println("Processo - "+ processoRequisita.getPid() + " fez requisicao");
                            processoRequisita.enviarRequisicao();
                        }
                    }
                }
            }
        }).start();
    }

    public void inativaProcesso() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try{
                        Thread.sleep(INATIVO_PROCESSO);
                    }catch(Exception e) {
                        e.printStackTrace();
                    }

                    synchronized (lock) {
                        if(!processosAtivos.isEmpty()) {
                            int indexProcessoAleatorio = new Random().nextInt(processosAtivos.size());
                            Processo pRemover = processosAtivos.get(indexProcessoAleatorio);
                            if(pRemover != null && !pRemover.isEhCoordenador()) {
                                processosAtivos.remove(pRemover);
                                System.out.println("Processo - "+ pRemover.getPid() + " inativado.");
                            }
                        }
                    }
                }
            }
        }).start();
    }

    public void inativaCoordenador() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(INATIVO_COORDENADOR);
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (lock) {
                        Processo coordenador = null;
                        for(Processo p : processosAtivos) {
                            if(p.isEhCoordenador()) {
                                coordenador = p;
                            }
                        }

                        if(coordenador != null) {
                            processosAtivos.remove(coordenador);
                            System.out.println("Processo Coordenador - " + coordenador.getPid() + " inativado");
                        }
                    }
                }
            }
        }).start();
    }
}

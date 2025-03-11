import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String [] candidatos= {"FELIPE","MARCIA","LUCAS","JOAO","DANIEL"};
        for(String candidato:candidatos){
            entrandoEmContato(candidato);
        }

    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas=1;
        boolean continuarTentando= true;
        boolean atendeu= false;
        do{
            atendeu= atender();
            continuarTentando= !atendeu;
            if(continuarTentando){
                tentativasRealizadas++;
            }else{
                System.out.println("Contato realizado com sucesso");
            }
        }while(continuarTentando && tentativasRealizadas<3);
        if(atendeu){
            System.out.println("Conseguimos contato com o candidato: "+candidato + "Na tentativa: "+tentativasRealizadas+"Tentativa");
        }else{
            System.out.println("Não conseguimos contato com o candidato: "+candidato +" O número máximo de tentativas é: "+tentativasRealizadas);
        }
    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void selecaoCadidatos(){
        String [] candidatos ={"FELIPE","MARCIA","LUCAS","JOAO","DANIEL","PAULO","CARLOS","FABRICIO","MIRELA","DANIELA","JORGE"};
        int candidatosSelecionados=0;
        int candidatosAtual=0;
        double salarioBase=2000.0;
        while(candidatosSelecionados<5 && candidatosAtual<candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("Candidato: "+candidato+" Salario Pretendido: "+salarioPretendido);
            if(salarioPretendido<salarioBase){
                System.out.println("Candidato: "+candidato+" foi selecionado ");
                candidatosSelecionados++;

            }
            candidatosAtual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void analisarCandidato(double salarioPretendido){
        double salarioBase =2000.0;
        if(salarioBase>salarioPretendido){
            System.out.println("Ligar para o candidato");
        }else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para candidato com contra proposta");
        }else{
            System.out.println("Aguardando resultado do demais candidatos");
        }
    }
}
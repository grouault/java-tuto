package test;

import java.util.Scanner;
import metier.Compte;
import metier.IMetierBanque;
import metier.MetierBanqueImpl;

public class Application {

    public static void main(String[] args) {
        new Application().start();
    }

    private void start() {
        System.out.println("démarrage de l'application");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Donner le code du compte : ");
        long code = scanner.nextLong();
        System.out.println("Donner le solde initial du compte : ");
        double solde = scanner.nextDouble();

        IMetierBanque metierBanque = new MetierBanqueImpl();
        metierBanque.addCompte(new Compte(code, solde));

        while (true) {
            try {
                System.out.println("Type d'opération : ");
                String type = scanner.next();
                if (type.equals("q")) {
                    break;
                }
                System.out.println("Montant de l'opération : ");
                double montant = scanner.nextDouble();
                if (type.equals("v")) {
                    metierBanque.verser(code, montant);
                }
                else if (type.equals("r")) {
                    metierBanque.retirer(code, montant);
                }
                Compte compte = metierBanque.consulter(code);
                System.out.println("Etat du compte : " + compte);
            } catch (Exception e) {
                System.out.println(e.getMessage());;
            }
        }
        System.out.println("Fin de l'application");
    }

}

package aspects;

import metier.Compte;
import metier.IMetierBanque;
import metier.MetierBanqueImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PatchRetraitAspect {

    @Pointcut("execution(* metier.MetierBanqueImpl.retirer(..))")
    public void pc1() {
    }

    @Around("pc1() && args(code, montant)")
    public Object autourRetirer(Long code, double montant, ProceedingJoinPoint pj, JoinPoint jp) throws  Throwable{
        IMetierBanque metierBanque = (MetierBanqueImpl)jp.getTarget();
        Compte compte = metierBanque.consulter(code);
        if (compte.getSolde() < montant)
            throw new RuntimeException("Opération impossible : le solde est insuffisant");
        Object value = pj.proceed();
        return  value;
    }

}

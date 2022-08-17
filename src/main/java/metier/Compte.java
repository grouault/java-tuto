package metier;

import java.util.StringJoiner;

public class Compte {

    private Long code;

    private Double solde;

    public Compte() {
    }

    public Compte(Long code, Double solde) {
        this.code = code;
        this.solde = solde;
    }

    public Long getCode() {
        return code;
    }

    public Compte setCode(Long code) {
        this.code = code;
        return this;
    }

    public Double getSolde() {
        return solde;
    }

    public Compte setSolde(Double solde) {
        this.solde = solde;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Compte.class.getSimpleName() + "[", "]")
                .add("code=" + code)
                .add("solde=" + solde)
                .toString();
    }

}

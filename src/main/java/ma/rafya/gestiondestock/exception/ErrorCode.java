package ma.rafya.gestiondestock.exception;

public enum ErrorCode {

    ARTIICLE_NOT_FOUND(1000),
    CATEGORY_NOT_FOUND(2000),
    CLIENT_NOT_FOUND(3000),
    COMMANDE_CLIENT_NOT_FOUND(4000),
    COMMANDE_FOURNISSEUR_FOUND (5000),
    LIGNE_COMMANDE_CLIENT_NOT_FOUND(6000),
    LIGNE_COMMANDE_FOURNISSEUR_NOT_FOUND(7000),
    ENTREPRISE_NOT_FOUND(8000),
    LIGNE_VENTE_NOT_FOUND(9000),
    MVTSTK_NOT_FOUND(10000),
    UTILISATEUR_NOT_FOUND(11000),
    ROLE_NOT_FOUND(12000),
    VENTE_NOT_FOUND(13000),
    FOURNISSEUR_NOT_FOUND(14000);

    private int code  ;

     ErrorCode(int code ){
        this.code=code ;
    }
    int getCode(){
         return code ;
    }
}

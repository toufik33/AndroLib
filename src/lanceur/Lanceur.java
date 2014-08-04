package lanceur;



import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import javafx.stage.Stage;


import org.librairiejpa.ihm.JavaFxPersonne;



public class Lanceur extends Application {

    public static void main(String[] args) {
        Application.launch(Lanceur.class, args);
    }
     
    @Override
    public void start(Stage lanceur) {
    	lanceur.setTitle("Saisie d'un nouvel utilisateur");
        Group root = new Group();
        Scene scene = new Scene(root, 550, 500, Color.WHITE);
        
        JavaFxPersonne javaFxErsonne = new JavaFxPersonne();//Création de l'objet personne IHM
        root.getChildren().add(javaFxErsonne);
       // root.getChildren().add(javaFxErsonne);
        
        lanceur.setScene(scene);

        lanceur.show();
    }// la method start(Stage)

	
}//
// TODO Auto-generated method stubEnti
// EntityManagerFactory
// emf=Persistence.createEntityManagerFactory("librairiejpa");
// EntityManager em = emf.createEntityManager();
//
// // DEBUT premiers tests
// Utilisateur personne = em.find(Utilisateur.class, 1);
// System.out.println("Personne.nom="+personne.getUtilisateurNom());
// /*
// Query query1 =
// em.createQuery("select u from Utilisateur u where u.utilisateurNom='Nono'");
// Utilisateur personne2 = (Utilisateur) query1.getSingleResult();
// if (personne2 == null) {
// System.out.println("Personne non trouvée");
// } else {
// System.out.println("Personne.nom=" + personne2.getUtilisateurNom());
// }
// */
// Query query2 = em.createQuery("select u.utilisateurNom from Utilisateur u");
// List noms = query2.getResultList();
// for (Object nom : noms) {
// System.out.println("nom = "+nom);
// }
// // FIN premiers tests
//
//
// EntityTransaction transac = em.getTransaction();
// //Query req = em.createQuery("Select u from Utilisateur u");
//
// TypedQuery<Utilisateur> query = em.createNamedQuery("Utilisateur.findAll",
// Utilisateur.class);
// List<Utilisateur> results = query.getResultList();
//
// System.out.println("Liste la table utilisateur avant modif");
// ListerUtilsateur(results);

// transac.begin();

// TODO Ajouter un utilisateur

// User user = new User("",15280, "","testLogin", "testNom","12345", "","", "");
/*
 * User user = new User("testLogin","12345");
 * 
 * user.save();
 */
// Utilisateur nouvelUtilisateur = new Utilisateur();
// nouvelUtilisateur.setUtilisateurNom("testNom");
// nouvelUtilisateur.setUtilisateurLogin("testLogin");
// nouvelUtilisateur.setUtilisateurPass("12345");
// em.persist(nouvelUtilisateur);
//
// //TODO Update utilisateur
// Utilisateur updateUtisateur =em.find(Utilisateur.class, 1);
// updateUtisateur.setUtilisateurPass("newpass");
// //updateUtisateur.setEmail("updateutil@yahoo.fr");

// transac.commit();
/*
 * List<Utilisateur> results2 = user.getAllUtilisateur();
 * System.out.println("Liste la table utilisateur aprés modif");
 * ListerUtilsateur(results2);
 */
//
// //TODO Fermeture
// em.close();
// emf.close();
// }
/*
 * static void ListerUtilsateur(List<Utilisateur> results){
 * 
 * for (Utilisateur util : results){
 * System.out.println("id nom login password email =  "
 * +util.getUtilisateurLogin()+" " +util.getUtilisateurPwd()); }
 * 
 * }
 */
// }

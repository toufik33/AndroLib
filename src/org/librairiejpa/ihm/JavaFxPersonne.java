package org.librairiejpa.ihm;

import org.librairiejpa.bo.JpaPersonne;
import org.librairiejpa.bo.JpaUtilisateur;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.GridPane;

public class JavaFxPersonne extends Parent {

	private TextField textLogin = new TextField();
	private TextField textPwd = new TextField();
	private TextField textNom = new TextField();
	private TextField textPrenom = new TextField();
	private TextField textTel = new TextField();
	private TextField textEmail = new TextField();
	private TextField textAdresse = new TextField();
	private TextField textAdresseCp = new TextField();
	private TextField textCp = new TextField();
	private TextField textVille = new TextField();
	private GridPane gridpane = new GridPane();
	
	/**
	 * Instanciation de la classe JavaFxPersonne Construction de la fenêtre.
	 */
	public JavaFxPersonne() {

		
		
		Label labelLogin = new Label();
		labelLogin.setText("Login : ");
		labelLogin.setMaxSize(125, 125);

		textLogin.setMaxSize(125, 125);
		textLogin.setText("Saisire le login");

		gridpane.add(labelLogin, 0, 0);
		gridpane.add(textLogin, 1, 0);

		Label labelPwd = new Label();
		labelPwd.setText("   Mot de passe : ");
		labelPwd.setMaxSize(125, 125);

		textPwd.setMaxSize(125, 125);
		textPwd.setText("Saisire le pwd");

		gridpane.add(labelPwd, 2, 0);
		gridpane.add(textPwd, 3, 0);

		Label labelNom = new Label();
		labelNom.setText("Nom : ");
		labelNom.setMaxSize(125, 125);

		textNom.setMaxSize(125, 125);
		textNom.setText("Saisire le nom");

		gridpane.add(labelNom, 0, 1);
		gridpane.add(textNom, 1, 1);

		Label labelPrenom = new Label();
		labelPrenom.setText("   Prénom : ");
		labelPrenom.setMaxSize(125, 125);

		textPrenom.setMaxSize(125, 125);
		textPrenom.setText("Saisire le prénom");

		gridpane.add(labelPrenom, 2, 1);
		gridpane.add(textPrenom, 3, 1);

		Label labelTel = new Label();
		labelTel.setText("Tél : ");
		labelTel.setMaxSize(125, 125);

		textTel.setMaxSize(125, 125);
		textTel.setText("Saisire le tel");

		gridpane.add(labelTel, 0, 2);
		gridpane.add(textTel, 1, 2);

		Label labelEmail = new Label();
		labelEmail.setText("   Email : ");
		labelEmail.setMaxSize(125, 125);

		textEmail.setMaxSize(125, 125);
		textEmail.setText("Saisire l'Email");

		gridpane.add(labelEmail, 2, 2);
		gridpane.add(textEmail, 3, 2);

		Label labelAdresse = new Label();
		labelAdresse.setText("Adresse : ");
		labelAdresse.setMaxSize(125, 125);

		textAdresse.setMinSize(150, 0);
		textAdresse.setText("Saisire l'adresse");

		gridpane.add(labelAdresse, 0, 3);
		GridPane.setColumnSpan(textAdresse, 3);
		gridpane.add(textAdresse, 1, 3);

		Label labelAdresseCp = new Label();
		labelAdresseCp.setText("Adresse Cp : ");
		labelAdresseCp.setMaxSize(125, 125);

		textAdresseCp.setMinSize(150, 0);
		textAdresseCp.setText("Saisire l'adresse complémentaire");

		gridpane.add(labelAdresseCp, 0, 4);
		GridPane.setColumnSpan(textAdresseCp, 3);
		gridpane.add(textAdresseCp, 1, 4);

		Label labelCp = new Label();
		labelCp.setText("Code Postal : ");
		labelCp.setMaxSize(125, 125);

		textCp.setMaxSize(125, 125);
		textCp.setText("Saisire le CP");

		gridpane.add(labelCp, 0, 5);
		gridpane.add(textCp, 1, 5);

		Label labelVille = new Label();
		labelVille.setText("   Ville : ");
		labelVille.setMaxSize(125, 125);

		textVille.setMaxSize(125, 125);
		textVille.setText("Saisire la ville");

		gridpane.add(labelVille, 2, 5);
		gridpane.add(textVille, 3, 5);

		this.getChildren().add(gridpane);
		
		this.setTranslateX(25);
		this.setTranslateY(25);

		Button btnSave = new Button();
		btnSave.setText("Sauvegarder");

		btnSave.setLayoutX(170);
		btnSave.setLayoutY(160);

		btnSave.setOnMouseClicked(new EventHandler<MouseEvent>() {// Création de
																	// l'évenement
																	// onclick
																	// sur le
																	// bouton
			public void handle(MouseEvent me) {
				// instructions à exécuter lors de cet événement
				save();

			}
		});
//System.exit(0);
		this.getChildren().add(btnSave);

	}

	/**
 * 
 */
	public void save() {
		JpaPersonne jpaPersonne = new JpaPersonne(textNom.getText(),
				textPrenom.getText(), textTel.getText(), textEmail.getText(),
				textAdresse.getText(), textAdresseCp.getText(),
				Integer.parseInt(textCp.getText()), textVille.getText());
		JpaUtilisateur user = new JpaUtilisateur(textLogin.getText(), textPwd.getText(),
				jpaPersonne);
		user.savePersonneAndUser();

		textLogin.setText("");
		textPwd.setText("");
		textNom.setText("");
		textPrenom.setText("");
		textTel.setText("");
		textEmail.setText("");
		textAdresse.setText("");
		textAdresseCp.setText("");
		textCp.setText("");
		textVille.setText("");

	}

}

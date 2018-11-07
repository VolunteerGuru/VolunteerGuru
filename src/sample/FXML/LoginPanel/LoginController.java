/******************************************************************************
 * Last Edit: 10/8/2018
 *
 * Class: CEN 3031 - CRN 80594 - Software Engng. Fundamentals
 * Group 4. Volunteer Guru
 *
 * File Summary: Handles the program's I/O while maintains any state changes of a panel.
 ******************************************************************************/

package sample.FXML.LoginPanel;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.FXML.HomePanel.tabController.HomeController;
import sample.users.database.DataBase;

public class LoginController extends HomeController {

	/* ID/Variable Declarations */
	private Stage stage;
	@FXML private Button btn_Login;
	@FXML private Button btn_SignUpLG;
	@FXML private TextField userNameField;
	@FXML private TextField passwordField;
	@FXML private Label lbl_LoginError;

	/* Methods / Events*/

	//LoginPanel functions
	@FXML
	private void loginBTNClicked() throws IOException {
		System.out.println("[Event](Login Clicked)");
		boolean exists = DataBase.accountExists(userNameField.getText(), passwordField.getText());
		if (exists) {
			stage = (Stage) btn_Login.getScene().getWindow();
			stage.close();
			System.out.println("Valid");
		}

		if (userNameField.getText().isEmpty()||passwordField.getText().isEmpty()){
			lbl_LoginError.setText("Please enter a Username/Password.");
		}else {
			lbl_LoginError.setText("Invalid Username/Password.");
		}
	}

	@FXML //Change homePanel -> signUp.fxml
	private void signUpBTNClickedLG() throws IOException {
		System.out.println("[Event](Sign-Up Clicked)");
		stage = (Stage) btn_SignUpLG.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/sample/FXML/SignUpPanel/signUp.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("SignUp");
		stage.setScene(scene);
	}


}